#include <iostream>

using namespace std;

void leerVector(int* numeros){

    int numero;
    for(int i=0;i<10;i++)
    {
        cout<< "introduce un numero"<<endl;
        cin>>numero;
        numeros[i]=numero;
    }

}

int main(){

    int vectores[10];
    leerVector(vectores);

    for(int i=0;i<10;i++){
        cout<< "valor: "<<vectores[i]<<endl;
    }
return 0;
}
