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

state1.loc = {"drone":"deposito", "person1":"location12", "person2":"location20", "person3":"location12", "person4":"location1", "person5":"location5", "person6":"location10", "person7":"location10", "person8":"location11", "person9":"location13", "person10":"location18", "person11":"location1", "person12":"location17", "person13":"location17", "person14":"location15", "person15":"location9", "person16":"location11", "person17":"location18", "person18":"location5", "person19":"location5", "person20":"location14", "box1":"deposito", "box2":"deposito", "box3":"deposito", "box4":"deposito", "box5":"deposito", "box6":"deposito", "box7":"deposito", "box8":"deposito", "box9":"deposito", "box10":"deposito", "box11":"deposito", "box12":"deposito", "box13":"deposito", "box14":"deposito", "box15":"deposito", "box16":"deposito", "box17":"deposito", "box18":"deposito", "box19":"deposito", "box20":"deposito", "box21":"deposito", "box22":"deposito", "box23":"deposito", "box24":"deposito", "box25":"deposito", "box26":"deposito", "box27":"deposito", "box28":"deposito", "box29":"deposito", "box30":"deposito", "box31":"deposito", "box32":"deposito", "box33":"deposito", "box34":"deposito", "box35":"deposito", "box36":"deposito", "box37":"deposito", "box38":"deposito", "box39":"deposito", "box40":"deposito", "box41":"deposito", "box42":"deposito", "box43":"deposito", "box44":"deposito", "box45":"deposito", "box46":"deposito", "box47":"deposito", "box48":"deposito", "box49":"deposito", "box50":"deposito", "box51":"deposito", "box52":"deposito", "box53":"deposito", "box54":"deposito", "box55":"deposito", "box56":"deposito", "box57":"deposito", "box58":"deposito", "box59":"deposito", "box60":"deposito", "box61":"deposito", "box62":"deposito", "box63":"deposito", "box64":"deposito", "box65":"deposito", "box66":"deposito", "box67":"deposito", "box68":"deposito", "box69":"deposito", "box70":"deposito", "box71":"deposito", "box72":"deposito", "box73":"deposito", "box74":"deposito", "box75":"deposito", "box76":"deposito", "box77":"deposito", "box78":"deposito", "box79":"deposito", "box80":"deposito", "box81":"deposito", "box82":"deposito", "box83":"deposito", "box84":"deposito", "box85":"deposito", "box86":"deposito", "box87":"deposito", "box88":"deposito", "box89":"deposito", "box90":"deposito", "box91":"deposito", "box92":"deposito", "box93":"deposito", "box94":"deposito", "box95":"deposito", "box96":"deposito", "box97":"deposito", "box98":"deposito", "box99":"deposito", "box100":"deposito", "box101":"deposito", "box102":"deposito", "box103":"deposito", "box104":"deposito", "box105":"deposito", "box106":"deposito", "box107":"deposito", "box108":"deposito", "box109":"deposito", "box110":"deposito", "box111":"deposito", "box112":"deposito", "box113":"deposito", "box114":"deposito", "box115":"deposito", "box116":"deposito", "box117":"deposito", "box118":"deposito", "box119":"deposito", "box120":"deposito", "box121":"deposito", "box122":"deposito", "box123":"deposito", "box124":"deposito", "box125":"deposito", "box126":"deposito", "box127":"deposito", "box128":"deposito", "box129":"deposito", "box130":"deposito", "box131":"deposito", "box132":"deposito", "box133":"deposito", "box134":"deposito", "box135":"deposito", "box136":"deposito", "box137":"deposito", "box138":"deposito", "box139":"deposito", "box140":"deposito", "box141":"deposito", "box142":"deposito", "box143":"deposito", "box144":"deposito", "box145":"deposito", "box146":"deposito", "box147":"deposito", "box148":"deposito", "box149":"deposito", "box150":"deposito", "box151":"deposito", "box152":"deposito", "box153":"deposito", "box154":"deposito", "box155":"deposito", "box156":"deposito", "box157":"deposito", "box158":"deposito", "box159":"deposito", "box160":"deposito", "box161":"deposito", "box162":"deposito", "box163":"deposito", "box164":"deposito", "box165":"deposito", "box166":"deposito", "box167":"deposito", "box168":"deposito", "box169":"deposito", "box170":"deposito", "box171":"deposito", "box172":"deposito", "box173":"deposito", "box174":"deposito", "box175":"deposito", "box176":"deposito", "box177":"deposito", "box178":"deposito", "box179":"deposito", "box180":"deposito", "box181":"deposito", "box182":"deposito", "box183":"deposito", "box184":"deposito", "box185":"deposito", "box186":"deposito", "box187":"deposito", "box188":"deposito", "box189":"deposito", "box190":"deposito", "box191":"deposito", "box192":"deposito", "box193":"deposito", "box194":"deposito", "box195":"deposito", "box196":"deposito", "box197":"deposito", "box198":"deposito", "box199":"deposito", "box200":"deposito"}
state1.type = {"box1":"food", "box2":"medicine", "box3":"food", "box4":"medicine", "box5":"food", "box6":"medicine", "box7":"food", "box8":"medicine", "box9":"food", "box10":"medicine", "box11":"food", "box12":"medicine", "box13":"food", "box14":"medicine", "box15":"food", "box16":"medicine", "box17":"food", "box18":"medicine", "box19":"food", "box20":"medicine", "box21":"food", "box22":"medicine", "box23":"food", "box24":"medicine", "box25":"food", "box26":"medicine", "box27":"food", "box28":"medicine", "box29":"food", "box30":"medicine", "box31":"food", "box32":"medicine", "box33":"food", "box34":"medicine", "box35":"food", "box36":"medicine", "box37":"food", "box38":"medicine", "box39":"food", "box40":"medicine", "box41":"food", "box42":"medicine", "box43":"food", "box44":"medicine", "box45":"food", "box46":"medicine", "box47":"food", "box48":"medicine", "box49":"food", "box50":"medicine", "box51":"food", "box52":"medicine", "box53":"food", "box54":"medicine", "box55":"food", "box56":"medicine", "box57":"food", "box58":"medicine", "box59":"food", "box60":"medicine", "box61":"food", "box62":"medicine", "box63":"food", "box64":"medicine", "box65":"food", "box66":"medicine", "box67":"food", "box68":"medicine", "box69":"food", "box70":"medicine", "box71":"food", "box72":"medicine", "box73":"food", "box74":"medicine", "box75":"food", "box76":"medicine", "box77":"food", "box78":"medicine", "box79":"food", "box80":"medicine", "box81":"food", "box82":"medicine", "box83":"food", "box84":"medicine", "box85":"food", "box86":"medicine", "box87":"food", "box88":"medicine", "box89":"food", "box90":"medicine", "box91":"food", "box92":"medicine", "box93":"food", "box94":"medicine", "box95":"food", "box96":"medicine", "box97":"food", "box98":"medicine", "box99":"food", "box100":"medicine", "box101":"food", "box102":"medicine", "box103":"food", "box104":"medicine", "box105":"food", "box106":"medicine", "box107":"food", "box108":"medicine", "box109":"food", "box110":"medicine", "box111":"food", "box112":"medicine", "box113":"food", "box114":"medicine", "box115":"food", "box116":"medicine", "box117":"food", "box118":"medicine", "box119":"food", "box120":"medicine", "box121":"food", "box122":"medicine", "box123":"food", "box124":"medicine", "box125":"food", "box126":"medicine", "box127":"food", "box128":"medicine", "box129":"food", "box130":"medicine", "box131":"food", "box132":"medicine", "box133":"food", "box134":"medicine", "box135":"food", "box136":"medicine", "box137":"food", "box138":"medicine", "box139":"food", "box140":"medicine", "box141":"food", "box142":"medicine", "box143":"food", "box144":"medicine", "box145":"food", "box146":"medicine", "box147":"food", "box148":"medicine", "box149":"food", "box150":"medicine", "box151":"food", "box152":"medicine", "box153":"food", "box154":"medicine", "box155":"food", "box156":"medicine", "box157":"food", "box158":"medicine", "box159":"food", "box160":"medicine", "box161":"food", "box162":"medicine", "box163":"food", "box164":"medicine", "box165":"food", "box166":"medicine", "box167":"food", "box168":"medicine", "box169":"food", "box170":"medicine", "box171":"food", "box172":"medicine", "box173":"food", "box174":"medicine", "box175":"food", "box176":"medicine", "box177":"food", "box178":"medicine", "box179":"food", "box180":"medicine", "box181":"food", "box182":"medicine", "box183":"food", "box184":"medicine", "box185":"food", "box186":"medicine", "box187":"food", "box188":"medicine", "box189":"food", "box190":"medicine", "box191":"food", "box192":"medicine", "box193":"food", "box194":"medicine", "box195":"food", "box196":"medicine", "box197":"food", "box198":"medicine", "box199":"food", "box200":"medicine"}
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