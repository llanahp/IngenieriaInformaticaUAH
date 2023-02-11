#ifndef PILA_H
#define PILA_H
#include "NodoPila.h"

class Pila
{
    private:
        pnodo cima;
    public:
        Pila();
        ~Pila();
        bool esVacia();
        void apilar(int v);
        void desapilar();
        void mostrar();
        int getCima();

        int contar();
        void fondo();
        void montar(Pila pila_b);
};

#endif // PILA_H
