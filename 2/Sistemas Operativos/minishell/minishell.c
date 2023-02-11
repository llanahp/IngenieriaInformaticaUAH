/*
*****************************************************************************************************************************
* Fecha Inicio: 01/01/2021                                                                                                  *
* Autores: Elena Martin Naranjo, Raul López Llana, Soledad Hernández Romero, Luis Ángel Barderas 		            *
* Objetivo: Ejecucion de ordenes en la minishell		    						    *
*****************************************************************************************************************************
*/

#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <signal.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <errno.h>

#include "internas.h"
#include "entrada_minishell.h"
#include "ejecutar.h"


//Elimina el task struct del proceso hijo zombie para ordenes externas en segundo plano
static void manejar_sigchild(int signo)
{
	int estado;
	waitpid(-1, &estado, WNOHANG); /*El -1 indica que el waitpid() esperará a cualquier proceso hijo.
                                         La señal WNOHANG permite que el proceso padre no quede bloqueado:
                                         si existe algun hijo zombie, se elimina su task struct y se devuelve su estado
                                         si no existe ningún hijo zombie, devuelve 0 o -1 sin esperar a que terminen los hijos restantes (si hay)*/
}

int main (int argc, char *argv[])
{
	char buf[BUFSIZ];
	struct sigaction sa;                       //Declara una estructura sigaction, que se encargará de gestionar las señales
	memset(&sa, 0, sizeof(sa));
	sa.sa_handler = manejar_sigchild;         //se indica el gestor de la señal
	sa.sa_flags = SA_NOCLDSTOP | SA_RESTART;  /*se especifican dos flags que modifican el comportamiento de la señal:
	                                            SA_NOCLDSTOP: si la señal recibida es SIGCHILD, no generar esta señal cuando un proceso hijo se para.
                                                    SA_RESTART: si se llama al gestor de la señal, no restablece la acción correpondiente a la señal.*/

	sigaction(SIGCHLD, &sa, NULL);  /*Se espera a recibir la señal SIGCHILD, una vez recibida se interrumpe la ejecución, 
	                                  el gestor borra la task struct del proceso zombie y después vuelve al punto donde 
					  se interrumpió la ejecución*/ 


   while (1)
   {
   	imprimir_prompt();
	leer_linea_ordenes(buf);
	if(strcmp(buf, "exit")== 0){	/* Compara la orden introducida y la cadena "exit", si son iguales finaliza el ciclo de ejecución */
		break;
	}else{
		if(es_ord_interna(buf)==1){	/* si es orden interna devuelve el valor 1, y llama función ejecutar_ord_interna() pasandole como parámetro la orden introducida para su ejecución; */
			ejecutar_ord_interna(buf);
		}
		else{
			secuencia_ordenes(buf);
		} 
	}   
   }
   return 0;
}



