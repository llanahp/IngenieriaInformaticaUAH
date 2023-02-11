#include <iostream>
#include "NodoPila.h"

using namespace std;

NodoPila::NodoPila(){
    this->cliente=Cliente();
    siguiente=NULL;
}

NodoPila::NodoPila(Cliente cliente, NodoPila *s){
    this->cliente=cliente;
    siguiente=s;
}

NodoPila::~NodoPila(){
}
