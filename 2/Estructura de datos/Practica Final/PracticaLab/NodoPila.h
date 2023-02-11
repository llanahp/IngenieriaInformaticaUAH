#ifndef NODOPILA_H_INCLUDED
#define NODOPILA_H_INCLUDED

#include "Cliente.h"

class NodoPila{
    private:
        //Atributos
        Cliente cliente;
        NodoPila *siguiente;  //Puntero al elemento que esta "debajo"

        friend class Pila;

    public:
        //Constructores
        NodoPila();
        NodoPila(Cliente cliente, NodoPila *s=NULL);

        //Destructor
        ~NodoPila();
};

typedef NodoPila *pnodo;

#endif // NODOPILA_H_INCLUDED
