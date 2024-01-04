from pyhop import hop


#Definimos los operadores
def move(state, loc_actual,  to):
    if loc_actual != to:
        if state.loc['drone'] == loc_actual:
            state.loc['drone'] = to
            return state
        else:
            return False
    else:
        return False
    
def take_box(state, box):
    if state.loc[box] == state.loc['drone']:
        if state.free['gripper_l']:
            state.free['gripper_l'] = False
            state.carry['gripper_l'] = box
            state.loc[box] = 'gripper_l'
            return state
        elif state.free['gripper_r']:
            state.free['gripper_l'] = False
            state.carry['gripper_l'] = box
            state.loc[box] = 'gripper_l'
            return state
        else:
            return False
    else:
        return False
    
def put_box(state, person):
    if state.loc['drone'] == state.loc[person]:
        if state.type[state.carry['gripper_l']] == state.doesnt_have[person]:
            box = state.carry['gripper_l']
            state.free['gripper_l'] = True
            state.carry['gripper_l'] = None
            state.loc[box] = state.loc[person]
            state.doesnt_have[person] = None
            state.has[person] = box
            return state
        elif state.type[state.carry['gripper_r']] == state.doesnt_have[person]:
            box = state.carry['gripper_r']
            state.free['gripper_r'] = True
            state.carry['gripper_r'] = None
            state.loc[box] = state.loc[person]
            state.doesnt_have[person] = None
            state.has[person] = box
            return state
        else:
            return False  
    else:
        return False

#Registramos los operadores
hop.declare_operators(move, take_box, put_box)
print('')
hop.print_operators(hop.get_operators())


#Definimos los metodos
def le_falta(state, person, box):
    if state.doesnt_have[person] == state.type[box]:
        if state.loc[box] != state.loc['drone'] and state.loc[box] != state.loc[person]:
            return [('move', state.loc['drone'], state.loc[box]), ('take_box', box), ('move', state.loc[box], state.loc[person]), ('put_box', person)]
        elif state.loc[box] != state.loc['drone']:
            return [('move', state.loc['drone'], state.loc[box]), ('take_box', box), ('put_box', person)]
        elif state.loc[box] != state.loc[person]:
            return [('take_box', box), ('move', state.loc[box], state.loc[person]), ('put_box', person)]
        else:
            return []
    else:
        return []


#Registramos los metodos
hop.declare_methods('le_falta', le_falta)


print('')
hop.print_methods(hop.get_methods())

#Definimos los objetos de cada tipo (una lista por tipo)
drone = 'drone'
box = ['box1', 'box2']
person = ['person1', 'person2']
location = ['deposito', 'loc1', 'loc2']
type = ['food', 'medicine']
gripper = ['gripper_l', 'gripper_r']


#Definimos el estado inicial
state1 = hop.State('state1')
state1.free = {gripper[0]:True, gripper[1]:True}
state1.carry = {gripper[0]:None, gripper[1]:None}
state1.loc = {drone: location[0], box[0]:location[1], box[1]:location[0], person[0]:location[2], person[1]:location[2]}
state1.type = {box[0]:type[0], box[1]:type[1]}
state1.doesnt_have = {person[0]:type[0], person[1]:type[1]}
state1.has = {person[0]:type[1], person[1]:type[0]}

def enviar_todo(state):
    posibilidades = []
    for person in state.doesnt_have.keys():
        needed_type= state.doesnt_have.get(person)
        for box in state.type.keys():
            if state.type.get(box) == needed_type:
                posibilidades.append(('le_falta', person, box))
    plan = hop.plan(state, posibilidades,
    hop.get_operators(),hop.get_methods(),
    verbose=3)

    return plan

print(enviar_todo(state1))





