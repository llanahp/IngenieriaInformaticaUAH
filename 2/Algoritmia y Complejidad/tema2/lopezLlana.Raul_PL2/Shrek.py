from random import randint


'''Esta función recibe el numero de escaleras que tiene que crear y las crea con una longitud aleatoria'''
def crearEscaleras(numeroEscaleras):
    escaleras=[]
    for i in range(numeroEscaleras):
        '''Creo aleaoriamente la longitud de la escalera entre 1 y 10'''
        escaleras.append(randint(1,10))
    return escaleras

'''La función aplicará el algoritmo propuesto para minimizar el tiempo de construcción de la escalera'''
def construirEscalera(escaleras):
    escaleraCompleta=[]

    tiempo=0
    '''Mientras siga teniendo escaleras sin utilizar'''
    while escaleras:
        '''busco la que tengua una longitud más pequeña de todas las disponibles'''
        selecionada=9999999
        for escalera in escaleras:
            if(escalera<selecionada):
                selecionada=escalera

        '''Sabiendo ya cual es la menor de todas, la borro de las candidatas y la guarda como seleccionada'''
        escaleras.remove(selecionada)
        escaleraCompleta.append(selecionada)
        '''Actualizo el tiempoto total que tarda en construirse la escalera final'''
        tiempo+=sum(escaleraCompleta)
    return escaleraCompleta,tiempo

'''Defino el numero de escaleras que se van a crear'''
numeroEscaleras=5

'''llamo a la funcion que me creará el numero de escaleras con una longitud aletoria'''
escaleras=crearEscaleras(numeroEscaleras)
print("Las escaleras tienen las siguientes medidas: ",escaleras)

'''Aplico el algoritmo propuesto'''
escalera, tiempo=construirEscalera(escaleras)
print("Al soldar todas, se hace de la siguiente forma",escalera, "tardando un tiempo de ",tiempo," minutos")