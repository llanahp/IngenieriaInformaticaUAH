#ifndef LISTAENTRADA_H_INCLUDED
#define LISTAENTRADA_H_INCLUDED

#include "NodoListaEntrada.h"

class ListaEntrada{
    public:
        ListaEntrada();
        ~ListaEntrada();
        int getLongitud();
        void insertarEntrada(Entrada entrada);
        Entrada getPrimero();
        Entrada getUltimo();
        void mostrar();
        void eliminarEntrada(Entrada entrada);
        bool contiene(string idConcierto, string tipo);
        int contarEntradas(string idConcierto, string tipo);
    private:
        NodoListaEntrada *primero;
        NodoListaEntrada *ultimo;
        int longitud;
};


#endif // LISTAENTRADA_H_INCLUDED
