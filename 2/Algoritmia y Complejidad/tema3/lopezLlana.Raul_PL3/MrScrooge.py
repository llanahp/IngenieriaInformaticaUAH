'''Variables que se pueden cambiar'''
Nmonedas=38
PesoReales=2
PesoFalsa=1
PosicionFalsa=25

'''Esta función compara dos numero pasados por referencia
    El resultado será 2 si elemento1>elemento2
        El resultado será 1 si elemento1<elemento2'''
def xmayorquey(elemento1,elemento2):
    if (elemento1 > elemento2):
        return 2
    else:
        return 1

'''Esta función aplicará el algoritmo DyV para decir cual es la moneda falsa
Para poder saber si una moneda es falsa o no, necesitaré compararlo minimo con otras 2 monedas'''
def funcion(bolsa):
    iguales=False
    resul=0
    posi=-1

    '''Cuando tenemos 3 monedas, podemos compararlas'''
    if (len(bolsa) == 3):
        '''Realizo distintas comparaciones para ver si son iguales.
        En caso de encontrar una que no sea igual, almaceno su posición y si pesa más o menos'''
        if (bolsa[0] == bolsa[1]):
            if (bolsa[1] != bolsa[2]):
                resul = xmayorquey(bolsa[2], bolsa[0])   
                posi =3
            else:
                iguales=True
        else:
            if (bolsa[0] == bolsa[2]):
                # todos igual
                resul = xmayorquey(bolsa[1], bolsa[0])   
                posi =2
            else:
                 resul = xmayorquey(bolsa[0], bolsa[1])   
                 posi =1

    '''Cuando tenemos 4 monedas, podemos compararlas'''
    if (len(bolsa) == 4):
        '''Realizo distintas comparaciones para ver si son iguales.
               En caso de encontrar una que no sea igual, almaceno su posición y si pesa más o menos'''
        if (bolsa[0] == bolsa[1]):
            if (bolsa[1] == bolsa[2]):
                if (bolsa[2] != bolsa[3]):
                    resul = xmayorquey(bolsa[3], bolsa[0]) 
                    posi=4
                else:
                    iguales = True
            else:
                resul = xmayorquey(bolsa[2], bolsa[0]) 
                posi =3
        else:
            if (bolsa[0] == bolsa[3]):
                resul = xmayorquey(bolsa[1], bolsa[3])   
                posi =2
            else:
                resul = xmayorquey(bolsa[0], bolsa[3])  
                posi =1

    '''Cuando tenemos 5 monedas, podemos compararlas'''
    if (len(bolsa) == 5):
        '''Realizo distintas comparaciones para ver si son iguales.
               En caso de encontrar una que no sea igual, almaceno su posición y si pesa más o menos'''
        if (bolsa[0] == bolsa[1]):
            if (bolsa[1] == bolsa[2]):
                if (bolsa[2] == bolsa[3]):
                    if (bolsa[3] != bolsa[4]):
                        resul = xmayorquey(bolsa[4], bolsa[0])   
                        posi=5
                    else:
                        iguales = True
                else:
                    resul = xmayorquey(bolsa[3], bolsa[0])   
                    posi=4
            else:
                if (bolsa[1] == bolsa[3]):
                    resul = xmayorquey(bolsa[2], bolsa[3])   
                    posi =3
                else:
                    resul = xmayorquey(bolsa[1], bolsa[3])   
                    posi =2
        else:
            if (bolsa[0] == bolsa[3]):
                resul = xmayorquey(bolsa[1], bolsa[3])   
                posi =2
            else:
                resul = xmayorquey(bolsa[0], bolsa[3])   
                posi =1

    '''En caso de tener un número de monedas demasiado alto como para empezar a compararlas, entra aquí'''
    if(resul==0 and iguales==False):
        '''Si tenemos 2 o menos monedas es porque se ha introducido mál el numero de monedas inicial'''
        if(len(bolsa)<=2):
            print("Error en cantidad de bolsa")
            return 0,0
        else:
            '''En caso de tener 6 y 8 monedas en un grupo, tendremos que dividirnas en 2 grupos'''
            '''Miro cuantos elementos por grupo ha de tener'''
            if(len(bolsa)>=6 and len(bolsa)<=8):
                longitud = len(bolsa) // 2
                '''Divido en grupos las monedas y vuelvo a llamar a la función'''
                primeraDivision = funcion(bolsa[:longitud])
                segundaDivision = funcion(bolsa[longitud:])
                a = max(primeraDivision, segundaDivision)
                '''compruebo si se ha encontrado la moneda falsa'''
                if (primeraDivision[1] == segundaDivision[1]):
                        posi = -1
                else:
                    if (primeraDivision[1] > segundaDivision[1]):
                        posi = primeraDivision[1]
                    else:
                        posi = segundaDivision[1]+ longitud
                '''Devuelvo el resultado obtenido'''
                a = (a[0], posi)
                return a
            else:
                '''En caso de tener más de 8 monedas en un grupo, tendremos que dividirnas en 2 grupos'''
                '''Miro cuantos elementos por grupo ha de tener'''
                longitud = len(bolsa) // 3
                '''Divido en grupos las monedas y vuelvo a llamar a la función'''
                primeraDivision=funcion(bolsa[:longitud])
                segundaDivision=funcion(bolsa[longitud:longitud*2])
                terceraDivision=funcion(bolsa[longitud*2:])
                a=max(primeraDivision,segundaDivision,terceraDivision)

                '''compruebo si se ha encontrado la moneda falsa'''
                if (primeraDivision[1] == segundaDivision[1]):
                    if (segundaDivision[1] == terceraDivision[1]):
                        posi=-1
                    else:
                        posi=terceraDivision[1]+ 2*longitud
                else:
                    if (primeraDivision[1] ==terceraDivision[1]):
                        posi =segundaDivision[1]+longitud
                    else:
                        posi=primeraDivision[1]
                '''Devuelvo el resultado obtenido'''
                a=(a[0],posi)
                return a
    else:
        return resul,posi

    return

'''Esta función rellenará la bolsa con modenas segun los parámetros pasados'''
def rellenarBolsa(bolsa,PesoReales,PesoFalsa,PosicionFalsa):
    for i in range(1, Nmonedas + 1):
        '''Posición de la moneda falsa'''
        if(i==PosicionFalsa):
            '''Peso moneda falsa'''
            bolsa.append(PesoFalsa)
        else:
            '''Peso monedas reales'''
            bolsa.append(PesoReales)


    return bolsa



#region main
'''Relleno la bolsa de monedas en función de los parámetros definidos'''
bolsa=[]
bolsa=rellenarBolsa(bolsa,PesoReales,PesoFalsa,PosicionFalsa)

'''Llamo al a funcion que me dirá cual es la moneda falsa usando el algoritmo DyV'''
masomenos,posi=funcion(bolsa)

'''Muestro por pantalla todas las monedas'''
print(bolsa)

'''Muestro el resultado'''
if(masomenos==2):
    print("pesa mas y se encuentra en la posición: ",posi)
else:
    print("Pesa menos y se encuentra en la posición: ",posi)
#endregion



