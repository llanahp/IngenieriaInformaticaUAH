#ifndef NODOARBOL_H
#define NODOARBOL_H

#include "Cliente.h"
#include "ListaEntrada.h"
//#include "ListaEntrada.cpp"
class NodoArbol
{
    public:

        NodoArbol(string idCliente="", Entrada entrada=Entrada(), NodoArbol *hijo_izquierdo =NULL, NodoArbol *hijo_derecho =NULL);


        string idCliente;
        NodoArbol *hijo_derecho;
        NodoArbol *hijo_izquierdo;
        ListaEntrada listaEntradas;
        void mostrarDatos();
        friend class ArbolBinario;
    private:

};


typedef NodoArbol *pnodoArbol;
#endif // NODOARBOL_H
