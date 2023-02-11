#ifndef COLA_H
#define COLA_H
#include "nodoCola.h"
#include <iostream>

class Cola
{
    private:
        nodoCola *primero;
        nodoCola *ultimo;
        int longitud;

    public:
        Cola();
        void encolar(char);
        char desencolar();
        char inicio();
        char fin();
        bool es_vacia();
        int get_longitud();
        void mostrar_cola();//No es correcto su implementacion (trampas)
        virtual ~Cola();
        void invertir();


        bool iguales( Cola);

        bool es_simetrica(Cola);
        void Concatenar_dos_colas(Cola);
        Cola Mezclar(Cola);
        void Quitar_primera_mitad();
        bool ordenado();
};

#endif // COLA_H
