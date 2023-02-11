'''Defino una clase objeto que contendrá el valor y el peso de cada objeto'''
import math


class objeto:

    def __init__(self, valor, peso):
        self.valor = valor
        self.peso = peso

    def setValor(self, valor):
        self.valor = valor

    def setPeso(self, peso):
        self.pesp = peso

    def getValor(self):
        return self.valor

    def getPeso(self):
        return self.peso


'''Funcion que rellenará las alforjas'''


def llenarAlforja(capacidadAlforja, objetos):
    '''Primero me debo crear la tabla dinámica'''
    tabla = []
    objetosSelecionadas = []
    '''tantas filas como objetos'''
    for i in range(len(objetos)):
        aux = []
        '''tnatas columnas como el peso máximo que pueda exa alforja'''
        for a in range(capacidadAlforja):
            aux.append(0)
        tabla.append(aux)
    '''Teniendo ya la tabla creada y con todo a 0
    Recorro de nuevo la tabla para rellenarla'''

    for fila in range(len(objetos)):
        for columna in range(capacidadAlforja):
            #print("---- FILA: ",fila," COLUMNA: ",columna," -------")


            '''Primera columna es que puedo cargar un peso de 0'''
            if (columna == 0):
                tabla[fila][columna] = 0
            else:
                ''' Tengo que comparar si el objeto de esta fila entra en la mochila   
                Tengo que mirar si es más rentable que lo que teniamos antes.
                 Al tener los objetos ordenados por peso ascendiente, solo  comparo con el primer objeto'''

                if (objetos[fila].getPeso() <= columna+1):

                    # print("objeto peso: ",objetos[fila].getPeso())
                    # print("objeto valor: ",objetos[fila].getValor())
                    '''El objeto podria entrar dentro de la mochila'''
                    '''Miro si es rentable'''
                    if (fila == 0):
                        tabla[fila][columna] = objetos[fila].valor
                    else:
                        anterior = tabla[fila - 1][columna]
                        propuesta = objetos[fila].valor + tabla[fila - 1][columna - objetos[fila].getPeso()]
                        if (anterior < propuesta):
                            '''Es mejor el nuevo objeto y lo inserto en al alforja'''
                            tabla[fila][columna] = propuesta
                        else:
                            '''Es mejor quedarme con lo que ya tenia'''
                            tabla[fila][columna] = tabla[fila - 1][columna]
                else:
                    '''No puedo meter el nuevo objeto en la alforja
                    sigo con lo que tuviese antes puesto'''
                    tabla[fila][columna] = tabla[fila - 1][columna]

    '''Una vez rellena la tabla,selecciono el conjunto de objetos que me maximice el valor'''
    '''Para ello voy a recorrer la tabla de de abajo a la derecha hacia arriba a la izquierda (descendiente)'''
    capacidadParcial = capacidadAlforja
    '''Ultima posicion de la tabla'''
    ultimo = tabla[len(objetos) - 1][capacidadAlforja - 1]
    for i in range(len(objetos) - 1, -1, -1):
        '''Desde el total de objetos hasta 0 con un paso de -1'''

        '''si llego a 0 antes de terminar de recorrer la tabla, paro'''
        if (capacidadParcial <= 0):
            break
        if (i != 0):
            if (ultimo == tabla[i - 1][capacidadParcial - 1]):
                continue
            else:
                '''Los valores no son iguales'''
                elemento = objetos.__getitem__(i)
                objetosSelecionadas.append(elemento)
                ultimo = ultimo - elemento.getValor()
                capacidadParcial = capacidadParcial - elemento.getPeso()

        else:
            '''Los valores no son iguales'''
            elemento = objetos.__getitem__(i)
            objetosSelecionadas.append(elemento)
            ultimo = ultimo - elemento.getValor()
            capacidadParcial = capacidadParcial - elemento.getPeso()
    return objetosSelecionadas


def quitarSeleccionados(objetos, seleccionados):
    '''Selecionados contendrá el valor de los objetos ya introducidos en una alforja'''
    for va in seleccionados:
        if (objetos.__contains__(va)):
            objetos.remove(va)
    return objetos


def getValores(objetos):
    total = 0
    for ob in objetos:
        total += ob.getValor()
    return total


def listarObjetos(lista):
    print("-------------------------------")
    for a in lista:
        print("Peso: ", a.getPeso(), " Valor: ", a.getValor())
    print("-------------------------------")


def rellenarAlforjas(objetos, alforja1, alforja2):
    capacidadMaxAlforja = max(alforja1, alforja2)
    '''primero relleno una alforja, la que tenga mayor capacidad'''
    seleccionados = llenarAlforja(capacidadMaxAlforja, objetos)
    '''quito los elementos que ya he seleccionado'''

    print("seleccionados alforja con mayor capacidad")
    listarObjetos(seleccionados)

    objetos2 = quitarSeleccionados(objetos, seleccionados)
    '''relleno la otra alforja'''

    capacidadMinAlforja = min(alforja1, alforja2)
    print("capacidad de la segunda alforja: ", capacidadMinAlforja)
    seleccionados2 = llenarAlforja(capacidadMinAlforja, objetos2)

    print("seleccionados alforja con menor capacidad")
    listarObjetos(seleccionados2)

    objetos3 = quitarSeleccionados(objetos2, seleccionados2)

    print("Objetos no seleccionados")
    listarObjetos(objetos3)

    '''devuelvo el valor que me llevo en cada alforja'''
    return getValores(seleccionados), getValores(seleccionados2)


'''Defino objetos'''
objetos = []
'''El peso debe estar ordenado de menor a mayor'''
valor = [200, 200, 10, 10]
peso = [1,1,2,2]

'''valor = [200, 150, 10, 5]
peso = [3,1,1,2]'''
for i in range(0, len(peso)):
    objetos.append(objeto(valor[i], peso[i]))

objetosFinales = []

'''Ordeno por peso'''
while (objetos):
    pesoMax = math.inf
    valorMax=0
    posicion = 0
    sel = 0
    for a in objetos:
        if (a.getPeso() < pesoMax):
            pesoMax = a.getPeso()
            valorMax=a.getValor()
            menor = a
            sel = posicion
        if (a.getPeso()== pesoMax):
            if(a.getValor()< valorMax):
                pesoMax = a.getPeso()
                valorMax = a.getValor()
                menor = a
                sel = posicion
        posicion = posicion + 1
    objetosFinales.append(menor)
    objetos.pop(sel)

'''peso límite alforjas'''
alforja1 = 3
alforja2 = 3

max, min = rellenarAlforjas(objetosFinales, alforja1, alforja2)

print("Una alforja lleva un valor de ", max)
print("Otra alforja lleva un valor de ", min)

