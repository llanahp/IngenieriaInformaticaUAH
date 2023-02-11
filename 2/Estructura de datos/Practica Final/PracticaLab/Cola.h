#ifndef COLA_H
#define COLA_H

#include "NodoCola.h"

#include <iostream>

class Cola{
    private:
        NodoCola *primero;
        NodoCola *ultimo;
        int longitud;

    public:
        Cola();
        void encolar(Cliente);
        Cliente desencolar();
        Cliente inicio();
        Cliente fin();
        bool es_vacia();
        int get_longitud();
        void mostrarCola();
        void mostrarDatosCola();
        virtual ~Cola();
        void invertir();
        void borrar();


};

#endif // COLA_H
