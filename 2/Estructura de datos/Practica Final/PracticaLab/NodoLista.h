#ifndef NODOLISTA_H
#define NODOLISTA_H

#include <iostream>
#include "Cliente.h"
class NodoLista{
    public:
        NodoLista(Cliente clien, NodoLista *sig=NULL, NodoLista *ant=NULL);
        virtual ~NodoLista();
        friend class Lista;

    private:
         Cliente cliente;
         NodoLista* siguiente;
         NodoLista* anterior;
};

#endif // NODOLISTA_H
