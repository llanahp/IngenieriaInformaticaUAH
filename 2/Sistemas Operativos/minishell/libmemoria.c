/*
*****************************************************************************************************************************														    
* Autores: Elena Martin Naranjo, Raul López Llana, Soledad Hernández Romero, Luis Ángel Barderas 						                *
*****************************************************************************************************************************
*/

#include <stdlib.h>
#include "libmemoria.h"

//libera el array args
void free_argumentos(char **args)
{
   int i = 0;

   while(args[i])
      free(args[i++]);
   free(args);
}

//Libera los arrays ordenes y pipes para el número de ordenes existentes
void free_ordenes_pipes(char **ordenes, int **fds, int nordenes)
{
   int i = 0;

   for (i = 0; i < nordenes; i++)
   {
      free(ordenes[i]);
      if (i < (nordenes - 1))
         free(fds[i]);
   }

   free(ordenes);
   free(fds);
}
