from random import randint

paises = ['Afghanistan', 'Aland Islands', 'Albania', 'Algeria', 'American Samoa', 'Andorra', 'Angola', 'Anguilla', 'Antarctica', 'Antigua and Barbuda', 'Argentina', 'Armenia', 'Aruba', 'Australia', 'Austria', 'Azerbaijan', 'Bahamas', 'Bahrain', 'Bangladesh', 'Barbados', 'Belarus', 'Belgium', 'Belize', 'Benin', 'Bermuda', 'Bhutan', 'Monaco', 'Mongolia', 'Montenegro', 'Montserrat', 'Morocco', 'Mozambique', 'Myanmar', 'Namibia', 'Nauru', 'Nepal', 'Spain' ,'Ecuador', 'Egypt', 'El Salvador', 'Germany', 'Ghana', 'Gibraltar', 'Greece', 'Greenland', 'Grenada', 'Guadeloupe', 'Guam', 'Guatemala', 'Guinea']
tipoAsignaturas=["básica","obligatoria", "transversal","optativa" ]
tiposBecas=["KA103", "KA107", "MIT", "Franklin","SICUE" , "Global"]
duraciones=["1","2","A"]
notaOrigen={"A+":10.0, "A":9.8, "A-":9.5, "B+":9.0, "B":8.5 , "B-":8.0, "C+":7.5, "C":7.3, "C-":7.0, "D+":6.5,"D":6.0, "D-":5.5, "E": 5.0, "F":4.0}

class universidad:
    def __init__(self, codigo, nombre, direccion, pais, telefono, email):
        self.codigo = codigo
        self.nombre = nombre
        self.direccion = direccion
        self.pais = pais
        self.telefono = telefono
        self.email = email

    def toString(self):
        print(str(self.codigo)+"," +self.nombre+"," + self.direccion+"," + self.pais+"," + str(self.telefono) +"," + self.email + "\n")
    def getCadena(self):
        return str(self.codigo)+"," +self.nombre+"," + self.direccion+"," + self.pais+"," + str(self.telefono) +"," + self.email + "\n"
    def getCodigo(self):
        return str(self.codigo)

#d = universidad('Fido')

#universidades
ficheroUniversidades = open("universidades.csv", "w")
universidades=[]
for a in range(0,100000):
    uni=universidad(str(a),str("Universidad"+str(a)),str("Direccion"+str(a)),str(paises[randint(0, 49)]),str(randint(100000000, 999999999)),str('Universidad'+str(a)+"@hotmail.com"))
    universidades.append(uni)
    ficheroUniversidades.write(uni.getCadena())
ficheroUniversidades.close()

print("Universidades Listas")

class estudiante:
    def __init__(self, codigo, nombre,apellidos, direccion, pais, telefono, email,creditos,universidad,cod_universidad):
        self.codigo = codigo
        self.apellidos = apellidos
        self.nombre = nombre
        self.direccion = direccion
        self.pais = pais
        self.telefono = telefono
        self.email = email
        self.creditos = creditos
        self.universidad=universidad
        self.cod_universidad = cod_universidad

    def toString(self):
        print(str(a) + "," + self.nombre + "," + self.apellidos + "," + self.direccion + "," + self.pais + "," + str(self.telefono) + "," + self.email + "," + str(self.creditos) + "," + str(self.cod_universidad) + "\n")
    def getCadena(self):
        return str(a) + "," + self.nombre + "," + self.apellidos + "," + self.direccion + "," + self.pais + "," + str(self.telefono) + "," + self.email + "," + str(self.creditos) + "," + str(self.cod_universidad) + "\n"
    def getCodigoEstudiante(self):
        return self.codigo
    def getCodigoUniversidad(self):
        return self.cod_universidad
    def getObjetoUniversidad(self):
        return self.universidad

#Estudiantes
estudiantes=[]
ficheroEstudiantes = open("estudiantes.csv", "w")
for a in range(0,5000000):#TODO 5000000
    universi=universidades[randint(0,99999)]
    estu = estudiante(str(a),'Estudiante'+str(a),'Apellido'+str(a)+' apellido'+str(a) , str('Direccion'+str(a)) ,str(paises[randint(0, 49)]) , str(randint(100000000, 999999999)) , str('Estudiante'+str(a)+"@hotmail.com") , str(randint(60,200)) , universi,str(universi.getCodigo()))
    estudiantes.append(estu)
    ficheroEstudiantes.write(estu.getCadena())
ficheroEstudiantes.close()

print("Estudiantes Listos")



class asignatura:
    def __init__(self, codigo, nombre,creditos,tipo,universidad,codigo_universidad):
        self.codigo = codigo
        self.nombre = nombre
        self.creditos = creditos
        self.tipo = tipo
        self.universidad =universidad
        self.codigo_universidad =codigo_universidad

    def toString(self):
        print(str(self.codigo) + "," + self.nombre + "," + str(self.creditos) + "," +self.tipo+ "," +str(self.codigo_universidad) + "\n")
    def getCadena(self):
        return str(self.codigo) + "," + self.nombre + "," + str(self.creditos) + "," +self.tipo+ "," +str(self.codigo_universidad) + "\n"
    def getCodigo(self):
        return str(self.codigo)
    def getCodigoUniversidad(self):
        return str(self.codigo_universidad)
    def getObjetoUniversidad(self):
        return self.universidad



class asignaturasUniversidad:
    def __init__(self, universidad, listadoAsignaturas):
        self.universidad = universidad
        self.listadoAsignaturas = listadoAsignaturas




# asignaturas
ficheroAsignaturas = open("asignaturas.csv", "w")
asignaturas=[]
agrupacion = []
codigoAsignarua=0
for a in range(len(universidades)):
    asigParcial = []
    for b in range(0, randint(15, 20)):
        universi = universidades[a]
        asig=asignatura(codigoAsignarua,str("Asignatura_"+str(universidades[a].getCodigo())+"_"+str(b)),str(randint(4, 12)),tipoAsignaturas[randint(0, 3)],universi,str(universi.getCodigo()))
        codigoAsignarua+=1
        asignaturas.append(asig)
        asigParcial.append(asig)
        ficheroAsignaturas.write(asig.getCadena())
    agrupacion.append(asignaturasUniversidad(universi, asigParcial))
ficheroAsignaturas.close()

print("Asignaturas Listas")


class estancia:
    def __init__(self, fecha_inicio, fecha_fin,tipo_beca,duracion,cuantia,estudiante,cod_estudiante,universidad,cod_universidad):
        self.fecha_inicio = fecha_inicio
        self.fecha_fin = fecha_fin
        self.tipo_beca = tipo_beca
        self.duracion = duracion
        self.cuantia =cuantia
        self.estudiante =estudiante
        self.cod_estudiante =cod_estudiante
        self.universidad =universidad
        self.cod_universidad =cod_universidad

    def toString(self):
        print(str(self.fecha_inicio + "," + self.fecha_fin + "," + self.tipo_beca + "," +self.duracion+ "," + str(self.cuantia)+ "," + str(self.cod_estudiante)+ "," + str(self.cod_universidad)+  "\n"))
    def getCadena(self):
        return self.fecha_inicio + "," + self.fecha_fin + "," + self.tipo_beca + "," +self.duracion+ "," + str(self.cuantia)+ "," + str(self.cod_estudiante)+ "," + str(self.cod_universidad)+  "\n"
    def getCodigoEstudiante(self):
        return self.cod_estudiante
    def getCodigoUniversidad(self):
        return self.cod_universidad
    def getDuracionesBeca(self):
        return self.duracion
    def getObjetoUniversidad(self):
        return self.universidad
    def getObjetoEstudiante(self):
        return self.estudiante


#estancias
estancias=[]
ficheroEstancias = open("estancias.csv", "w")
for a in range(len(estudiantes)):
    universidadDestino=universidades[randint(0,len(universidades)-1)]
    while(universidadDestino==estudiantes[a].getCodigoUniversidad()):
        universidadDestino = universidades[randint(0, len(universidades) - 1)]
    duracion = duraciones[randint(0,2)]
    if (duracion == "1"):
        fecha_fin = "1/4/2021 1:30 AM"
    else:
        if(duracion=="2"):
            fecha_fin = "1/8/2021 1:30 AM"
        else:
            fecha_fin = "1/1/2022 1:30 AM"
    estan=estancia("1/1/2021 1:30 AM", fecha_fin, str(tiposBecas[randint(0, 5)]), duracion, str(randint(500,2000)),estudiantes[a],estudiantes[a].getCodigoEstudiante(),universidadDestino,universidadDestino.getCodigo())
    estancias.append(estan)
    ficheroEstancias.write(estan.getCadena())
ficheroEstancias.close()

print("Estancias Listas")



class convalidacion:
    def __init__(self, nota_destino, nota_origen,fecha,estudiante,cod_estudiante,universidadDestino,cod_universidad,asignatura_origen="",asignatura_destino=""):
        self.nota_destino = nota_destino
        self.nota_origen = nota_origen
        self.fecha = fecha
        self.estudiante =estudiante
        self.cod_estudiante =cod_estudiante
        self.universidadDestino =universidadDestino
        self.cod_universidad =cod_universidad
        self.asignatura_origen=asignatura_origen
        self.asignatura_destino=asignatura_destino

    def getObjetoUniversidadDestino(self):
        return self.universidadDestino
    def getObjetoEstudiante(self):
        return self.estudiante
    def getCodigoUniversidadDestino(self):
        return self.cod_universidad
    def getCodigoEstudiante(self):
        return self.cod_estudiante
    def toString(self):
        print(str(self.nota_destino) + "," + str(self.nota_origen) + "," + self.fecha + "," +self.cod_estudiante+  "," +self.cod_universidad+ "," +self.asignatura_origen+  "," +self.asignatura_destino+ "\n")
    def getCadena(self):
        return str(self.nota_destino) + "," + str(self.nota_origen) + "," + self.fecha + "," +self.cod_estudiante+"," +self.cod_universidad+ "," +self.asignatura_origen+ "," +self.asignatura_destino+ "\n"
    def setAsignaruraOrigen(self,asignatura_origen):
        self.asignatura_origen=asignatura_origen
    def setAsignaruraDestino(self,asignatura_destino):
        self.asignatura_destino=asignatura_destino

#convalidaciones
ficheroConvalidaciones = open("convalidaciones.csv", "w")
convalidaciones=[]
for a in range(0,len(estancias)):
    valor = randint(0,13)
    estanAux=estancias[a]
    conva=convalidacion(list(notaOrigen.items())[valor][0],list(notaOrigen.items())[valor][1],"1/4/2021 1:30 AM",estanAux.getObjetoEstudiante(),estanAux.getCodigoEstudiante(),estanAux.getObjetoUniversidad(),estanAux.getCodigoUniversidad())
    asignaturasOrigen = []
    asignaturasDestino = []
    try:

        if(estanAux.getDuracionesBeca()==duraciones[0] or estanAux.getDuracionesBeca() == duraciones[1]):
            estu = conva.getObjetoEstudiante()
            a=b=False
            for r in agrupacion:
                if (a and b):
                    break
                if(r.universidad.getCodigo()==estu.getCodigoUniversidad()):
                    a=True
                    asignaturasOrigen=r.listadoAsignaturas
                if (r.universidad.getCodigo() == conva.getCodigoUniversidadDestino()):
                    b = True
                    asignaturasDestino = r.listadoAsignaturas
            #depuracion
            if (len(asignaturasDestino) == 0 or len(asignaturasOrigen) == 0):
                print(estu.toString())
                print(conva.getCodigoUniversidadDestino())
                for a in universidades:
                    if(a.getCodigo()==conva.getCodigoUniversidadDestino()):
                        a.toString()
                for a in asignaturas:
                    if (a.getCodigoUniversidad() == conva.getCodigoUniversidadDestino()):
                        a.toString()


            for b in range(0, randint(3, 5)):
                conva.setAsignaruraOrigen(asignaturasOrigen[b].getCodigo())
                conva.setAsignaruraDestino(asignaturasDestino[b].getCodigo())
                convalidaciones.append(conva)

        else:
            estu = conva.getObjetoEstudiante()
            a=b=False
            for r in agrupacion:
                if(a and b):
                    break
                if (r.universidad.getCodigo() == estu.getCodigoUniversidad()):
                    a=True
                    asignaturasOrigen = r.listadoAsignaturas
                if (r.universidad.getCodigo() == conva.getCodigoUniversidadDestino()):
                    b=True
                    asignaturasDestino = r.listadoAsignaturas
            #depuracion
            if (len(asignaturasDestino) == 0 or len(asignaturasOrigen) == 0):
                print(estu.toString())
                print(conva.getCodigoUniversidadDestino())
                for a in universidades:
                    if(a.getCodigo()==conva.getCodigoUniversidadDestino()):
                        a.toString()
                for a in asignaturas:
                    if (a.getCodigoUniversidad() == conva.getCodigoUniversidadDestino()):
                        a.toString()
            for b in range(0, randint(6, 10)):
                conva.setAsignaruraOrigen(asignaturasOrigen[b].getCodigo())
                conva.setAsignaruraDestino(asignaturasDestino[b].getCodigo())
                convalidaciones.append(conva)
    except:
        print("Error")
        print(b)
        print(conva.estudiante.getCodigoEstudiante())
        print(asignaturasOrigen)
        print(asignaturasDestino)
        estanAux.getObjetoEstudiante()
        print(len(asignaturasOrigen), " _ ",len(asignaturasDestino))

    ficheroConvalidaciones.write(conva.getCadena())

ficheroConvalidaciones.close()

print("convalidaciones Listas")

