#ifndef PILA_H_INCLUDED
#define PILA_H_INCLUDED

#include "NodoPila.h"

class Pila{
    private:
        //Atributos
        pnodo cima;

    public:
        //Constructor y destructor
        Pila();
        ~Pila();

        //Métodos
        bool esVacia();
        void apilarAux(Cliente cliente);
        void desapilar();
        void mostrar();
        void verEntera();
        int contar();
        Cliente fondo();
        Cliente primero();
        void invertir();
        void montar(Pila pila);
        void quitar(int n);
        void eliminarFondo();
        void apilar(Cliente c);
        void borrar_Clientes();

};

#endif // PILA_H_INCLUDED
