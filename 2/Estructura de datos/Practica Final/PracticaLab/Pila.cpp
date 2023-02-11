#include <iostream>

#include "Pila.h"
#include "NodoPila.h"
#include "NodoPila.cpp"


using namespace std;

Pila::Pila(){
    //Constructor
    this->cima=NULL;
}

Pila::~Pila(){
    //Destructor
    while(this->cima){
        desapilar();
    }
}

bool Pila::esVacia(){
    //Comprueba si la pila esta vacia
    return this->cima==NULL;
}

void Pila::apilarAux(Cliente cliente){
    //Apila un cliente en la pila
    pnodo n=new NodoPila(cliente, this->cima); //Un nuevo nodo almacenara al cliente y su elemento anterior sera la cima actual
    this->cima=n; //Ahora la cima es el nuevo nodo
}

void Pila::desapilar(){
    //Desapila un cliente de la pila
    pnodo nodo;
    if(this->cima){
        nodo=this->cima;
        this->cima=nodo->siguiente;
        //delete nodo;
        //Si hay elemento por debajo, la cima pasa a ser el elemento de debajo
    }
}

void Pila::mostrar(){
    //Muestra la cima de la pila en caso de que no este vacia
    if(this->esVacia()){
        cout<<"\nPila vacia"<<endl;
    }
    else{
        cout<<"\nCima de la pila: "<<this->cima->cliente.getId()<<endl;
    }
}

void Pila::verEntera(){
    Pila aux;
    aux.cima=this->cima;
    if(aux.cima){
        while(aux.cima){
            aux.cima->cliente.mostrarDatos();
            aux.desapilar();
        }
    }else{
        cout << "Pila vacia"<<endl;
    }
}

int Pila::contar(){
    //Cuenta cuantos clientes hay en una pila
    Pila aux;
    aux.cima=this->cima;
    int clientes=0;

    while(aux.cima){
        clientes++;
        aux.desapilar();
    }

    return clientes;
}

Cliente Pila::fondo(){
    //Devuelve el cliente del fondo
    Pila aux;
    aux.cima=this->cima;

    while(aux.contar()>1){
        aux.desapilar();
    }

    return aux.cima->cliente;
}

Cliente Pila::primero(){
    return this->cima->cliente;
}

void Pila::invertir(){
    //Invierte la pila de clientes
    Pila aux;
    while(!this->esVacia()){
        aux.apilarAux(this->cima->cliente);
        this->desapilar();
    }

    this->cima=aux.cima;
}

void Pila::montar(Pila pila){
    //Pone una pila de clientes encima de otra
    Pila aux=pila;
    aux.invertir();

    while(!aux.esVacia()){
        this->apilarAux(aux.cima->cliente);
        aux.desapilar();
    }
}

void Pila::quitar(int n){
    //Elimina los n primeros clientes de la pila
    for(int i=0; i<n; i++){
        if(!this->esVacia()){
            this->desapilar();
        }
    }
}

void Pila::borrar_Clientes(){
    while(!this->esVacia()){
        this->desapilar();
    }
    cout<<"Se ha borrado el contenido de la pila"<<endl;
}

void Pila::eliminarFondo(){
    this->invertir();
    this->desapilar();
    this->invertir();
}

void Pila::apilar(Cliente c){
    if(c.isRegistrado()){
        this->apilarAux(c);
    }
    else{
        Pila reg;
        while(this->cima && this->cima->cliente.isRegistrado()){
            reg.apilarAux(this->cima->cliente);
            this->desapilar();
        }

        this->apilarAux(c);
        while(reg.cima){
            this->apilarAux(reg.cima->cliente);
            reg.desapilar();
        }
    }
}
