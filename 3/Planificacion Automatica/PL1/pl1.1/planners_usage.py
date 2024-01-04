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



def satplan(domain, problem):
    
    #Solve the problem and return the plan
    cmd = ['./planners/satplan/satplan', '-solver', 'siege', '-domain', domain, '-problem', problem]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    plan = res.stdout.decode('utf-8').splitlines()
    return plan

def fast_downward(domain, problem):
    
    #Solve the problem and return the plan
    cmd = ['./planners/downward.sif', '--alias', 'lama-first', domain, problem]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    plan = res.stdout.decode('utf-8').splitlines()
    return plan

def lpgtd(domain, problem):
    
    #Solve the problem and return the plan
    cmd = ['./planners/lpg-td', '-o', domain, '-f', problem, '-quality']
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    plan = res.stdout.decode('utf-8').splitlines()
    return plan

def ff(domain, problem):
        
    #Solve the problem and return the plan
    cmd = ['./planners/ff', '-o', domain, '-f', problem]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    plan = res.stdout.decode('utf-8').splitlines()
    return plan

def sgplan40(domain, problem):
    
    #Solve the problem and return the plan
    cmd = ['./planners/sgplan40', '-o', domain, '-f', problem]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    plan = res.stdout.decode('utf-8').splitlines()
    return plan

def metricff(domain, problem):
    #Solve the problem and return the plan
    cmd = ['./planners/metricff', '-o', domain, '-f', problem]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    plan = res.stdout.decode('utf-8').splitlines()
    return plan