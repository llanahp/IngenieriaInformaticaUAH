/*
*****************************************************************************************************************************														    
* Autores: Elena Martin Naranjo, Raul López Llana, Soledad Hernández Romero, Luis Ángel Barderas 						                *
*****************************************************************************************************************************
*/

#ifndef PARSER_H
#define PARSER_H
enum TEstado {
   INICIO_ARG, ARG
};


char ** parser_pipes (const char *orden, int *numordenes); /* declaracion de la funcion parser_pipes */

char ** parser_orden (const char *orden, int *indentrada, int *indsalida, int *background); /* declaracion de la funcion parser_orden */


#endif 
