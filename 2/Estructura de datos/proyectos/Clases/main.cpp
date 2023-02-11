#include <iostream>
#include "Pila.h"
using namespace std;

int main()
{
    cout << "Creamos la pila vacia" <<endl;

    Pila p;

    Pila pilaA;
    Pila pilaB;

    p.mostrar();

    p.apilar(8);

    p.apilar(4);
    p.mostrar();

    p.apilar(9);
    p.mostrar();
    //p.desapilar();
    p.mostrar();

    p.apilar(7);

    cout<<"la cuenta es: "<<p.contar()<<endl;

    p.fondo();

    //Creo 2 pilas para probar montar()
    pilaA.apilar(2);
    pilaA.apilar(4);


    pilaB.apilar(3);
    pilaB.apilar(8);

    cout<<"\n\nMensaje de control: antes de la llamada al metodo"<<endl;

    pilaA.montar(pilaB);




    cout<<"la cuenta es: "<<p.contar()<<endl;
    //8 3 2 4


    return 0;
}
