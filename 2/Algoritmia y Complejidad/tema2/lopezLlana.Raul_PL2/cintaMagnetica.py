from random import randint
'''Creo el objeto fichero que es el que estará dentro de una cinta '''
class fichero(object):
    longitud=0
    llamadas=0
    def __init__(self,x,y):
        self.longitud=x
        self.llamadas=y

    def __str__(self):
        cadena= "longitud: "+self.longitud+"\nllamadas: "+self.llamadas
        return cadena

'''Crea de forma aleatoria la longitud y el numero de llamadas de cada uno de los fichero que están en la cinta'''
def crearCinta(x):
    cintas = []
    for _ in range(x):
        cintas.append(fichero(randint(1,100),randint(1,20)))
    return cintas

'''para hacer la ordenación, voy a utilizar el metodo de la burbuja'''
def ordenarCintas(cintas):
    totalCintas=len(cintas)
    for i in range(totalCintas):
        for j in range(0,totalCintas-i-1):
            if ((cintas[j].longitud / cintas[j].llamadas)) > ((cintas[j + 1].longitud / cintas[j + 1].llamadas)):
                cintas[j],cintas[j + 1] = cintas[j + 1],cintas[j]
    return cintas

'''main'''
cintas=crearCinta(3)
cintas=ordenarCintas(cintas)
'''Listo todos los fichero de la cinta para ver su tamaño y las veces que se le llama'''
for fichero in cintas:
    print("\n\tLongitud: ", fichero.longitud, "\n\tLlamadas: ",fichero.llamadas, "\n\tLL: ", fichero.longitud/fichero.llamadas)