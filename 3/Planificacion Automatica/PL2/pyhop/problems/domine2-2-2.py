from pyhop import hop


#Definimos los operadores
def move(state, loc_actual,  to):
    if loc_actual != to:
        if state.loc['gripper_l'] == loc_actual and state.loc['gripper_r'] == loc_actual:
            state.loc['gripper_l'] = to
            state.loc['gripper_r'] = to
            return state
        else:
            return False
    else:
        return False
    
def take_box(state, gripper, box):
    if state.loc[box] == state.loc[gripper] and state.free[gripper] == True:
        state.free[gripper] = False
        state.carry[gripper] = box
        state.loc[box] = gripper
        return state
    else:
        return False
    
def put_box(state, gripper, person):
    box = state.carry[gripper]
    if state.loc[gripper] == state.loc[person]:
        if state.type[box] == state.doesnt_have[person]:
            state.free[gripper] = True
            state.carry[gripper] = None
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
def le_falta(state, person, gripper, box):
    if state.doesnt_have[person] == state.type[box]:
        if state.loc[box] != state.loc[gripper] and state.loc[box] != state.loc[person]:
            return [('move', state.loc[gripper], state.loc[box]), ('take_box', gripper, box), ('move', state.loc[box], state.loc[person]), ('put_box', gripper, person)]
        elif state.loc[box] != state.loc[gripper]:
            return [('move', state.loc[gripper], state.loc[box]), ('take_box', gripper, box), ('put_box', gripper, person)]
        elif state.loc[box] != state.loc[person]:
            return [('take_box', gripper, box), ('move', state.loc[box], state.loc[person]), ('put_box', gripper, person)]
        else:
            return []
    else:
        return []


#Registramos los metodos
hop.declare_methods('le_falta', le_falta)


print('')
hop.print_methods(hop.get_methods())

#Definimos el estado inicial
state1 = hop.State('state1')
state1.free = {"gripper_l":True, "gripper_r":True}
state1.carry = {"gripper_l":None, "gripper_r":None}

state1.loc = {"gripper_l":"deposito", "gripper_r":"deposito", "person1":"location1", "person2":"location2", "box1":"deposito", "box2":"deposito"}
state1.type = {"box1":"food", "box2":"medicine"}
state1.doesnt_have = {"person1":"food", "person2":"medicine"}
state1.has = {"person1":"medicine", "person2":"food"}

print("\n-----Estado inicial-----\n")
print("Localizaciones: ", state1.loc)
print("Tipos: " ,state1.type)
print("Libres: " ,state1.free)
print("Carga: " ,state1.carry)
print("No tiene :" ,state1.doesnt_have)
print("Tiene :" ,state1.has)

print("\n-----Generar plan-----\n")


def enviar_todo(state):
    posibilidades = []
    for person in state.doesnt_have.keys():
        needed_type= state.doesnt_have.get(person)
        for box in state.type.keys():
            if state.type.get(box) == needed_type:
                for gripper in state.free.keys():
                    posibilidades.append(('le_falta', person, gripper, box))
    plan = hop.plan(state, posibilidades,
    hop.get_operators(),hop.get_methods(),
    verbose=1)

    return plan

print(enviar_todo(state1))