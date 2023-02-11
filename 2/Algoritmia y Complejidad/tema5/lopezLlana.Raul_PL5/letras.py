'''Dado un caracter, miro si es una de los 4 que pertenecen a los indices de la tabla'''
def caracterValido(caracter):
    if (caracter == "a" or caracter == "b" or caracter == "c" or caracter == "d"):
        return True
    else:
        return False

'''Dado un caracter, digo a que fila o columna de indice pertenece dicho caracter'''
def indice(caracter):
    resul = -1
    '''Fila o columna 0'''
    if (caracter == "a"):
        resul = 0
    '''Fila o columna 1'''
    if (caracter == "b"):
        resul = 1
    '''Fila o columna 2'''
    if (caracter == "c"):
        resul = 2
    '''Fila o columna 3'''
    if (caracter == "d"):
        resul = 3
    return resul

'''Metodo principal del programa'''
def cambiarCadena(cadena):
    '''En caso de haber lledado a la cadena con solo un caracter, la muestro y termino'''
    if (len(cadena) == 1):
        print("cadena con longitud 1 es: ", cadena)
        exit(1)
    '''En caso de tener la cadena con longitud mayor a 1'''
    for a in range(len(cadena) - 1):
        '''Me guardo los 2 caracteres que voy a tratar'''
        caracter1 = cadena[a]
        caracter2 = cadena[a + 1]
        '''Compruebo que sean caracteres validos para mi tabla de correspondencias'''
        if (caracterValido(caracter1) and caracterValido(caracter2)):
            '''Cambio estos 2 caracteres por su equivalente'''
            texto = cadena.replace(caracter1 + caracter2, tablero[indice(caracter1)][indice(caracter2)])
            print(cadena," => " , caracter1 + caracter2," = ",tablero[indice(caracter1)][indice(caracter2)] ," => ", texto)
            '''Llamada recursiva con el cambio realizado'''
            cambiarCadena(texto)
        else:
            '''Si he encontrado un caracter que no puedo convertir, paro'''
            print("No puedo reducirlo a un caracter")
            exit(1)
    return

'''Creo el tablero con las conversiones'''
tablero = ["b", "b", "a", "d"], ["c", "a", "d", "a"], ["b", "a", "c", "c"], ["d", "c", "d", "b"]
'''Defino mi cadena que quiero convertir'''
texto = "acabadas"  # final esperado D
print("tablero")
for a in tablero:
    print(a)
print("\ncadena: ",texto)
print("Comienzo\n------------")
'''Comienzo con la conversión'''
cambiarCadena(texto)
