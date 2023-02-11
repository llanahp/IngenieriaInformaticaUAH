#include<iostream>
#include "NodoLista.h"

NodoLista::NodoLista(Cliente clien,NodoLista* sig,NodoLista* ant)
{
    this->cliente=clien;
    this->siguiente=sig;
    this->anterior=ant;
}

NodoLista::~NodoLista(){
}
