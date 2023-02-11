#ifndef GESTOR_H
#define GESTOR_H

#include "Pila.h"
#include "Cola.h"
#include "Lista.h"
#include "ArbolBinario.h"

class Gestor
{
    public:
        Gestor();
        virtual ~Gestor();
        void programa();
    private:
        Pila pila;
        Cola cola_Registrados;
        Cola cola_No_Registrados;
        Lista lista;
        ArbolBinario arbol;
        int contador=-1;
        string get_nuevoID();
        char menu();
        void crearSegundosClientes(Cola *cola_Regis, Cola *cola_No_Regis);
        void crearPrimerosClientes(Pila *pila);
        void reiniciar();
        int numero_Aleatorio(int DESDE, int HASTA);
};

#endif // GESTOR_H
