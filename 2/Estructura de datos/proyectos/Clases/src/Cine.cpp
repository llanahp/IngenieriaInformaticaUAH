#include "Cine.h"
#include <iostream>
Cine::Cine()
{
    for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            if ((+j)%2==0)
                matriz[i][j]=true;
            else
                matriz[i][j]=false;
        }
    }
}

Cine::~Cine()
{
}

bool matriz[10][10];

bool Cine::esta_vacio(){
    bool resul=true;
    for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            if(matriz[i][j]==true)
            resul=false;
        }
    }
    return !resul;
}

int Cine::fila_MasCompleta(){
    int filaMayor=0, cantidad=0;
    for(int i=0;i<10;i++){
    int fila=0;
        for(int j=0;j<10;j++){
            if(matriz[i][j]==true)
            fila++;
        }
        if(fila>=cantidad){
            filaMayor=i;
            cantidad=fila;
        }
    }

}
