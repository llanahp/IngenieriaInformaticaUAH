#include "nodoCola.h"
#include <iostream>

nodoCola::nodoCola()
{
    valor = '0';
    siguiente=NULL;
}

nodoCola::nodoCola(char v, nodoCola* sig)
{
    valor = v;
    siguiente = sig;
}


nodoCola::~nodoCola()
{
    //dtor
}
