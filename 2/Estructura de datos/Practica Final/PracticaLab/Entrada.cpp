#include <iostream>
#include <string>

#include "Entrada.h"

using namespace std;

string tipos[3] = {"PALCO","GALLINERO","PATIO"};
string Concierto[3] = {"ESTOPA","MALU","MELENDI"};

Entrada::Entrada(string tipo, string idConcierto){
    this->tipo=tipo;
    this->idConcierto=idConcierto;
}

Entrada::Entrada(){
}

Entrada::~Entrada(){
}

string Entrada::getTipo(){
    return this->tipo;
}

string Entrada::getIdConcierto(){
    return this->idConcierto;
}

void Entrada::setTipo(string tipo){
    this->tipo=tipo;
}

void Entrada::setIdConcierto(string idConcierto){
    this->idConcierto=idConcierto;
}

void Entrada::mostrar(){
    char caracter=192;
    cout<<"   "<<caracter<<"Tipo: "<<this->tipo<<", idConcierto: "<<this->idConcierto<<endl;
}

int Entrada::Numero_Aleatorio(int DESDE, int HASTA){
  return rand()%(HASTA-DESDE+1)+DESDE;

}

bool Entrada::tiene_entrada(){
    if(this->idConcierto!="" && this->tipo!=""){
        return true;
    }
    else{
        return false;
    }
}

Entrada Entrada::Generar_Entrada_Aleatoria(){
    Entrada entrada;

    entrada.setTipo(tipos[Numero_Aleatorio(0,2)]);
    entrada.setIdConcierto(Concierto[Numero_Aleatorio(0,2)]);

    return entrada;
}
