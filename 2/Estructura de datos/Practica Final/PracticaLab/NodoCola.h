#ifndef NODOCOLA_H
#define NODOCOLA_H
#include <iostream>
#include "Cliente.h"
class NodoCola{
    private:
        Cliente cliente;
        NodoCola* siguiente;
        friend class Cola;

    public:
        NodoCola();
        NodoCola(Cliente cliente, NodoCola *sig = NULL);
        ~NodoCola();
};

#endif // NODOCOLA_H
