#!/usr/bin/env python3
from optparse import OptionParser
import random
import math
import sys

########################################################################################
# Hard-coded options
########################################################################################

# boxs will have different contents, such as food and medicine.
# You can change this to generate other contents if you want.
content_types = ["food", "medicine"]

########################################################################################
# Helper functions
########################################################################################

# this function verifies that the arguments are valid
# if some are missing, it prints an error message and exits
# and returns the options
def handle_args():
	# Take in all arguments and print them to standard output
	parser = OptionParser(usage='python generator.py [-help] options...')
	parser.add_option('-d', '--drones', metavar='NUM', dest='drones', action='store', type=int, help='the number of drones')
	parser.add_option('-r', '--carriers', metavar='NUM', type=int, dest='carriers',
					  help='the number of carriers, for later labs; use 0 for no carriers')
	parser.add_option('-l', '--locations', metavar='NUM', type=int, dest='locations',
					  help='the number of locations apart from the depot ')
	parser.add_option('-p', '--persons', metavar='NUM', type=int, dest='persons', help='the number of persons')
	parser.add_option('-c', '--boxs', metavar='NUM', type=int, dest='boxs', help='the number of boxs available')
	parser.add_option('-g', '--goals', metavar='NUM', type=int, dest='goals',
					  help='the number of boxs assigned in the goal')

	(options, args) = parser.parse_args()
	if options.drones is None:
		print("You must specify --drones (use --help for help)")
		sys.exit(1)

	if options.carriers is None:
		print("You must specify --carriers (use --help for help)")
		sys.exit(1)

	if options.locations is None:
		print("You must specify --locations (use --help for help)")
		sys.exit(1)

	if options.persons is None:
		print("You must specify --persons (use --help for help)")
		sys.exit(1)

	if options.boxs is None:
		print("You must specify --boxs (use --help for help)")
		sys.exit(1)

	if options.goals is None:
		print("You must specify --goals (use --help for help)")
		sys.exit(1)

	if options.goals > options.boxs:
		print("Cannot have more goals than boxs")
		sys.exit(1)

	if len(content_types) > options.boxs:
		print("Cannot have more content types than boxs:", content_types)
		sys.exit(1)

	if options.goals > len(content_types) * options.persons:
		print("For", options.persons, "persons, you can have at most", len(content_types) * options.persons, "goals")
		sys.exit(1)
	return options


def objects_drone(f, drone):
	for x in drone:
		f.write("\t" + x + "_left ")
		f.write(x + "_right ")
	f.write("\n\t")
	return

# this function defines the objects
def objects(f, obj):
	for x in obj:
		f.write(x + " ")
	f.write("\n\t")
	return

# this function defines the initial state of the drones
def init_drones(f, drone):
	for x in drone:
		f.write("\t(gripper " + x + "_left)\n")
		f.write("\t(gripper " + x + "_right)\n")
	f.write("\n")
	return

# this function defines the initial state of elements
def init_objects(f, drone, string):
	for x in drone:
		f.write("\t("+string+" " + x + ")\n")
	f.write("\n")
	return

# this function defines the types of the boxs
def define_box_types(f, boxs, content_types, box):
	# for each box, assign a content type
	for x in range(boxs):
		# assign a content type to the box
		# the assignment is done in a round-robin fashion
		content_name = content_types[(x % len(content_types))]
		f.write("\t(box-type "+box[x]+" "+content_name+")\n")
	f.write("\n")
	return

# this function defines which persons have which contents
def define_person_have(f, options, person, content_types):
	for x in range(options.persons):
		person_name = person[x]
		for y in range(len(content_types)):
			content_name = content_types[y]
			if (x % len(content_types) != y):
				f.write("\t(person-have "+person_name+" "+content_name+")\n")
			else:
				f.write("\t(person-dont-have "+person_name+" "+content_name+")\n")
		
	f.write("\n")
	return



########################################################################################
# Main program
########################################################################################

def main():
	options = handle_args()

	# Print all arguments
	print("Drones\t\t", options.drones)
	print("Carriers\t", options.carriers)
	print("Locations\t", options.locations)
	print("Persons\t\t", options.persons)
	print("boxs\t\t", options.boxs)
	print("Goals\t\t", options.goals)

	# Setup all lists of objects
	drone = []
	person = []
	box = []
	carrier = []
	location = []

	# include the default location
	location.append("location_deposito")

	# generate the names of the objects
	for x in range(options.locations):
		location.append("loc" + str(x + 1))
	for x in range(options.drones):
		drone.append("gripper_" + str(x + 1))
	for x in range(options.carriers):
		carrier.append("carrier" + str(x + 1))
	for x in range(options.persons):
		person.append("person" + str(x + 1))
	for x in range(options.boxs):
		box.append("box" + str(x + 1))


	# Define a problem name
	problem_name = "problem"

	# Open output file
	with open("/home/rufo/JSHOP2/domains/drone/"+problem_name, 'w') as f:
		# Write the initial part of the problem
		f.write("(defproblem problem drone\n\t(\n")
		######################################################################
		# Generate an initial state
		init_drones(f, drone)
		init_objects(f, location, "location")
		init_objects(f, box, "box")
		init_objects(f, content_types, "type")
		init_objects(f, person, "person")

		for x in range(options.drones):
			dron_name = drone[x]
			# Define the initial state of the drones
			f.write("\t(gripper-at "+dron_name+"_left location_deposito)\n")
			f.write("\t(gripper-at "+dron_name+"_right location_deposito)\n\n")
			# Define the initial status of the drones
			f.write("\t(free "+dron_name+"_left)\n")
			f.write("\t(free "+dron_name+"_right)\n\n")
		  	# Define the association between the drones grippers
			f.write("\t(gripper-pair "+dron_name+"_right "+dron_name+"_left)\n")
			f.write("\t(gripper-pair "+dron_name+"_left "+dron_name+"_right)\n\n")

		# Define the type of the boxs
		define_box_types(f, options.boxs, content_types, box)

		# Define the initial location of the boxs
		for x in range(options.boxs):
			box_name = box[x]
			f.write("\t(box-at "+box_name+" location_deposito)\n")
		f.write("\n")
		
		# Define the initial location of the persons (randomly)
		for x in range(options.persons):
			person_name = person[x]	
			rand = location[random.randint(0,  options.locations-1)]
			while (rand == "location_deposito"):
				rand = location[random.randint(0,  options.locations-1)]
			f.write("\t(person-at "+person_name+" "+rand+")\n")
		f.write("\n")	

		# Define what the persons have and what they don't have
		define_person_have(f, options, person, content_types)
		f.write("\t)\n")

		######################################################################
		# Write Goals
		f.write("\t(:unordered\n\t\t\t(enviar-todo)\n\t)\n)\n")

if __name__ == '__main__':
	main()
