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
domain = "/home/rufo/JSHOP2/domains/drone/drone"

# Load the configuration
[planner, time_limit, max_complexity, verbose] = load_config()

# Statistics obtained for every problem
statistics = []


def select_planner(problem):

	# Select the planner
	if "jshop2" == planner:
		return jshop2(domain, problem)
	else:
		print("El planificador no existe")
		print(planner)
		exit()

def solve(problem, complexity):

	# Solve the problem and return the plan

	# Get the plan
	plan = select_planner(problem)
	elapsed_time = round((datetime.datetime.now() - t).total_seconds()) # Stop the timer, time in seconds
	# Save the statistics  complexity
	statistics.append((problem.replace("/home/rufo/JSHOP2/domains/drone/problem", "problem_"+complexity), elapsed_time, len(statistics)+2))
	# Return the plan
	return plan
	
def save_plan(plan, problem):

	# Save the plan to a file
	if (verbose):
		print(f"Saving plan for problem {problem}\n\n")#.replace('.pddl','')
	
	with open(f"/home/rufo/JSHOP2/automatizacion/plans/problem"+str(problem)+".plan", "w") as f:
		for action in plan:
			f.write(action+"\n")

def save_statistics(csv):

	# Save the statistics to a file
	print("---Saving statistics---\n") #Se podría guardar todo en un solo archivo

	# Create the directory if it doesn't exist
	if not os.path.exists(f"/home/rufo/JSHOP2/automatizacion/statistics/{planner}"):
		os.makedirs(f"/home/rufo/JSHOP2/automatizacion/statistics/{planner}")
	
	# Save the statistics
	f = open(f"/home/rufo/JSHOP2/automatizacion/statistics/{planner}/jshop2_{time_limit}.txt", "w")
	for stat in statistics:
		if (csv):
			f.write(f"{stat[0]},{stat[1]},{stat[2]},{planner};\n")
		else:
			f.write(f"{stat[0]},{stat[1]},{stat[2]},{planner}\n")
		
def generate_problems():
	if (verbose):
		print(f"Generating problem\n")

	global t
	t = datetime.datetime.now()

	# Generate the problems and save them to files
	for i in range(1, int(max_complexity)+1):
		if (verbose):
			os.system(f'python3 generate-problem.py -d 1 -r 0 -l {i} -p {i} -c {i} -g {i} ')
		else:
			os.system(f'python3 generate-problem.py -d 1 -r 0 -l {i} -p {i} -c {i} -g {i} >/dev/null')
		if (verbose):
			print(f"\n---Problem {i} generated---\n")
		if(check_time_limit()):
			if (verbose):
				print("Time limit reached\n")
			break
		problem = "/home/rufo/JSHOP2/domains/drone/problem"
		plan = solve(problem, str(i))
		if(plan):
			save_plan(plan, i)
		else:
			print(f"No plan found for problem {i}\n")
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
	plt.savefig(f"/home/rufo/JSHOP2/automatizacion/statistics/{planner}/jshop2_{time_limit}.png") # Save the graph
	if (verbose):
		print("Graph saved\n")


def main():
	system("mkdir /home/rufo/JSHOP2/automatizacion/plans 2> /dev/null")
	system("mkdir /home/rufo/JSHOP2/automatizacion/statistics 2> /dev/null")
	system("rm -rf /home/rufo/JSHOP2/automatizacion/plans/*  2> /dev/null")
	generate_problems() # Generate n problems
	generate_graphs()	# Generate the graphs

if __name__ == '__main__':
	main()