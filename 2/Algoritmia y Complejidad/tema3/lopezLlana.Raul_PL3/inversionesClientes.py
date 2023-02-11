from random import randint
'''Esta función aplicará el algoritmo DyV para calcular el numero de inversiones de una array'''
def funcion(cliente):
    inversion=0
    '''Si el array contiene más de un elemento, tengo que dividirlo'''
    if(len(cliente)>1):
        '''Divido en 2 grupos'''
        print("Divido ",cliente)
        longitud = len(cliente) // 2
        inversion1, cliente1 = funcion(cliente[:longitud])
        inversion2, cliente2 = funcion(cliente[longitud:])
        '''Sumo el numero de inversiones de cada uno'''
        inversion+=inversion1+inversion2
        '''calculo las inversiones y reordeno los 2 arrays'''
        x=y=i=0
        print("ordeno ",cliente1," y ",cliente2)
        while(x<len(cliente1) and y<len(cliente2)):
            if(cliente1[x]>cliente2[y]):
                cliente[i]=cliente2[y]
                '''Sumo al numero de inveriones todos los elementos que queden por comparar del array 1'''
                inversion+=len(cliente1)-x
                y+=1
                i+=1
            else:
                cliente[i]=cliente1[x]
                x += 1
                i += 1
        '''Miro los arrays y termino de insertar los elementos de mayor peso'''
        while (x < len(cliente1)):
            cliente[i] = cliente1[x]
            x += 1
            i += 1
        while (y < len(cliente2)):
            cliente[i] = cliente2[y]
            y += 1
            i += 1
    '''Devuelvo el numero de inversiones total y el array ordenado'''
    return inversion,cliente




#region main
'''Declaro el numero de elementos'''
N=10
cliente=[]
'''Relleno las valoraciones del cliente sin repetir notas'''
for i in range(1,5):
    numero = randint(1, 10)
    while(cliente.__contains__(numero)):
        numero = randint(1, 10)
    cliente.append(numero)

'''muestro sus gustos por pantalla'''
print(cliente)

'''Aplico el algorimo de divide y vencerás'''
inversiones, clientes =funcion(cliente)
print("total de inversiones  usando DyV: ",inversiones)
#endregion

'''caso 1'''
cliente=[6, 4, 3, 1, 8, 7, 2, 5]
print("\n\nCaso 1: \n",cliente)
inversiones, clientes =funcion(cliente)
print("total de inversiones  usando DyV: ",inversiones)

'''caso 2'''
cliente=[7, 13, 2, 19, 10, 4, 9, 20, 1, 5, 15, 17, 6, 18, 3, 14, 16, 8, 12, 11]
print("\n\nCaso 2: \n",cliente)
inversiones, clientes =funcion(cliente)
print("total de inversiones  usando DyV: ",inversiones)


