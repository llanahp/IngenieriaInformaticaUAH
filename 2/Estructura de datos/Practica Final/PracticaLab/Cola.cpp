#include <iostream>
#include <string>
#include <sstream>


#include "Cola.h"
#include "NodoCola.h"
#include "Cliente.h"
#include "Cliente.cpp"

using namespace std;

Cola::Cola(){
    //Constructor
    primero=NULL;
    ultimo=NULL;
    longitud=0;
}

Cola::~Cola(){
}

void Cola::encolar(Cliente cliente){
    //Encola un lciente en la cola
    NodoCola *nodo=new NodoCola(cliente);
    if(es_vacia()){
        this->primero=nodo;
        this->ultimo=nodo;
    }
    else{
        this->ultimo->siguiente=nodo;
        this->ultimo=nodo;
    }
    longitud++;
}

Cliente Cola::desencolar(){
    //Desencola un cliente de la cola
    Cliente  cliente;
    if(!this->es_vacia()){
        cliente=primero->cliente;
        NodoCola *aux=this->primero;
        if(this->primero==this->ultimo){
            this->primero=NULL;
            this->ultimo=NULL;
            aux->siguiente=NULL;
            delete(aux);
        }
        else{
            this->primero=this->primero->siguiente;
            aux->siguiente=NULL;
            delete(aux);
        }
        longitud--;
    }
    return cliente;
}

bool Cola::es_vacia(){
    return this->longitud!=0?false:true;
}

Cliente Cola::inicio(){
    return this->primero->cliente;
}

Cliente Cola::fin(){
    return this->ultimo->cliente;
}

int Cola::get_longitud(){
    return this->longitud;
}

void Cola::borrar(){
    while(!this->es_vacia()){
        this->desencolar();
    }
    cout<<"Se ha borrado el contenido de la cola"<<endl;
}

void Cola::mostrarCola(){
    if(this->primero){
        this->mostrarDatosCola();
        this->invertir();
    }else
        cout<<"La cola esta vacia"<<endl;
}

void Cola::mostrarDatosCola(){
    NodoCola *actual=this->primero;

   if(actual){ //Miro si la cola no esta vacia
        Cliente a=actual->cliente; //Me guardo el primer cliente
        actual->cliente.mostrarDatos(); //Muestro sus datos
        desencolar(); //Lo elimino
        mostrarDatosCola(); //Llamo al mismo metodo para que muestre el resto de los clientes
        encolar(a); //Vuelvo insertar los clientes para dejar la cola intacta
    }
}

void Cola::invertir(){
    if(!this->es_vacia()){
        Cliente c=this->inicio();
        this->desencolar();
        this->invertir();
        this->encolar(c);
    }
}
