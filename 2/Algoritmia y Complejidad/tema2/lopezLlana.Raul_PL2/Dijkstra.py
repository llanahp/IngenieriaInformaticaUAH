import math


def mostrar(matriz):
    for a in matriz:
        print(a)
    return


def algoritmoDijkstra(nodos, matriz_coste):
    numeroNodos = len(nodos)
    '''creo un lista con los candidatos restantes y un array con el recorrido que lleva'''
    candidatos = list()
    caminoActual = []
    for a in nodos:
        candidatos.append(a+1)

    '''seleciono el primer nodo'''
    PrimerElemento = nodos[0]+1

    '''lo añado al recorrido que lleva y lo elimino de los candidatos restantes'''
    caminoActual.append(PrimerElemento)
    candidatos.remove(PrimerElemento)

    '''Elimino el nodo selecionado de la lista de nodos'''
    nodos.remove(PrimerElemento)

    '''almaceno los costos que tiene desde este nodo al resto de nodos'''
    matrizDeCoste = []
    for a in matriz_coste:
        aux = []
        for b in range(len(a)):
            aux.append(math.inf)
        matrizDeCoste.append(aux)

    costesDesdePrimero = []
    for i in range(0, numeroNodos):
        matrizDeCoste[0][i] = matriz_coste[0][i]
        costesDesdePrimero.append(matriz_coste[0][i])
    '''Mientras siga teniendo nodos sin alcanzar'''
    while candidatos:
        '''Miro cual es el menor coste desde el nodo selecionado a algun nodo'''
        coste = math.inf
        nodoMenorCoste = None
        for parcial in costesDesdePrimero:
            nodo = (costesDesdePrimero.index(parcial) + 1)

            if (parcial < coste) and (nodo in candidatos) and parcial != 0:
                '''Al encontrar uno más barato, lo guardo'''
                coste = parcial
                nodoMenorCoste = nodo
        print("Nodo: ", nodoMenorCoste)
        print("Coste acumulado : ", coste)
        print("-----")
        '''elimino de la lista de candidatos el que tiene el menor coste hacia el ultimo que tenia selecionado'''
        candidatos.remove(nodoMenorCoste)

        '''guardo el nodo'''
        caminoActual.append(nodoMenorCoste)

        '''actualizo la matriz de costes'''
        for i in range(0, numeroNodos):
            matrizDeCoste[nodoMenorCoste - 1][i] = matriz_coste[nodoMenorCoste - 1][i]
        '''Comparo con otros caminos'''
        for i in range(0, numeroNodos):
            matrizDeCoste[0][i] = min(costesDesdePrimero[i], (matrizDeCoste[nodoMenorCoste - 1][i] + coste))
            costesDesdePrimero[i] = min(costesDesdePrimero[i], (matrizDeCoste[nodoMenorCoste - 1][i] + coste))

    ''' Calculo el coste total de recorrer el diagrama'''
    costeTotal = 0
    for i in range(0, numeroNodos-1):
        costeTotal += matriz_coste[caminoActual[i]-1][caminoActual[i + 1]-1]
    for a in range (len(caminoActual)):
        caminoActual[a]=caminoActual[a]-1
    return costeTotal, caminoActual


''' Creo un diagrama con 5 nodos como se muestra en la imagen del documento adjunto'''
nodos = [0, 1, 2, 3, 4]
'''indico las distancias entre los nodos '''
matriz_coste = [[0, 100, 30, math.inf, math.inf],
                [math.inf, 0, 20, math.inf, 50],
                [math.inf, math.inf, 0, 10, math.inf],
                [math.inf, 15, math.inf, 0, math.inf],
                [math.inf, math.inf, 60, 50, 0]]
''' Aplico el algoritmo de Dijkstra'''
coste, camino_mas_corto = algoritmoDijkstra(nodos, matriz_coste)

''' Muestro el resultado por pantalla'''
print("Recorrido:")
for i in (camino_mas_corto):
    print("\tNodo ",i + 1)
print("\tCon un costo total de :", coste)

