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

#Definimos el estado inicial
state1 = hop.State('state1')
state1.free = {"gripper_l":True, "gripper_r":True}
state1.carry = {"gripper_l":None, "gripper_r":None}

state1.loc = {"drone":"deposito", "person1":"location16", "person2":"location2", "person3":"location14", "person4":"location16", "person5":"location12", "person6":"location20", "person7":"location2", "person8":"location18", "person9":"location9", "person10":"location17", "person11":"location11", "person12":"location6", "person13":"location8", "person14":"location18", "person15":"location12", "person16":"location7", "person17":"location19", "person18":"location8", "person19":"location7", "person20":"location13", "box1":"deposito", "box2":"deposito", "box3":"deposito", "box4":"deposito", "box5":"deposito", "box6":"deposito", "box7":"deposito", "box8":"deposito", "box9":"deposito", "box10":"deposito", "box11":"deposito", "box12":"deposito", "box13":"deposito", "box14":"deposito", "box15":"deposito", "box16":"deposito", "box17":"deposito", "box18":"deposito", "box19":"deposito", "box20":"deposito"}
state1.type = {"box1":"food", "box2":"medicine", "box3":"food", "box4":"medicine", "box5":"food", "box6":"medicine", "box7":"food", "box8":"medicine", "box9":"food", "box10":"medicine", "box11":"food", "box12":"medicine", "box13":"food", "box14":"medicine", "box15":"food", "box16":"medicine", "box17":"food", "box18":"medicine", "box19":"food", "box20":"medicine"}
state1.doesnt_have = {"person1":"food", "person2":"medicine", "person3":"food", "person4":"medicine", "person5":"food", "person6":"medicine", "person7":"food", "person8":"medicine", "person9":"food", "person10":"medicine", "person11":"food", "person12":"medicine", "person13":"food", "person14":"medicine", "person15":"food", "person16":"medicine", "person17":"food", "person18":"medicine", "person19":"food", "person20":"medicine"}
state1.has = {"person1":"medicine", "person2":"food", "person3":"medicine", "person4":"food", "person5":"medicine", "person6":"food", "person7":"medicine", "person8":"food", "person9":"medicine", "person10":"food", "person11":"medicine", "person12":"food", "person13":"medicine", "person14":"food", "person15":"medicine", "person16":"food", "person17":"medicine", "person18":"food", "person19":"medicine", "person20":"food"}

print("\n-----Estado inicial-----\n")
print("Localizaciones: ", state1.loc)
print("Cajas: " ,state1.type)
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
                posibilidades.append(('le_falta', person, box))
    plan = hop.plan(state, posibilidades,
    hop.get_operators(),hop.get_methods())

    return plan

print(enviar_todo(state1))