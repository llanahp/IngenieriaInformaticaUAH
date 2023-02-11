#include <iostream>
#include <string>
#include <sstream>


#include "Lista.h"
#include "Cliente.h"
#include "NodoLista.h"


Lista::Lista(){
    this->primero=NULL;
    this->ultimo=NULL;
    this->longitud=0;
}

Lista::~Lista(){
}

void Lista::insertarIzquierda(Cliente clien){
    NodoLista *nodo = new NodoLista(clien);
    if(this->esvacia()){
        this->primero=nodo;
        this->ultimo=nodo;
    }
    else{
        nodo->siguiente=this->primero;
        nodo->anterior=NULL;
        this->primero->anterior=nodo;
        this->primero=nodo;
    }
    this->longitud++;
}

void Lista::insertarDerecha(Cliente clien){
    NodoLista *nodo = new NodoLista(clien);
    if(this->esvacia()){
        this->primero=nodo;
        this->ultimo=nodo;
    }
    else{
        nodo->anterior=this->ultimo;
        nodo->siguiente=NULL;
        this->ultimo->siguiente=nodo;
        this->ultimo=nodo;
    }
    this->longitud++;
}

int Lista::get_longitud(){
    return this->longitud;
}

void Lista::insertar(Cliente clien){
    if(!clien.contiene_entrada()){
        clien.generar_Entrada();
    }
    if(this->esvacia()){
        this->insertarIzquierda(clien);
    }
    else{
        if(clien.isRegistrado()){//Clientres Registrados
            NodoLista *aux=this->primero;

            while(aux->siguiente!= NULL && aux->cliente.isRegistrado()==true && clien.getMinuto()>aux->cliente.getMinuto()){
                aux=aux->siguiente;
            }


            if(aux->siguiente == NULL && clien.getMinuto()>aux->cliente.getMinuto()){
                this->insertarDerecha(clien);
            }
            else{

                 if(aux->anterior==NULL && clien.getMinuto() <= aux->cliente.getMinuto()){
                    this->insertarIzquierda(clien);
                }
                else{
                    NodoLista *nodo = new NodoLista(clien);

                    nodo->anterior=aux->anterior;
                    nodo->siguiente=aux;

                    if(aux->anterior != NULL){
                        aux->anterior->siguiente=nodo;
                    }else{
                        this->primero=nodo;
                    }
                    aux->anterior=nodo;
                    this->longitud++;
                }
            }
        }
        else{//Clientes NO registrados
            NodoLista *aux=this->primero;

            while (aux->siguiente!= NULL && aux->cliente.isRegistrado()==true){//paso los que estan registrados
                aux=aux->siguiente;
            }
            while(aux->siguiente!= NULL && clien.getMinuto()>aux->cliente.getMinuto()){
                aux=aux->siguiente;
            }
            if(aux->siguiente == NULL && aux->cliente.isRegistrado()){
                this->insertarDerecha(clien);
            }
            else{

                if(aux->siguiente == NULL && clien.getMinuto()>aux->cliente.getMinuto()){
                    this->insertarDerecha(clien);
                }
                else{

                     if(aux->anterior==NULL && clien.getMinuto() <= aux->cliente.getMinuto()){
                        this->insertarIzquierda(clien);
                    }
                    else{
                        NodoLista *nodo = new NodoLista(clien);

                        nodo->anterior=aux->anterior;
                        nodo->siguiente=aux;

                        if(aux->anterior != NULL){
                            aux->anterior->siguiente=nodo;
                        }else{
                            this->primero=nodo;
                        }
                        aux->anterior=nodo;
                        this->longitud++;
                    }
                }
            }

        }

    }

}

Cliente Lista::inicial(){
    return this->primero->cliente;
}

Cliente Lista::fin(){
    return this->ultimo->cliente;
}

void Lista::eliminar_inicial(){
    if(!this->esvacia()){
        this->primero = this->primero->siguiente;
        if(this->primero==NULL){
            this->ultimo=NULL;
        }
        else{
            this->primero->anterior=NULL;
        }
        this->longitud=longitud-1;
    }
}

void Lista::eliminar_fin(){
    if(!this->esvacia()){
        this->ultimo=this->ultimo->anterior;
        if(this->ultimo==NULL){
            this->primero=NULL;
        }
        else{
            this->ultimo->siguiente=NULL;
        }
        this->longitud--;
    }
}

bool Lista::esvacia(){
    return this->longitud==0?true:false;
}

void Lista::mostrar(){
    if(this->primero){
       NodoLista *aux=this->primero;

       while(aux->siguiente){
            aux->cliente.mostrarDatos();
            aux=aux->siguiente;
        }
            aux->cliente.mostrarDatos();
    }
    else{
        cout<<"Lista vacia"<<endl;
    }

}

Cliente Lista::get_PrimeroNoRegistrado(){
    NodoLista *aux=this->primero;

    while(aux->siguiente && aux->cliente.isRegistrado()){
        aux=aux->siguiente;
    }
    return aux->cliente;
}

void Lista::info_PrimeroRegistrado(){
    if(!this->esvacia()){
        Cliente cliente = this->inicial();
        if(cliente.isRegistrado())
            cliente.mostrarDatos();
        else
            cout << "La lista no contiene ningún cliente registrado"<<endl;
    }
    else{
        cout <<"Lista vacia, no puedo mostrar informacion del primer cliente"<<endl;
    }
}

void Lista::info_PrimeroNoRegistrado(){
    if(!this->esvacia()){
        Cliente cliente = this->get_PrimeroNoRegistrado();
        if(!cliente.isRegistrado())
            cliente.mostrarDatos();
        else
            cout<<"Error"<<endl;
    }
    else{
        cout <<"Lista vacia, no puedo mostrar informacion del primer cliente"<<endl;
    }
}

void Lista::borrar_Lista(){

    while(!this->esvacia()){
        this->eliminar_inicial();
    }
    cout<<"Se ha borrado el contenido de la lista"<<endl;
}

void Lista::borrar_cliente(string id){
    if(this->primero){
    NodoLista *aux=this->primero;
    bool cliente_borrado=false;
    while(aux->siguiente&& !cliente_borrado){
            if(aux->cliente.getId()==id){


                if(aux->anterior==NULL && aux->siguiente==NULL){
                    this->primero=NULL;
                    this->ultimo=NULL;
                }else

                if(aux->anterior==NULL){
                    this->primero=aux->siguiente;
                    this->primero->anterior=NULL;
                }else

                if(aux->siguiente==NULL){
                    this->ultimo=aux->anterior;
                    this->ultimo->siguiente=NULL;
                }
                else{
                    aux->siguiente->anterior=aux->anterior;
                    aux->anterior->siguiente=aux->siguiente;
                    }

                this->longitud=longitud-1;
                cliente_borrado=true;

            }
            else{
                aux=aux->siguiente;
            }
        }

        if(cliente_borrado){
            cout<<"Se ha borrado el cliente con el id introducido"<<endl;
        }
        else{
            cout<<"No se ha encontrado un cliente con ese id"<<endl;
        }
    }
    else{
        cout<<"No existe dicho cliente"<<endl;
    }
}

void Lista::mostrar_info_concierto(string id_concierto){

    if(this->primero){
        NodoLista *aux=this->primero;

       while(aux->siguiente){
                if(aux->cliente.getIdConcierto()==id_concierto){
                    aux->cliente.mostrarDatos();
                  }
                aux=aux->siguiente;

            }
            if(aux->cliente.getIdConcierto()==id_concierto){
              aux->cliente.mostrarDatos();
            }
    }
    else{
        cout<<"No hay datos"<<endl;
    }

}

void Lista::info_concierto(string id_concierto){
    if(id_concierto=="ESTOPA" ||id_concierto=="MALU" ||id_concierto=="MELENDI"){
                mostrar_info_concierto(id_concierto);
    }
    else{
        cout <<"No se ha introducido un concierto correcto"<<endl;
    }
}
