#include <iostream>
#include <string>
#include <stdio.h>

#include "Cliente.h"
#include "Entrada.h"
#include "Entrada.cpp"



using namespace std;

Cliente::Cliente(bool registrado, int minuto, string id, Entrada entrada){
    this->registrado=registrado;
    this->minuto=minuto;
    this->id=id;
    this->entrada=entrada;
}

Cliente::Cliente(bool registrado, int minuto, Entrada entrada){
    this->registrado=registrado;
    if(!this->isRegistrado()){
        this->id=Generar_DNI();
    }
    else{
        this->id="CODREG000";
    }
    this->minuto=minuto;
    this->entrada=entrada;
}

Cliente::Cliente(bool registrado, int minuto, string id){
    this->registrado=registrado;
    this->minuto=minuto;
    this->id=id;
}

Cliente::Cliente(bool registrado, int minuto){
    this->registrado=registrado;
    if(!this->isRegistrado()){
        this->id=Generar_DNI();
    }
    else{
        this->id="CODREG000";
    }
    this->minuto=minuto;
}

Cliente::Cliente(){
    this->id="CODREG000";
    this->entrada=Entrada();
}

Cliente::~Cliente(){
}

bool Cliente::isRegistrado(){
    return this->registrado;
}

int Cliente::getMinuto(){
    return this->minuto;
}

string Cliente::getHoraLlegada(){
    string cadena = "10:"+to_string(this->minuto);
    return cadena;
}

string Cliente::getId(){
    return this->id;
}

Entrada Cliente::getEntrada(){
    return this->entrada;
}

string Cliente::getTipo(){
    return this->getEntrada().getTipo();
}

string Cliente::getIdConcierto(){
    return this->getEntrada().getIdConcierto();
}

void Cliente::setRegistrado(bool estado){
    this->registrado=estado;
}

void Cliente::setMinuto(int minuto){
    this->minuto=minuto;
}

void Cliente::setId(string id){
    this->id=id;
}

void Cliente::setEntrada(Entrada entrada){
    this->entrada=entrada;
}

int Cliente::Numero_Aleatorio(int DESDE, int HASTA){
  return rand()%(HASTA-DESDE+1)+DESDE;
}

bool Cliente::contiene_entrada(){
    bool resul=false;
    if(this->entrada.tiene_entrada()){
        resul=true;
    }
    return resul;
}

void Cliente::generar_Entrada(){
    this->entrada=this->entrada.Generar_Entrada_Aleatoria();
}

void Cliente::mostrarDatos(){

        string cadena ="ID: "+ this->getId() + " Hora de llegada: "+this->getHoraLlegada();
        string entrada_cliente;
        if(this->contiene_entrada()){
                entrada_cliente=" concierto: " + this->getIdConcierto()+" tipo: "+this->getTipo();
        }else{
            entrada_cliente="";
        }
        cout<< cadena << entrada_cliente<<endl;

}

string Cliente::Generar_DNI(){
    char letras[]="TRWAGMYFPDXBNJZSQVHLCKE\0";
    string DNI="";
    int numero,posicion_array;
    numero=Numero_Aleatorio(10000000,99999999);
    posicion_array=numero - (numero / 23 * 23);
    DNI = to_string(numero)+letras[posicion_array];
    return DNI;
}



