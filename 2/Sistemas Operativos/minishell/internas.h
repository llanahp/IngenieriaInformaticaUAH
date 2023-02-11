/*
*****************************************************************************************************************************														    
* Autores: Elena Martin Naranjo, Raul López Llana, Soledad Hernández Romero, Luis Ángel Barderas 						                *
*****************************************************************************************************************************
*/

#ifndef INTERNAS_H
#define INTERNAS_H

struct tipo_interna
{
  char *nombre;
  void (*func)(const char *);
};


int es_ord_interna(const char *); /* declaracion de la funcion es_ord_interna */

void ejecutar_ord_interna(const char *); /* declaracion de la funcion ejecutar_ord_interna */

#endif
