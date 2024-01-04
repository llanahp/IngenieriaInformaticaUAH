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

state1.loc = {"gripper_l":"deposito", "gripper_r":"deposito", "person1":"location1", "person2":"location2", "person3":"location3", "person4":"location4", "person5":"location5", "person6":"location6", "person7":"location7", "person8":"location8", "person9":"location9", "person10":"location10", "box1":"deposito", "box2":"deposito", "box3":"deposito", "box4":"deposito", "box5":"deposito", "box6":"deposito", "box7":"deposito", "box8":"deposito", "box9":"deposito", "box10":"deposito", "box11":"deposito", "box12":"deposito", "box13":"deposito", "box14":"deposito", "box15":"deposito", "box16":"deposito", "box17":"deposito", "box18":"deposito", "box19":"deposito", "box20":"deposito", "box21":"deposito", "box22":"deposito", "box23":"deposito", "box24":"deposito", "box25":"deposito", "box26":"deposito", "box27":"deposito", "box28":"deposito", "box29":"deposito", "box30":"deposito", "box31":"deposito", "box32":"deposito", "box33":"deposito", "box34":"deposito", "box35":"deposito", "box36":"deposito", "box37":"deposito", "box38":"deposito", "box39":"deposito", "box40":"deposito"}
state1.type = {"box1":"food", "box2":"medicine", "box3":"food", "box4":"medicine", "box5":"food", "box6":"medicine", "box7":"food", "box8":"medicine", "box9":"food", "box10":"medicine", "box11":"food", "box12":"medicine", "box13":"food", "box14":"medicine", "box15":"food", "box16":"medicine", "box17":"food", "box18":"medicine", "box19":"food", "box20":"medicine", "box21":"food", "box22":"medicine", "box23":"food", "box24":"medicine", "box25":"food", "box26":"medicine", "box27":"food", "box28":"medicine", "box29":"food", "box30":"medicine", "box31":"food", "box32":"medicine", "box33":"food", "box34":"medicine", "box35":"food", "box36":"medicine", "box37":"food", "box38":"medicine", "box39":"food", "box40":"medicine"}
state1.doesnt_have = {"person1":"food", "person2":"medicine", "person3":"food", "person4":"medicine", "person5":"food", "person6":"medicine", "person7":"food", "person8":"medicine", "person9":"food", "person10":"medicine", "person11":"food", "person12":"medicine", "person13":"food", "person14":"medicine", "person15":"food", "person16":"medicine", "person17":"food", "person18":"medicine", "person19":"food", "person20":"medicine"}
state1.has = {"person1":"medicine", "person2":"food", "person3":"medicine", "person4":"food", "person5":"medicine", "person6":"food", "person7":"medicine", "person8":"food", "person9":"medicine", "person10":"food", "person11":"medicine", "person12":"food", "person13":"medicine", "person14":"food", "person15":"medicine", "person16":"food", "person17":"medicine", "person18":"food", "person19":"medicine", "person20":"food"}
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
    verbose=3)

    return plan

print(enviar_todo(state1))