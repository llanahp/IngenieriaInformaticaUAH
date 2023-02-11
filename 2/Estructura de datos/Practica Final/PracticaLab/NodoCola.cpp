#include<iostream>

#include "NodoCola.h"

NodoCola::NodoCola(){
    this->siguiente=NULL;
    this->cliente = Cliente();

}

NodoCola::NodoCola(Cliente cliente, NodoCola* sig){
    this->cliente = cliente;
    this->siguiente = sig;
}


NodoCola::~NodoCola(){

}
