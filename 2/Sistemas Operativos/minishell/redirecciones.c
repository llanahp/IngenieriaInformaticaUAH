/*
*****************************************************************************************************************************
* Fecha Inicio: 03/01/2021                                                                                                  *
* Autores: Elena Martin Naranjo, Raul López Llana, Soledad Hernández Romero, Luis Ángel Barderas 		            *
* Objetivo: Implementar el tratamiento ordenes externas con redirecciones de entrada o salida.                              *  				                          *
*****************************************************************************************************************************
*/

#include <stdio.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <stdlib.h>
#include <fcntl.h>


/* funcion que abre el archivo situado en la posicion indice_entrada+1 */
/* de la orden args y elimina de ella la redireccion completa          */
                                  
void redirec_entrada(char **args, int indice_entrada, int *entrada)
{   
   int fd;
	fd= open(args[indice_entrada+1], O_RDONLY);	/*Abre el archivo situado en la posicion indice_entrada+1 en modo solo lectura*/
	if(fd == -1)
	{
		printf("Error en la creación del TDA");		
	}else{		/*libera el espacio de memoria de la redireccion de entrada del array args y los cambia a NULL*/
		*entrada= fd;
		free(args[indice_entrada]); 
		free(args[indice_entrada+1]);  
		args[indice_entrada] = NULL;
		args[indice_entrada+1] = NULL; 
	}
}

/* funcion que abre el archivo situado en la posicion indice_salida+1 */
/* de la orden args y elimina de ella la redireccion completa         */

void redirec_salida(char **args, int indice_salida, int *salida)
{  
   int fd;
	fd = open(args[indice_salida+1], O_RDWR | O_CREAT | O_TRUNC, 0666);	/*Abre el archivo situado en la posicion indice_salida+1 en 
										modo lectura y escritura y trunca su tamaño a 0 para sobreescribir el contenido.
										Si no existe el archivo de salida, lo crea con permisos de lectura y escritura*/
												       
	if (fd == -1)
	{
		printf("Error al intentar crear la TDA"); 
	}
	else 		/*libera el espacio de memoria de la redireccion de salida del array args y los cambia a NULL*/
	{
		*salida = fd;
		free(args[indice_salida]);
		free(args[indice_salida+1]);
		args[indice_salida] = NULL;
		args[indice_salida+1] = NULL;
  }
}


