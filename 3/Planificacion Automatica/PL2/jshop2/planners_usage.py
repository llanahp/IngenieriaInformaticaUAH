import subprocess
import sys


def load_config():

    # Load the configuration
    if len(sys.argv) < 4:
        print("Faltan argumentos: ./test_problems.py <PLANNER> <TIME_LIMIT> <MAX_COMPLEXITY> <VERBOSE>")
        exit()
    else:
        if len(sys.argv) == 5:
            verbose = True
            [planner, time_limit, max_complexity, verbose] = sys.argv[1:5]
            return planner, time_limit, max_complexity, verbose
        else:
            verbose = False
            [planner, time_limit, max_complexity] = sys.argv[1:4]
            return planner, time_limit, max_complexity, False


def jshop2(domain, problem):
    
    #Solve the problem and return the plan
    cmd = ['sudo', '/home/rufo/JSHOP2/jshop2-console.sh', 'drone']
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    plan = res.stdout.decode('utf-8').splitlines()
    return plan
