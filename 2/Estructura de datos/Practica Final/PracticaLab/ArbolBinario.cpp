#include <iostream>
#include <string>

#include "ArbolBinario.h"
#include "NodoArbol.cpp"
#include "Cliente.h"
#include "NodoArbol.h"

using namespace std;

ArbolBinario::ArbolBinario()
{
    this->raiz= new  NodoArbol("$$$$$$$$$");

}

ArbolBinario::~ArbolBinario(){}

void ArbolBinario::insertarCliente(Cliente cliente, pnodoArbol nodo){
    string codigoCliente = cliente.getId();
    if(nodo->hijo_izquierdo==NULL && nodo->hijo_derecho==NULL){ //Si el nodo en el que queremos insertar no tiene hijos
        if(nodo->idCliente == "$$$$$$$$$"){ //En caso de estar en la raiz
            if(cliente.isRegistrado()){ //Si esta registrado se va a la izquierda
                nodo->hijo_izquierdo = new NodoArbol(cliente.getId(), cliente.getEntrada());
            }else{ //Si no a la derecha
                nodo->hijo_derecho = new NodoArbol(cliente.getId(),cliente.getEntrada());
            }
        }else{ //Si no estamos en la raiz
            if(codigoCliente < nodo->idCliente){ //Si el codigo del cliente que queremos insertar es "menor" se va a la izquierda
                nodo->hijo_izquierdo = new NodoArbol(cliente.getId(),cliente.getEntrada());
            }else if(codigoCliente > nodo->idCliente){ //Si es codigo de cliente es "mayor" se va a la derecha
                nodo->hijo_derecho = new NodoArbol(cliente.getId(),cliente.getEntrada());
            }else{ //Si ya esta en el arbol, se añade la entrada a su lista
                nodo->listaEntradas.insertarEntrada(cliente.getEntrada());
            }
        }
    }else{ //En caso de tener hijos
        if(nodo->idCliente == "$$$$$$$$$"){ //Si estamos en la raiz
            if(cliente.isRegistrado()){ //Y el cliente es registrado, se almacena en la izquierda
                    if(nodo->hijo_izquierdo==NULL)  //si no tenemos ningun cliente registrado almacenado
                        nodo->hijo_izquierdo = new NodoArbol(cliente.getId(),cliente.getEntrada());
                    else
                        insertarCliente(cliente,nodo->hijo_izquierdo); //Insertamos en la izquierda del siguiente
            }else{ //Si no,lo inserto por la derecha
                 if(nodo->hijo_derecho==NULL)//Si aun no habia insertado ningun cliente por la derecha
                        nodo->hijo_derecho = new NodoArbol(cliente.getId(),cliente.getEntrada());
                    else
                        insertarCliente(cliente,nodo->hijo_derecho);
            }
        }else{ //Si no estamos en la raiz
            if(codigoCliente < nodo->idCliente){//Si el cliente a insertar tiene un codigo menor que el del nodo en el que estamos, inserto por la izquierda
                if(nodo->hijo_izquierdo==NULL)//Si no tiene insertado ningun cliente por la izquierda
                        nodo->hijo_izquierdo = new NodoArbol(cliente.getId(),cliente.getEntrada());
                    else
                        insertarCliente(cliente,nodo->hijo_izquierdo);
            }else if(codigoCliente>nodo->idCliente){//Codigo de cliente mayor que el que estamos, inserto por la derecha
               if(nodo->hijo_derecho==NULL)//Si no tiene insertado ningun cliente por la derecha
                        nodo->hijo_derecho = new NodoArbol(cliente.getId(),cliente.getEntrada());
                    else
                        insertarCliente(cliente,nodo->hijo_derecho);
            }else{//Si el cliente por casualidad entra y ya estaba insertado
                 nodo->listaEntradas.insertarEntrada(cliente.getEntrada());
            }
        }
    }

}

void ArbolBinario::insertarCliente(Cliente cliente){
    this->insertarCliente(cliente,this->raiz);
}

void ArbolBinario::insertarClientes(Lista lista){
    if(this->raiz && !lista.esvacia()){ //Bucle mientras la lista siga teniendo clientes
        while(!lista.esvacia()){
            this->insertarCliente(lista.inicial(),this->raiz); //Inserto el primer cliente de la lista
            lista.eliminar_inicial();
        }
        cout << "Se han insertado todos los clientes de la lista al arbol" << endl;
    }
}

void ArbolBinario::mostrarInordenRegistrados(){
    if(!esVacio())
        if(this->raiz->hijo_izquierdo!=NULL)
            mostrarInordenRegistrados(this->raiz->hijo_izquierdo);
        else
            cout << "El arbol no contiene clientes registrados"<<endl;
    else
        cout << "Arbol vacio"<<endl;
}

void ArbolBinario::mostrarInordenRegistrados(pnodoArbol nodo){
    if(nodo == NULL){
            cout << "";
    }else{

        if(!nodo->idCliente.find("CODREG")){ // si es registrado entra
            mostrarInordenRegistrados(nodo->hijo_izquierdo);
            if(nodo->idCliente!="$$$$$$$$$")
                nodo->mostrarDatos();
            mostrarInordenRegistrados(nodo->hijo_derecho);
        }
    }
}

void ArbolBinario::mostrarInordenNoRegistrados(){
   if(!esVacio())
        if(this->raiz->hijo_derecho!=NULL)
            mostrarInordenNoRegistrados(this->raiz->hijo_derecho);
        else
            cout <<"El arbol no contiene clientes no registrados"<< endl;
    else
        cout << "Arbol vacio"<<endl;
}

void ArbolBinario::mostrarInordenNoRegistrados(pnodoArbol nodo){
    if(nodo == NULL)
        cout << "";
    else
    {
        if(nodo->idCliente.find("CODREG")){
            mostrarInordenNoRegistrados(nodo->hijo_izquierdo);
            nodo->mostrarDatos();
            mostrarInordenNoRegistrados(nodo->hijo_derecho);
        }
    }
}

void ArbolBinario::mostrarPreorden(){
    if(!esVacio())
        mostrarPreorden(this->raiz);
    else
        cout << "Arbol vacio"<<endl;
}

void ArbolBinario::mostrarPreorden(pnodoArbol nodo){
    if(nodo==NULL)
        cout << "";
    else{
        if(nodo->idCliente!="$$$$$$$$$")
            nodo->mostrarDatos();
        mostrarPreorden(nodo->hijo_izquierdo);
        mostrarPreorden(nodo->hijo_derecho);
    }
}

void ArbolBinario::mostrarInfoEntradas(string idConcierto){
    cout <<endl;
    int palco=0,gallinero=0,patio=0;
    //Miro cuantas entradas se han comprado de cada tipo del concierto dado tanto clientes registrados como no
    palco = mostrarInfoEntradas(idConcierto,"PALCO",this->raiz->hijo_izquierdo) + mostrarInfoEntradas(idConcierto,"PALCO",this->raiz->hijo_derecho);
    patio = mostrarInfoEntradas(idConcierto,"PATIO",this->raiz->hijo_izquierdo) + mostrarInfoEntradas(idConcierto,"PATIO",this->raiz->hijo_derecho);
    gallinero = mostrarInfoEntradas(idConcierto,"GALLINERO",this->raiz->hijo_izquierdo) + mostrarInfoEntradas(idConcierto,"GALLINERO",this->raiz->hijo_derecho);
    //preparo para mostrar los resultados por pantalla
    cout << idConcierto<<endl;
    char caracter= 192;
    cout <<"   "<<caracter<<"Palco: "<<palco<<endl;
    cout <<"   "<<caracter<<"Patio: "<<patio<<endl;
    cout <<"   "<<caracter<<"Gallinero: "<<gallinero<<endl;
    cout <<"---------------------------------------"<<endl;
    cout <<"    \tTotal: "<<(patio+palco+gallinero)<<endl;
}

int ArbolBinario::mostrarInfoEntradas(string idConcierto,string tipo, pnodoArbol nodo){
    if(nodo!=NULL){
            if(nodo->listaEntradas.contiene(idConcierto, tipo)){//Si el nodo tiene entradas compradas de ese tipo
               return nodo->listaEntradas.contarEntradas(idConcierto, tipo) + mostrarInfoEntradas(idConcierto,tipo,nodo->hijo_izquierdo) +  mostrarInfoEntradas(idConcierto,tipo,nodo->hijo_derecho);
            }else{
                return  mostrarInfoEntradas(idConcierto,tipo,nodo->hijo_izquierdo) +  mostrarInfoEntradas(idConcierto,tipo,nodo->hijo_derecho);
            }
    }
    return 0;
}

void ArbolBinario::borrarCliente(string id){
    if(id.length()==9){
        borrarCliente(id,this->raiz,NULL);
    }else{
        cout <<"No existe un usuario con ese ID" << endl;
    }
}

//Utilizaré unicamente el puntero "padre" cuando encuentre el nodo que tengo que borrar
void ArbolBinario::borrarCliente(string id, pnodoArbol nodo, pnodoArbol padre){
     if(nodo->idCliente == "$$$$$$$$$"){//Si estoy en el nodo raiz
        if(!id.find("CODREG")){//Si cliente a borrar es registrado
            if(nodo->hijo_izquierdo!=NULL)//miro si no es vacio el arbol que contiene a los clietes registrados
                borrarCliente(id,nodo->hijo_izquierdo,nodo);
            else
                cout <<"No existe un usuario con ese ID" << endl;
        }else{//En caso de estar buscando un cliente no registrado
            if(nodo->hijo_derecho!=NULL)
                borrarCliente(id,nodo->hijo_derecho,nodo);
            else
                cout <<"No existe un usuario con ese ID" << endl;
        }
     }else{//Estamos en un nodo que no es la raiz
        if(nodo->idCliente==id){//He encontrado el cliente que tengo que borrar
            if(nodo->hijo_derecho==NULL && nodo->hijo_izquierdo==NULL){//Miro si no tiene ningún hijo
                //Miro cual es el nodo que tengo que borrar desde el padre y lo borro
                if(padre->hijo_derecho==nodo){
                    cout<<"Se ha eliminado correctamente al usuario"<<endl;
                    padre->hijo_derecho=NULL;
                }
                else{
                    cout<<"Se ha eliminado correctamente al usuario"<<endl;
                    padre->hijo_izquierdo=NULL;
                }

            }else {//El cliente a borrar contiene algún hijo
                if(nodo->hijo_izquierdo==NULL){//Solo tiene Hijo Derecho
                    //Miro cual es el nodo que tengo que borrar desde el padre y lo borro
                    if(padre->hijo_derecho==nodo){
                        cout<<"Se ha eliminado correctamente al usuario"<<endl;
                        padre->hijo_derecho=nodo->hijo_derecho;
                    }
                    else{
                        cout<<"Se ha eliminado correctamente al usuario"<<endl;
                        padre->hijo_izquierdo=nodo->hijo_derecho;
                    }

               }else if(nodo->hijo_derecho==NULL){//Solo tiene Hijo Izquierdo
                     //Miro cual es el nodo que tengo que borrar desde el padre y lo borro
                    if(padre->hijo_derecho==nodo){
                        cout<<"Se ha eliminado correctamente al usuario"<<endl;
                        padre->hijo_derecho=nodo->hijo_izquierdo;
                    }
                    else{
                        cout<<"Se ha eliminado correctamente al usuario"<<endl;
                        padre->hijo_izquierdo=nodo->hijo_izquierdo;
                    }

               }else{//Tiene los 2 hijos
                    //Busco el cliente mayor id de la rama izquierda del que quiero borrar
                    string clienteMaximo = maximoCliente(nodo->hijo_izquierdo);
                    //borro el cliente que acabo de buscar del arobl
                    borrarCliente(clienteMaximo, nodo->hijo_izquierdo,nodo);
                    //sustituyo por el que primeramente queria borrar
                    nodo->idCliente = clienteMaximo;
               }
            }
        }else{//No he encontrado el cliente buscado, tengo que seguir buscando el cliente en los hijos
             if(nodo->idCliente<= id){//El numero del cliente es menor y he de buscar por la izquierda
                if(nodo->hijo_derecho!=NULL)
                    borrarCliente(id,nodo->hijo_derecho,nodo);
                else
                    cout <<"No existe un usuario con ese ID" << endl;
            }else{//El numero del cliente es mayor y he de buscar por la derecha
                 if(nodo->hijo_izquierdo!=NULL)
                    borrarCliente(id,nodo->hijo_izquierdo,nodo);
                else
                    cout <<"No existe un usuario con ese ID" << endl;
            }
        }
     }
}

bool ArbolBinario::esVacio(){
    if(this->raiz->idCliente=="$$$$$$$$$" &&(this->raiz->hijo_derecho==NULL && this->raiz->hijo_izquierdo==NULL))
        return true;
    else
        return false;
}

//Encontrar el cliente mayor de un arbol
string ArbolBinario::maximoCliente(pnodoArbol nodo){
    string  maximo = nodo->idCliente;
    //Si existe un hijo derecho, entonces ese será mayor que el actual
    if(nodo->hijo_derecho!=NULL){
        maximo = maximoCliente(nodo->hijo_derecho);
    }
    return maximo;
}

void ArbolBinario::infoCliente(string id){
    cout<<endl;
    if(!id.find("CODREG")){
        if(this->raiz->hijo_izquierdo==NULL)
            cout << "No existe ese cliente" <<endl;
        else
            infoCliente(id, this->raiz->hijo_izquierdo);
   }else{
        if(this->raiz->hijo_derecho==NULL)
            cout << "No existe ese cliente"<<endl;
        else
            infoCliente(id, this->raiz->hijo_derecho);
   }
}

void ArbolBinario::infoCliente(string id, pnodoArbol nodo){
   if(nodo->idCliente==id){
        nodo->mostrarDatos();
   }else{

      if(nodo->idCliente<= id){
                if(nodo->hijo_derecho!=NULL)
                    infoCliente(id,nodo->hijo_derecho);
                else
                    cout <<"No existe un usuario con ese ID" << endl;
            }else{
                 if(nodo->hijo_izquierdo!=NULL)
                    infoCliente(id,nodo->hijo_izquierdo);
                else
                    cout <<"No existe un usuario con ese ID" << endl;
            }
   }
}

void ArbolBinario::borrar(){
    this->raiz->hijo_derecho=NULL;
    this->raiz->hijo_izquierdo=NULL;
    cout <<"Se ha borrado el contenido de arbol"<< endl;
}
