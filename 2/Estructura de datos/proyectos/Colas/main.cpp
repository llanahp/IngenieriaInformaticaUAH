#include <iostream>
#include "Cola.h"

using namespace std;

int main()
{
    cout <<"hola colas"<<endl;
    Cola cola;
    cola.mostrar_cola();

    cola.encolar('1');
    cola.encolar('2');
    cola.encolar('3');
    cola.mostrar_cola();

    cout<<cola.inicio()<<endl;
    cout<<cola.fin()<<endl;


    cout<<cola.get_longitud()<<endl;
    cola.desencolar();
    cout<<cola.get_longitud()<<endl;
    cola.mostrar_cola();
    cola.encolar('4');

    cout<<"-------------"<<endl;

    cola.mostrar_cola();
    cola.invertir();
    cout<<"\t--------"<<endl;
    cola.mostrar_cola();


    Cola cola2;

    cola2.encolar('4');
    cola2.encolar('3');
    cola2.encolar('2');

cout<<"-------------"<<endl;
    cola.mostrar_cola();
cout<<"-------------"<<endl;
    cout<<"-------------"<<endl;
    if(cola.iguales(cola2)){
        cout <<"iguales"<<endl;
    }else{
        cout <<"Distintos"<<endl;
    }
cout<<"-------------"<<endl;
    cout<<"-------------"<<endl;



    cola.mostrar_cola();
    if(cola.es_simetrica(cola)){
        cout <<"simetrica"<<endl;
    }else{
        cout <<"No es simetrica "<<endl;
    }
    return 0;
}
