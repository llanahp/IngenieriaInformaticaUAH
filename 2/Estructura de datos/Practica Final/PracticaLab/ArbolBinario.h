#ifndef ARBOLBINARIO_H
#define ARBOLBINARIO_H

#include "Lista.h"
#include "NodoArbol.h"


class ArbolBinario
{
    public:
        ArbolBinario();
        virtual ~ArbolBinario();
        void insertarCliente(Cliente cliente);
        void insertarClientes(Lista lista);
        void mostrarInordenRegistrados();
        void mostrarInordenNoRegistrados();
        void mostrarPreorden();
        void mostrarInfoEntradas(string idConcierto);
        void borrarCliente(string id);
        void infoCliente(string id);
        void borrar();
    private:
        void mostrarPreorden(pnodoArbol nodo);
        void infoCliente(string id, pnodoArbol nodo);
        void borrarCliente(string id,pnodoArbol nodo, pnodoArbol padre);
        void insertarCliente(Cliente cliente,pnodoArbol nodo);
        int mostrarInfoEntradas(string idConcierto,string tipo, pnodoArbol nodo);
        pnodoArbol raiz;
        bool esVacio();
        string maximoCliente(pnodoArbol nodo);
        void mostrarInordenRegistrados(pnodoArbol nodo);
        void mostrarInordenNoRegistrados(pnodoArbol nodo);
};

#endif // ARBOLBINARIO_H
