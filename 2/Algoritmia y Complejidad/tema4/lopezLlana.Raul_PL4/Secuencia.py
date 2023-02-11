import math


def con(propuesta, cadena):
    '''Esta es la función principal, mira si una cadena es subcadena de otra'''
    posicion_aux = 0
    resul = True
    '''Recorro hasta ver que entra toda la propuesta en la cadena
    En caso contrario, salta una excepcion y me indica que no entra todo ya que hemos llegado al final'''
    try:
        for i in propuesta:
            '''Recorro los bits'''
            while (i != cadena[posicion_aux]):
                posicion_aux = posicion_aux + 1
            posicion_aux = posicion_aux + 1
    except:
        resul = False
    return resul


def esSubcadena(propuesta, CadenaA, CadenaB):
    '''comparo la propuesta por separado con cada una de las cadenas'''
    result = False
    if (con(propuesta, CadenaA)):
        if (con(propuesta, CadenaB)):
            result = True
    return result


'''Esta funcion convierte un numero decimal a binario'''


def DecimalToBinary(n):
    return bin(n).replace("0b", "")


def crearTabla(cadenaA, cadenaB):
    '''Primero me debo crear la tabla dinámica'''
    tabla = []
    '''tantas filas como objetos'''
    for i in range(len(cadenaA)):
        aux = []
        '''tantas columnas como el peso máximo que pueda esa alforja'''
        for a in range(len(cadenaB)):
            aux.append(0)
        tabla.append(aux)
    '''Teniendo ya la tabla creada y con todo a 0
    Recorro de nuevo la tabla para rellenarla'''

    for fila in range(len(cadenaA)):
        for columna in range(len(cadenaB)):
            if (fila == 0):
                '''Si el caracter de la cadenaA se encuentra en alguna posicion de lo que llevo de cadenaB'''
                if (cadenaA[0] in cadenaB[0:(columna + 1)]):
                    tabla[fila][columna] = 1
                else:
                    tabla[fila][columna] = 0
            elif (columna == 0):
                '''Si el caracter de la cadenaA se encuentra en alguna posicion de lo que llevo de cadenaB'''
                if (cadenaB[0] in cadenaA[0:(fila + 1)]):
                    tabla[fila][columna] = 1
                else:
                    tabla[fila][columna] = 0
    return tabla


def mayor(cadenaA, cadenaB):
    '''Primero saco caul es la cadena con mayor longitud usando una tabla dinamica'''
    mayor = crearTabla(cadenaA, cadenaB)

    '''Una vez creada la tabla, recorro todas las posiciones'''
    for fila in range(len(cadenaA)):
        for columna in range(len(cadenaB)):
            '''Si no estoy en el caso de que las dos listas estén vacias'''
            if (fila != 0 and columna != 0):
                '''Si el valor antorior es distinto a la fila + 1 y
                si el valor el bit de la primera cadena coincide con el bit de la segunda
                '''
                if (mayor[fila][columna - 1] != (1 + fila) and cadenaA[fila] == cadenaB[columna]):
                    '''El valor anterior más 1'''
                    mayor[fila][columna] = mayor[fila][columna - 1] + 1

                else:
                    '''No se ha producido una mejora y me quedo con el valor anterior'''
                    mayor[fila][columna] = mayor[fila][columna - 1]
    '''Muestro la tabla por consola'''
    print("tabla:")
    for a in mayor:
        print(a)
    '''El valor más alto se encuentra en la ultima posición '''
    mayor = mayor[len(cadenaA) - 1][len(cadenaB) - 1]
    posibilidades = []
    '''Sabiendo esto, ahora ya podemos crear las distintas posibilidades de cadenas (binario)'''
    for posible in range(int(math.pow(2, mayor))):
        '''Añado los numero binarios'''
        posibilidades.append(DecimalToBinary(posible))
    resul = []
    '''Recorro todas las posibilidades mirando si son subcadenas de las 2 dadas'''
    for a in posibilidades:
        if (esSubcadena(a, cadenaA, cadenaB)):
            resul.append(a)
    '''Ahora ya tenemos almacenadas las cadenas que son subcadenas de las 2 dadas'''
    '''Solo queda devolver la última ya que será la más grande'''
    return resul[-1]


CadenaA = "01101010"
CadenaB = "101001001"
propuesta = "11011"
print("Cadena A: ", CadenaA)
print("Cadena B: ", CadenaB)

'''Primero miramos si la propuesta es subcadena de A y B'''
if (esSubcadena(propuesta, CadenaA, CadenaB)):
    print(propuesta, " es subcadena")
else:
    print(propuesta, " NO es subcadena")

print()
'''Ahora, en vamos a ver cual es la secuencia más grande posible'''
print("La cadena más grande posible para ser subcadena de las otras 2 es: ", mayor(CadenaA, CadenaB))

