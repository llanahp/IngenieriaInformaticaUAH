#include "Cola.h"
#include <iostream>
#include "NodoCola.h"

using namespace std;

Cola::Cola()
{
    primero=NULL;
    ultimo=NULL;
    longitud=0;
}


Cola::~Cola()
{
    //dtor
}


void Cola::encolar(char elemento){
    nodoCola *nodo = new nodoCola(elemento);
    if(es_vacia()){
        primero=nodo;
        ultimo=nodo;
    }else{
        ultimo->siguiente=nodo;
        ultimo=nodo;
    }
    longitud++;
}

char Cola::desencolar(){
    char  elemento='0';
    if(!es_vacia()){
        elemento = primero->valor;
        nodoCola *aux=primero;
        if(primero==ultimo){
            primero=NULL;
            ultimo=NULL;
            aux->siguiente=NULL;
            delete(aux);
        }else{
            primero=primero->siguiente;
            aux->siguiente=NULL;
            delete(aux);
        }
        longitud--;
    }
    return elemento;

}

bool Cola::es_vacia(){
    return longitud!=0?false:true;
}

char Cola::inicio(){
    if(!es_vacia()){
        return primero->valor;
    }
    else{
    return '0';
    }
}


char Cola::fin(){
    if(!es_vacia()){
        return ultimo->valor;
    }
    else{
    return '0';
    }
}


int Cola::get_longitud(){
    return longitud;
}

void Cola::mostrar_cola(){
    nodoCola *colaAux=primero;
    if(es_vacia()){
        cout<< "Cola vacia" <<endl;
    }
    else{
        while(colaAux){
        cout<<"elemento: "<<colaAux->valor <<endl;
        colaAux= colaAux->siguiente;
        }
    }
}

///-------------------------------------------
void Cola::invertir(){

    if(!es_vacia()){
        char elemento = desencolar();
        if(!es_vacia()){
            invertir();
            }
        encolar(elemento);
    }
}

bool Cola::iguales(Cola colaSegunda){

    Cola aux2=colaSegunda;
    if(get_longitud()!=aux2.get_longitud()){
        return false;
    }else{
    bool resul=true;
        while(!es_vacia() || !aux2.es_vacia()){
            if(desencolar()!=aux2.desencolar()){
            resul=false;
            }
        }
        return resul;
    }
}




bool Cola::ordenado(){
    bool resul=true;
    nodoCola *nodoAux= primero;
        while(nodoAux->siguiente!=NULL){
                if(nodoAux->valor > nodoAux->siguiente->valor){
                    resul= false;
                }
                nodoAux = nodoAux->siguiente;

        }
    return resul;
}

void Cola::Quitar_primera_mitad(){
    int contador=longitud/2;
    for (int i=0;i<contador;i++){
        desencolar();
    }
}

void Cola::Concatenar_dos_colas(Cola cola2){
    int total =cola2.longitud;
    for(int i=0;i<total;i++){
        encolar(cola2.desencolar());
    }
}

Cola Cola::Mezclar(Cola cola2){
    Cola resul,aux;

    while(cola2.longitud!=0){
        resul.encolar(cola2.desencolar());
    }
    while(longitud!=0){
        resul.encolar(desencolar());
    }
    return resul;
}


bool Cola::es_simetrica(Cola cola2){
    bool resul=true;
    Cola copia=cola2;


    while(copia.longitud!=0){
        if(copia.inicio() != copia.fin()) {
            resul=false;
        }
        copia.desencolar();
        if(copia.longitud!=0)
        {copia.invertir();
        copia.desencolar();
        copia.invertir();
        }
    }
    return resul;
}
