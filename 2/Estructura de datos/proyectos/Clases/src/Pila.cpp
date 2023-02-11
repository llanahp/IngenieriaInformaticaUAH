#include "Pila.h"
#include "NodoPila.h"

using namespace std;

Pila::Pila()
{
cima =NULL;
}

Pila::~Pila()
{
    while(cima) desapilar();
}

bool Pila::esVacia(){
    return cima==NULL;
}

void Pila::apilar(int v){
    pnodo nuevo = new NodoPila(v,cima);
    cima=nuevo;
}

void Pila::desapilar(){
    pnodo nodo;
    if(cima){
        nodo=cima;
        cima = nodo->siguiente;
        delete nodo;
    }
}

void Pila::mostrar(){
    if(esVacia()){
    cout << "la pila esta vacia"<< endl;
    }else{
        cout <<"Cima pila: "<< cima->valor<<endl;
    }

}
int Pila::getCima(){
    return cima->valor;
}
//-------------
//Metodos propuestos en los ejercicios
int Pila::contar(){
    int contador=0;

    if(!esVacia()){
        contador++;
        pnodo nodo=cima;

        while(nodo->siguiente!=NULL){
            contador++;
            nodo=nodo->siguiente;
        }
    }
    return contador;
}

void Pila::fondo(){


    if(!esVacia()){
    pnodo nodo=cima;
        while(nodo->siguiente!=NULL){
            nodo=nodo->siguiente;
        }
        cout <<"El valor del fondo es: "<< nodo->valor<< endl;
    }else{
        cout <<"La pila es vacia y no tiene fondo"<<endl;
    }

}

//funcion que puede dar error
void Pila::montar(Pila pila2){

        pnodo nodo=pila2.cima;
        while(nodo->siguiente!=NULL){
            apilar(nodo->valor);
            nodo=nodo->siguiente;
        }
        apilar(nodo->valor);
}
