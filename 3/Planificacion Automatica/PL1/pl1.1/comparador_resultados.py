import matplotlib.pyplot as plt

# lista de nombres de los ficheros
ficheros = ["./statistics/ff/domine_300.txt", 
"./statistics/satplan/domine_300.txt",
"./statistics/downward/domine_300.txt",
"./statistics/lpgtd/domine_300.txt", 
"./statistics/sgplan40/domine_300.txt"]

#ficheros = ["./statistics/ff/domine_60.txt", 
#"./statistics/satplan/domine_60.txt",
#"./statistics/downward/domine_60.txt",
#"./statistics/lpgtd/domine_60.txt", 
#"./statistics/sgplan40/domine_60.txt"]

# para cada fichero, leemos los números y los guardamos en una lista
datos = []
datos2 = []
for fichero in ficheros:
    complexity = []
    time = []
    with open(fichero, "r") as archivo:
        for linea in archivo:
            partes = linea.strip().split(",")
            time.append(partes[1])
            complexity.append(partes[2])
        #numeros = [float(linea.strip()) for linea in archivo]
        datos.append(time)
        print(max(time))
        datos2.append(complexity)


# creamos la gráfica
colores = ['b', 'g', 'r', '#00e0ee', '#ee7700']
for i, d in enumerate(datos):
    nomrbe_fichero=ficheros[i].strip().split("/")[2]
    plt.plot(datos2[i],d, color=colores[i], label=f"{nomrbe_fichero}")

# añadimos leyendas y títulos
plt.legend()
plt.title("Comparativa planificadores")
plt.xlabel("Complejidad")
plt.ylabel("Tiempo (s)")
plt.xticks(range(3, 100, 5))
plt.yticks(range(0, 0, 15))
if ("60" in ficheros[1]):
    plt.savefig(f"./statistics/Comparador60.png") # Save the graph
else:
    plt.savefig(f"./statistics/Comparador300.png") # Save the graph
# mostramos la gráfica
plt.show()
