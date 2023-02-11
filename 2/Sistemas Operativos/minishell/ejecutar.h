/*
*****************************************************************************************************************************
* Fecha Inicio: 29/11/2020                                                                                                  *
* Autores: Elena Martin Naranjo, Raul López Llana, Soledad Hernández Romero, Luis Ángel Barderas 		                        *
* Objetivo: Creacion del documento ejecutar.h para la correcta compilacion de la minishell		                              *
*****************************************************************************************************************************
*/

#ifndef EJECUTAR_H
#define EJECUTAR_H

pid_t ejecutar_orden(const char *orden,int entrada, int salida, int *pbackgr);	/* declaracion de la funcion ejecutar_orden */
void ejecutar_linea_ordenes(const char *orden);  /* declaracion de la funcion ejecutar_linea_orden */
void secuencia_ordenes(const char *orden);  /* declaracion de la funcion secuencia_ordenes */

int ** crear_pipes(int nordenes); /*declaración de la función crear_pipes*/
#endif
 
