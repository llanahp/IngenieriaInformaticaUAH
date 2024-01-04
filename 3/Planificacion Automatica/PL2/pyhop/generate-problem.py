from optparse import OptionParser
import random
import sys
content_types = ['food', 'medicine']


#Parser de los argumentos de entrada
def handle_args():
	parser = OptionParser(usage='python generator.py [-help] options...')
	parser.add_option('-l', '--locations', metavar='NUM', type=int, dest='locations',
					  help='the number of locations apart from the depot ')
	parser.add_option('-p', '--persons', metavar='NUM', type=int, dest='persons', help='the number of persons')
	parser.add_option('-c', '--boxs', metavar='NUM', type=int, dest='boxs', help='the number of boxs available')

	(options, args) = parser.parse_args()

	if options.locations is None:
		print("You must specify --locations (use --help for help)")
		sys.exit(1)

	if options.persons is None:
		print("You must specify --persons (use --help for help)")
		sys.exit(1)

	if options.boxs is None:
		print("You must specify --boxs (use --help for help)")
		sys.exit(1)

	if len(content_types) > options.boxs:
		print("Cannot have more content types than boxs:", content_types)
		sys.exit(1)

	return options


#Funcion que muestra por pantalla los argumentos de entrada
def display_config(options):
    print("\n-------Configuration--------")
    print("\nlocations:", options.locations)
    print("persons:", options.persons)
    print("boxs:", options.boxs)
    print("content_types:", content_types)

# Función para leer la plantilla y devolver su contenido como string
def read_template(file_name):
    with open(file_name, 'r') as template_file:
        return template_file.read()

def set_locations(locations, people, boxes):
	loc = "\"drone\":\"deposito\", "
	for i in range(0, len(people)):
		loc += "\"" + people[i] + "\":" + "\"location" + str(random.randint(1,len(locations))) + "\", "
	for i in range(0, len(boxes)):
		loc += "\"" + boxes[i] + "\":" + "\"deposito\"" + ", "
	loc = loc[:-2]
	return loc

def set_type(boxes):
	type = ""
	for i in range(0, len(boxes)):
		type += "\"" + boxes[i] + "\":" + "\"" + content_types[i%2] + "\", "
	type = type[:-2]
	return type

def set_doesnt_have(people):
	doesnt_have = ""
	for i in range(0, len(people)):
		doesnt_have += "\"" + people[i] + "\":" + "\"" + content_types[i%2] + "\", "
	doesnt_have = doesnt_have[:-2]
	return doesnt_have

def set_has(people):
	has = ""
	content_types.reverse()
	for i in range(0, len(people)):
		has += "\"" +people[i] + "\":" + "\"" + content_types[i%2] + "\", "
	has = has[:-2]
	return has

#Funcion que genera el fichero problema
def generate_problem(options):

	template_1 = read_template('./templates/1.txt')
	template_2 = read_template('./templates/2.txt')
	
	locations = []
	people = []
	boxes = []

	for location in range(1,options.locations+1):
		locations.append("location" + str(location))
	
	for person in range(1,options.persons+1):
		people.append("person" + str(person))
	
	for box in range(1,options.boxs+1):
		boxes.append("box" + str(box))

	problem = open(f"./problems/domine{location}-{person}-{box}.py", "w")
	problem.write(template_1)
	problem.write("state1.loc = {" + set_locations(locations, people, boxes)+"}\n")
	problem.write("state1.type = {" + set_type(boxes) + "}\n")
	problem.write("state1.doesnt_have = {" + set_doesnt_have(people) + "}\n")
	problem.write("state1.has = {" + set_has(people) + "}\n")
	problem.write(template_2)

	problem.close()

	print("\n-----Problem generated successfully-----")
	print("Problem file: ./problems/domine" + str(options.locations) + "-" + str(options.persons) + "-" + str(options.boxs) + ".py\n")


def main():
	options = handle_args()
	display_config(options)
	generate_problem(options)

if __name__ == '__main__':
	main()

