#include "ListaEntrada.h"
#include "NodoListaEntrada.h"
#include "NodoListaEntrada.cpp"

ListaEntrada::ListaEntrada(){
    this->primero=NULL;
    this->ultimo=NULL;
    this->longitud=0;
}

ListaEntrada::~ListaEntrada(){
}

int ListaEntrada::getLongitud(){
    return this->longitud;
}

Entrada ListaEntrada::getPrimero(){
    return this->primero->entrada;
}

Entrada ListaEntrada::getUltimo(){
    return this->ultimo->entrada;
}

void ListaEntrada::insertarEntrada(Entrada entrada){
    NodoListaEntrada *nodo=new NodoListaEntrada(entrada);

    if(this->getLongitud()==0){
        this->primero=nodo;
        this->ultimo=nodo;
    }
    else{
        this->ultimo->siguente=nodo;
        this->ultimo=nodo;
    }

    longitud++;
}

bool ListaEntrada::contiene(string idConcierto, string tipo){
    bool tiene=false;
      NodoListaEntrada *aux=this->primero;

    while(aux){
        if(aux->entrada.getIdConcierto()==idConcierto && aux->entrada.getTipo()==tipo)
            tiene=true;
        aux=aux->siguente;
    }
    return tiene;
}

void ListaEntrada::mostrar(){
    NodoListaEntrada *aux=this->primero;

    while(aux){
        aux->entrada.mostrar();
        aux=aux->siguente;
    }
}

void ListaEntrada::eliminarEntrada(Entrada entrada){
    bool encontrado=false;
    NodoListaEntrada *aux=this->primero;
    NodoListaEntrada *posAnt=NULL;

    if((this->primero->entrada.getIdConcierto()==entrada.getIdConcierto()) && (this->primero->entrada.getTipo()==entrada.getTipo())){
        encontrado=true;
    } //Miro si la primera entrada es la que estoy buscando
    else{
        while(aux->siguente && !encontrado){
            if((aux->siguente->entrada.getIdConcierto()==entrada.getIdConcierto())&&(aux->siguente->entrada.getTipo()==entrada.getTipo())){
                encontrado=true;
                posAnt=aux;
            }
        aux=aux->siguente;
        }
    }//Si no, busco entre las n-1 entradas donde esta

    if(!encontrado){
        cout<<"No he podido borrar esa entarda de este cliente porque no la tiene. "<<endl;
    }
    else{ //Procedo a eliminar
        NodoListaEntrada *aux2;
        if(encontrado && !posAnt){
            this->primero=this->primero->siguente;
        }
        else{
            aux2=posAnt->siguente;
            posAnt->siguente=aux2->siguente;
            aux2->siguente=NULL;
        }
        longitud--;
        delete(aux2);
    }
}


int ListaEntrada::contarEntradas(string idConcierto, string tipo){
    int total=0;

    NodoListaEntrada *aux=this->primero;

    while(aux){//Recorro la lista de entradas
        //Si coincide el nombre del concierto y el tipo dados, sumo 1
        if((aux->entrada.getIdConcierto()==idConcierto) && (aux->entrada.getTipo()==tipo))
            total+=1;
        aux=aux->siguente;
    }

    return total;
}
