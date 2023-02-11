#ifndef NODOCOLA_H
#define NODOCOLA_H
#include <iostream>

class nodoCola
{

    private:
        char valor;
        nodoCola* siguiente;
        friend class Cola;
    public:
        nodoCola();
        nodoCola(char valor, nodoCola *siguiente = NULL);
        virtual ~nodoCola();


};

#endif // NODOCOLA_H
