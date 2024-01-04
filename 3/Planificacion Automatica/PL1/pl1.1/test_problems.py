import os
import glob
import re
import datetime
import matplotlib.pyplot as plt
import numpy as np
from os import system

# Import the planners
from planners_usage import *

# Regex to get the problem number
re_num = r"\.(\d+)(\.|$)"

# The domain file (same for all the problems, hard-coded)
domain = "./domine.pddl"

# Load the configuration
[planner, time_limit, max_complexity, verbose] = load_config()

# Statistics obtained for every problem
statistics = []


def select_planner(problem):

	# Select the planner
	if "satplan" == planner:
		return satplan(domain, problem)
	elif "downward" == planner:
		return fast_downward(domain, problem)
	
	elif "lpgtd" == planner:
		return lpgtd(domain, problem)
	elif "ff" == planner:
		return ff(domain, problem)
	elif "sgplan40" == planner:
		return sgplan40(domain, problem)
	else:
		print("El planificador no existe")
		print(planner)
		exit()

def solve(problem):

	# Solve the problem and return the plan

	# Get the plan
	plan = select_planner(problem)
	elapsed_time = round((datetime.datetime.now() - t).total_seconds()) # Stop the timer, time in seconds
	
	# Save the statistics
	statistics.append((problem.replace("./problems/", ""), elapsed_time, len(statistics)+2))
	
	# Return the plan
	return plan
	
def save_plan(plan, problem):

	# Save the plan to a file
	if (verbose):
		print(f"Saving plan for problem {problem}\n")#.replace('.pddl','')
	with open(f"./plans/{problem}.plan", "w") as f:
		for action in plan:
			f.write(action+"\n")

def save_statistics(csv):

	# Save the statistics to a file
	print("---Saving statistics---\n") #Se podría guardar todo en un solo archivo

	# Create the directory if it doesn't exist
	if not os.path.exists(f"./statistics/{planner}"):
		os.makedirs(f"./statistics/{planner}")
	
	# Save the statistics
	f = open(f"./statistics/{planner}/{domain.replace('.pddl','')}_{time_limit}.txt", "w")
	for stat in statistics:
		if (csv):
			f.write(f"{stat[0]},{stat[1]},{stat[2]},{planner};\n")
		else:
			f.write(f"{stat[0]},{stat[1]},{stat[2]},{planner}\n")
		
def generate_problems():
	if (verbose):
		print(f"Generating {max_complexity} problems for the domain {domain}\n")

	# Generate the problems and save them to files
	for i in range(0,int(max_complexity)+1):
		if (verbose):
			os.system(f'python3 generate-problem.py -d 1 -r 0 -l {i} -p {i} -c {i} -g {i} ')
		else:
			os.system(f'python3 generate-problem.py -d 1 -r 0 -l {i} -p {i} -c {i} -g {i} >/dev/null')
		""" time.sleep(0.01) """
		if (verbose):
			print(f"\n---Generated problem {i}---\n")
	if (verbose):
		print(f"Generated {max_complexity} problems for the domain {domain}\n")
	global t
	t = datetime.datetime.now() # Start the timer
	

def sort_key(file_name):
	match=re.search(re_num,file_name)
	if match is None:
		return(0,file_name)
	else:
		return(int(match.group(1)),file_name)

def test_problems():

	print("Testing problems\n")
	
	# Get all the problems
	problems = []

	lis=glob.glob("./problems/*.pddl")
	lis.sort(key=os.path.getmtime)
	for file in lis:
		problems.append(file)

	# Test all the problems
	for problem in problems:
		if(check_time_limit()):
			if (verbose):
				print("Time limit reached\n")
			break
		if (verbose):
			print(f"Testing problem {problem}\n")
		plan = solve(problem)
		problem = problem.replace("./problems/", "")
		if(plan):
			if (verbose):
				print(f"Plan found for problem {problem}\n")
			save_plan(plan, problem)
		else:
			if (verbose):
				print(f"No plan found for problem {problem}\n")
	save_statistics(False) 
	return

def check_time_limit():
	# Check if the time limit has been reached
	return datetime.datetime.now() - t > datetime.timedelta(seconds=int(time_limit))

def generate_graphs():

	print("---Generating graph---\n")
	
	# Get the statistics
	plans = np.array([[item[1], item[2]] for item in statistics], dtype=int) # Convert to numpy array
	plans = plans[plans[:,1].argsort()] # Sort by complexity
	if (verbose):
		print(f"Statistics: {plans}\n")
	
	time = plans[:,0] # Get the time
	complexity = plans[:,1] # Get the complexity
	
	if (verbose):
		print(f"Complexity: {complexity}\n")
  	 
	# Show stats
	plt.plot(complexity, time)
	plt.xlabel("Complejidad del problema")
	plt.ylabel("Segundos")
	plt.savefig(f"./statistics/{planner}/{domain.replace('.pddl','')}_{time_limit}_graph.png") # Save the graph
	if (verbose):
		print("Graph saved\n")


def main():
	system("mkdir ./plans 2> /dev/null")
	system("mkdir ./problems 2> /dev/null")
	system("rm -rf ./plans/*  2> /dev/null")
	system("rm -rf ./problems/* 2> /dev/null")
	generate_problems() # Generate n problems
	test_problems()	# Test the problems
	generate_graphs()	# Generate the graphs

if __name__ == '__main__':
	main()


#TODO hay que probar que funcione con todos los planificadores