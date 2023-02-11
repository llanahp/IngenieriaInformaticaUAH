from random import randint

'''tablero de 8x8'''
maxTablero = 5


def compro(tablero, posx, posy, movimientos, recorridos):
    if movimientos >= maxTablero * maxTablero:
        print("Solución encontrada para los parámetros:")
        print("\tTamaño del tablero (Filas x Columnas): ", maxTablero, "x", maxTablero)
        for a in recorrido:
            print(a)
        return True

    for fila in range(maxTablero):
        for columna in range(maxTablero):
            '''Compruebo si el movimiento es posible y que no hayamos pasado ya por el'''
            if (tablero[fila][columna] == False and (
                    ((abs(fila - posx) == 1) and (abs(columna - posy) == 2)) or (
                    (abs(fila - posx) == 2) and (abs(columna - posy) == 1)))):
                '''Me muevo a esa posicion'''
                tablero[fila][columna] = True

                cadena = str("".join(("[",
                                      str(fila),
                                      ",",
                                      str(columna),
                                      "]")))

                recorridos.append(cadena)
                '''Llamo a la funcion'''
                resul = compro(tablero, fila, columna, movimientos + 1, recorridos)
                recorridos.remove(cadena)
                tablero[fila][columna] = False

                if (resul):
                    recorridos.append(cadena)
                    return True


'''Relleno el tablero (False si no he pasado por el, True en caso contrario)'''

tablero = [[False for col in range(maxTablero)] for fil in range(maxTablero)]

'''Posicion inicial del caballo'''
posx = randint(0, maxTablero - 1)
posy = randint(0, maxTablero - 1)
'''Marco visitada la posicion inicial'''
print("Posicion Inicial: x=", posx, " y:=", posy)
tablero[posy][posy] = True
recorrido = ['']
'''Evaluo si es posible completar el tablero'''
if (compro(tablero, posx, posy, 1, recorrido) is None):
    print("No es posible recorrer todo el tablero")
else:
    print("posible")
