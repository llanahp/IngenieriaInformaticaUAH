#include <iostream>
#include "NodoListaEntrada.h"

NodoListaEntrada::NodoListaEntrada(Entrada entrada){
    this->entrada=entrada;
    this->siguente=NULL;
}

NodoListaEntrada::~NodoListaEntrada(){
}
