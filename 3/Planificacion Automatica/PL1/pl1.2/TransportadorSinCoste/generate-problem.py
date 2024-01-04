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

# We associate each location with x/y coordinates.  These coordinates
# won't actually be used explicitly in the domain, but we *will*
# eventually use them implicitly by using *distances* in order to
# calculate flight times.
#
# This function returns the euclidean distance between two locations.
# The locations are given via their integer index.  You won't have to
# use this other than indirectly through the flight cost function.
def distance(location_coords, location_num1, location_num2):
	x1 = location_coords[location_num1][0]
	y1 = location_coords[location_num1][1]
	x2 = location_coords[location_num2][0]
	y2 = location_coords[location_num2][1]
	return math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)


# This function returns the action cost of flying between two
# locations supplied by their integer indexes.  You can use this
# function when you extend the problem generator to generate action
# costs.
def flight_cost(location_coords, location_num1, location_num2):
	return int(distance(location_coords, location_num1, location_num2)) + 1


# When you run this script you specify the *total* number of boxs
# you want.  The function below determines randomly which boxs
# will have a specific type of contents.  boxs_with_contents[0]
# is a list of boxs containing content_types[0] (in our
# example "food"), and so on.
# Note: Will have at least one box per type!

def setup_content_types(options):
	while True:
		num_boxs_with_contents = []
		boxs_left = options.boxs
		for x in range(len(content_types) - 1):
			types_after_this = len(content_types) - x - 1
			max_now = boxs_left - types_after_this
			# print x, types_after_this, boxs_left, len(content_types), max_now
			num = random.randint(1, max_now)
			# print num
			num_boxs_with_contents.append(num)
			boxs_left -= num
		num_boxs_with_contents.append(boxs_left)
		# print(num_boxs_with_contents)

		# If we have 10 medicine and 4 food, with 7 people,
		# we can support at most 7+4=11 goals.
		maxgoals = sum(min(num_boxs, options.persons) for num_boxs in num_boxs_with_contents)

		# Check if the randomization supports the number of goals we want to generate.
		# Otherwise, try to randomize again.
		if options.goals <= maxgoals:
			# Done
			break

	print()
	print("Types\tQuantities")
	for x in range(len(num_boxs_with_contents)):
		if num_boxs_with_contents[x] > 0:
			print(content_types[x] + "\t " + str(num_boxs_with_contents[x]))

	boxs_with_contents = []
	counter = 1
	for x in range(len(content_types)):
		boxs = []
		for y in range(num_boxs_with_contents[x]):
			boxs.append("box" + str(counter))
			counter += 1
		boxs_with_contents.append(boxs)

	return boxs_with_contents


# This function populates the location_coords list with an X and Y
# coordinate for each location.  You won't have to use this other than
# indirectly through the flight cost function.
def setup_location_coords(options):
	location_coords = [(0, 0)]  # For the depot
	for x in range(1, options.locations + 1):
		location_coords.append((random.randint(1, 200), random.randint(1, 200)))

	print("Location positions", location_coords)
	return location_coords


# This function generates a random set of goals.
# After you run this, need[personid][contentid] is true if and only if
# the goal is for the person to have a box with the specified content.
# You will use this to box goal statements in PDDL.
def setup_person_needs(options, boxs_with_contents):
	need = [[False for i in range(len(content_types))] for j in range(options.persons)]
	goals_per_contents = [0 for i in range(len(content_types))]

	for goalnum in range(options.goals):

		generated = False
		while not generated:
			rand_person = random.randint(0, options.persons - 1)
			rand_content = random.randint(0, len(content_types) - 1)
			# If we have enough boxs with that content
			# and the person doesn't already need that content
			if (goals_per_contents[rand_content] < len(boxs_with_contents[rand_content])
					and not need[rand_person][rand_content]):
				need[rand_person][rand_content] = True
				goals_per_contents[rand_content] += 1
				generated = True
	return need



def init_spaces(f):
	f.write("\t(siguiente n0 n1)\n")
	f.write("\t(siguiente n1 n2)\n")
	f.write("\t(siguiente n2 n3)\n")
	f.write("\t(siguiente n3 n4)\n\n")

	f.write("\t(carga-actual transportador n0)\n\n")

	f.write("\t(transportador transportador)\n\n")

	f.write("\t(transportador-not-carry transportador)\n\n")

	return
def objects_drone(f, drone):
	for x in drone:
		f.write("\t" + x + "_left ")
		#f.write(x + "_right ")
	f.write("\n\t")
	return

def objects_transportador(f, drone):
	f.write("transportador")
	f.write("\n\t")
	f.write("n0 n1 n2 n3 n4")
	f.write("\n\t")
	return

def objects(f, obj):
	for x in obj:
		f.write(x + " ")
	f.write("\n\t")
	return

def init_drones(f, drone):
	for x in drone:
		f.write("\t(gripper " + x + "_left)\n")
		#f.write("\t(gripper " + x + "_right)\n")
	f.write("\n")
	return

def init_objects(f, drone, string):
	for x in drone:
		f.write("\t("+string+" " + x + ")\n")
	f.write("\n")
	return

def define_box_types(f, boxs, content_types, box):
	for x in range(boxs):
		content_name = content_types[(x % len(content_types))]
		f.write("\t(box-type "+box[x]+" "+content_name+")\n")
	f.write("\n")
	return

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

	print("Drones\t\t", options.drones)
	print("Carriers\t", options.carriers)
	print("Locations\t", options.locations)
	print("Persons\t\t", options.persons)
	print("boxs\t\t", options.boxs)
	print("Goals\t\t", options.goals)

	# Setup all lists of objects

	# These lists contain the names ofing statistics--- all Drones, locations, and so on.

	drone = []
	person = []
	box = []
	carrier = []
	location = []

	location.append("location_deposito")
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
	
	# Determine the set of boxs for each content.
	# If content_types[0] is "food",
	# then boxs_with_contents[0] is a list
	# containing the names of all boxs that contain food.
	boxs_with_contents = setup_content_types(options)

	# Generates coordinates for each location.
	# You will only use this indirectly,
	# through the flight_cost() function in lab 2.
	location_coords = setup_location_coords(options)

	# Determine which types of content each person needs.
	# If person[0] is "person0",
	# and content_types[1] is "medicine",
	# then needs[0][1] is true iff person0 needs medicine.
	need = setup_person_needs(options, boxs_with_contents)

	# Define a problem name
	problem_name = "drone_problem_d" + str(options.drones) + "_r" + str(options.carriers) + \
				   "_l" + str(options.locations) + "_p" + str(options.persons) + "_c" + str(options.boxs) + \
				   "_g" + str(options.goals) + "_ct" + str(len(content_types))

	# Open output file
	with open("./problems/"+problem_name + ".pddl", 'w') as f:
		# Write the initial part of the problem

		f.write("(define (problem strips-gripper-x-1)\n")
		f.write("(:domain gripper-strips-typing)\n")
	
		f.write("(:objects\n")

		######################################################################
		# Write objects
		objects_transportador(f, drone)
		objects_drone(f,drone)
		objects(f, location)
		objects(f, box)
		objects(f, content_types)
		objects(f, person)
		objects(f, carrier)
		f.write(")\n")

		######################################################################
		# Generate an initial state
		f.write("(:init\n")
		init_spaces(f)
		init_drones(f, drone)
		init_objects(f, location, "location")
		init_objects(f, box, "box")
		init_objects(f, content_types, "type")
		init_objects(f, person, "person")

		for x in range(options.drones):
			dron_name = drone[x]
			f.write("\t(gripper-at "+dron_name+"_left location_deposito)\n")
			#f.write("\t(gripper-at "+dron_name+"_right location_deposito)\n\n")

			f.write("\t(free "+dron_name+"_left)\n")
			#f.write("\t(free "+dron_name+"_right)\n\n")
		   
			#f.write("\t(gripper-pair "+dron_name+"_right "+dron_name+"_left)\n")
			#f.write("\t(gripper-pair "+dron_name+"_left "+dron_name+"_right)\n\n")

		f.write("\t(transportador-at transportador location_deposito)\n\n")
		define_box_types(f, options.boxs, content_types, box)


		for x in range(options.boxs):
			box_name = box[x]
			f.write("\t(box-at "+box_name+" location_deposito)\n")
		f.write("\n")
		
		for x in range(options.persons):
			person_name = person[x]
			rand = location[random.randint(0,  options.locations-1)]
			while (rand == "location_deposito"):
				rand = location[random.randint(0,  options.locations-1)]
			f.write("\t(person-at "+person_name+" "+rand+")\n")
		f.write("\n")	
		define_person_have(f, options, person, content_types)

		#-----difinir costes-----
		f.write(")\n")

		######################################################################
		# Write Goals

		f.write("(:goal (and\n")
		for x in range(options.persons):
			for y in range(len(content_types)):
				person_name = person[x]
				content_name = content_types[y]
				f.write("\t(person-have "+person_name+" "+content_name+")\n")
		f.write("\t))\n")
		f.write(")")

if __name__ == '__main__':
	main()