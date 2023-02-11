/*
*****************************************************************************************************************************
* Fecha Inicio: 29/11/2020                                                                                                  *
* Autores: Elena Martin Naranjo, Raul López Llana, Soledad Hernández Romero, Luis Ángel Barderas 		            *
* Objetivo: Correcta programacion de la ejecucion de ordenes externas de la minishell	    				    *
*****************************************************************************************************************************
*/

#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <string.h>
#include <stdio.h>

#include "parser.h"
#include "ejecutar.h"
#include "libmemoria.h"
#include "redirecciones.h"


pid_t ejecutar_orden(const char *orden, int entrada , int salida ,int *pbackgr)
{
   char **args;    /*array de caracteres que almacenará la orden*/
   pid_t pid;      /*identificador del padre y del hijo ( pid del padre != 0, pid del hijo == 0)*/
   int indice_ent = -1, indice_sal = -1; /* por defecto, no hay < ni > */
  
   /*En caso de solo pulsar la tecla Enter, devuelve -1*/
   if ((args = parser_orden(orden, &indice_ent, &indice_sal, pbackgr)) == NULL) 
   {	
      return(-1);
   }
   
   /*Convierte la orden introducida en un array de cadenas y la almacena en args, si hay < o > cambia el valor de indice_ent o indice_salida  
   a la posicion en la que se encuentra*/
   args = parser_orden(orden, &indice_ent, &indice_sal, pbackgr);
   
   if (indice_ent != -1)
	{
		redirec_entrada(args, indice_ent, &entrada);	/* llamada a la funcion redirec_entrada cuando indice_ent es distinto de -1, por tanto hay "<" */
	}
   if (indice_sal != -1)
	{
		redirec_salida(args, indice_sal, &salida);	/* llamada a la funcion redirec_salida cuando indice_sal es distinto de -1, por tanto hay ">" */
	} 
	
	pid = fork(); //Crea minishell hija
 		
 			
	if (pid == 0) //Caso del hijo
	{
	
		if (entrada != 0)
        	{
			dup2(entrada, STDIN_FILENO);	/*Copia el descriptor de archivo (puntero a la TDA) de la entrada en el índice de entrada de la TDA 
							del proceso actual*/
			close(entrada);
    		}
		if (salida != 1)
        	{
        	
			dup2(salida, STDOUT_FILENO);	/*Copia el descriptor de archivo (puntero a la TDA) de la salida en el índice de salida de la TDA 
							del proceso actual*/
			close(salida);
		}

		execvp(args[0], args);// ejecuto la orden
		exit(0);	
   	}
   	else
   	{		

                if(entrada !=0)
        	{
			close(entrada);
		}
		if(salida !=1)
        	{
			close(salida);
		}
							
		//El padre llama a "free_argumentos" para liberar memoria y devuleve el pid del proceso
   		free_argumentos(args);
   		return pid;
   	}  

   /* Si la linea de ordenes posee tuberias o redirecciones, podra incluir */
   /* aqui, en otras fases de la practica, el codigo para su tratamiento.  */
	  								
}

int ** crear_pipes ( int nordenes )
{
	int ** pipes = NULL ;
	int i ;
	pipes = ( int **) malloc ( sizeof ( int *) * ( nordenes - 1));
	for ( i = 0; i < ( nordenes - 1); i ++)
	{
		pipes [ i ] = ( int *) malloc ( sizeof ( int ) * 2);
		pipe(pipes[i]);  //linea de codigo para crear tuberia pipes [ i ]	
	}
	return ( pipes );
}

 
void ejecutar_linea_ordenes(const char *orden)
{
   int backgr;  //almacena el background del proceso ( ==0 si se ejecuta en primer plano, !=0 si se ejecuta en segundo plano)
   int estado;  //almacena el estado de la minishell hija
   
   char ** ordenes;
   int nordenes;
   int **pipes;
   pid_t *pids=NULL;
   int i, entrada, salida;
   
   
   /*convierte la orden introducida en un array de cadenas, siendo cada cadena una orden simple, y devuelve el número total de órdenes simples y lo almacena en nordenes*/
   ordenes = parser_pipes( orden , &nordenes);
   							
   //Reserva memoria dinámica para el array pids
   pids = (pid_t *)malloc(sizeof(pid_t) * nordenes);
   
   //crea tantas tuberias como ordenes-1 existan
   pipes = crear_pipes( nordenes );
   
   for (i = 0; i < nordenes; i++)
   {
      if (i == 0)  //si es la primera orden
      {
         if (nordenes > 1)         //si no es la única orden, se guarda en salida el descriptor de escritura del pipe siguiente
            salida = pipes[0][1];  
         else
            salida = STDOUT_FILENO; //si no, guarda en salida el descriptor de salida estándar (pantalla)
         pids[0] = ejecutar_orden(ordenes[0], STDIN_FILENO, salida, &backgr); 
      }

      else if ((i == (nordenes - 1)) && (nordenes > 1)) //si es la última orden
      {
         entrada = pipes[nordenes - 2][0];  //se guarda en entrada el descriptor de lectura del pipe anterior
         pids[i] = ejecutar_orden(ordenes[i], entrada, STDOUT_FILENO, &backgr);
      }

      else{  //si es una orden intermedia
         pids[i] = ejecutar_orden(ordenes[i], pipes[i-1][0], pipes[i][1], &backgr);  
        }
         
	   //Comprueba si es la minishell padre y si la orden se ejecuta en primer plano
            if(backgr==0 && pids[nordenes -1] > 0)
	   {
	   	//se espera hasta que el hijo termine de ejecutarse y se almacena el estado en el que ha terminado
	   	waitpid(pids[nordenes -1], &estado, 0);
	   }
   }
   
   free_ordenes_pipes( ordenes , pipes , nordenes );   //libera las estructuras ordenes y pipes para el número de órdenes existentes
   free(pids);                                         // libera el array pids
}   

void secuencia_ordenes(const char *orden)
{
	
	char *token;
	char *saveptr;

	token = strtok_r((char *)orden, ";", &saveptr); /*separa las ordenes dada una secuencia de órdenes con la función strtoken_r
						          strtoken_r es una función reentrante, es decir, puede ser interrumpida en medio de su ejecución
							  y luego ser llamada de nuevo de forma segura*/
	while (token != NULL)    
        {
		ejecutar_linea_ordenes(token);	
		token = strtok_r(NULL, ";", &saveptr);    //se coge la siguiente orden  
	}
}
