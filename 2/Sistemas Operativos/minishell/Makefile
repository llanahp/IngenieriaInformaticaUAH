
#*****************************************************************************************************************************
#* Fecha Inicio: 02/01/2021                                                                                                  *
#* Autores: Elena Martin Naranjo, Raul López Llana, Soledad Hernández Romero, Luis Ángel Barderas 		             *
#* Objetivo: Creacion del makefile para compilar la minishell		    						     *
#*****************************************************************************************************************************


CC = gcc
CFLAGS = -g -Wall	#-g incluye en el ejecutable generado la información necesaria para poder rastrear los errores usando un depurador
			#-Wall muestra todos los mensajes de error y advertencia del compilador

all: minishell

#Crear el ejecutable que dependera de los archivos entrada_minishell.o ejecutar.o libmemoria.o libshell.a minishell.o redirecciones.o
minishell: entrada_minishell.o ejecutar.o libmemoria.o libshell.a minishell.o redirecciones.o
	$(CC) $(CFLAGS) entrada_minishell.o ejecutar.o libmemoria.o minishell.o redirecciones.o -L./ -lshell -o minishell 

#Crear documento entrada_minishell.o
entrada_minishell.o: entrada_minishell.c entrada_minishell.h 
	$(CC) $(CFLAGS) -c entrada_minishell.c

#Crear documento ejecutar.o
ejecutar.o: ejecutar.c ejecutar.h parser.h libmemoria.h redirecciones.h
	$(CC) $(CFLAGS) -c ejecutar.c

#Crear documento libmemoria.o
libmemoria.o: libmemoria.c
	$(CC) $(CFLAGS) -c libmemoria.c

#Crear la biblioteca libshell.a
libshell.a: parser.o internas.o
	ar -rs libshell.a parser.o internas.o 

#Crear documento minishell.o
minishell.o: minishell.c entrada_minishell.h internas.h ejecutar.h
	$(CC) $(CFLAGS) -c minishell.c

#Crear documento redirecciones.o
redirecciones.o: redirecciones.c
	$(CC) $(CFLAGS) -c redirecciones.c

#Eliminar los archivos.o creados a través del clean (la opcion -f fuerza el borrado incluso si están protegidos frente a escritura)
.PHONY: clean
clean:
	rm -f entrada_minishell.o ejecutar.o libmemoria.o minishell.o redirecciones.o libshell.a minishell
