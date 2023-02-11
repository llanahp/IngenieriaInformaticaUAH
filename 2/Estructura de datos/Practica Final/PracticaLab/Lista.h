#ifndef LISTA_H
#define LISTA_H

#include "NodoLista.h"
#include "Cliente.h"

#include <iostream>

class Lista{
    public:
        Lista();

        virtual ~Lista();
        bool esvacia();
        int get_longitud();
        void insertar(Cliente clien);
        Cliente inicial();
        Cliente fin();

        Cliente get_PrimeroNoRegistrado();

        void eliminar_inicial();
        void eliminar_fin();

        void mostrar();
        void borrar_Lista();
        void info_PrimeroRegistrado();
        void info_PrimeroNoRegistrado();
        void borrar_cliente(string id);
        void info_concierto(string id_concierto);
        void mostrar_info_concierto(string id_concierto);

    private:
        NodoLista* primero;
        NodoLista* ultimo;
        int longitud;

        void insertarIzquierda(Cliente clien);
        void insertarDerecha(Cliente clien);

};

#endif // LISTA_H
