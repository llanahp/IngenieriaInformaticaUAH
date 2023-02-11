#include <iostream>
#include <string>

#include "Entrada.h"
#include "Cliente.h"
#include "NodoPila.h"
#include "Pila.h"
#include "Pila.cpp"
#include "Cola.h"
#include "Lista.h"


using namespace std;

int main(){

    Cliente c1=Cliente();
    c1.setId("id1");
    c1.setRegistrado(true);

    Cliente c2=Cliente();
    c2.setId("id2");
    c2.setRegistrado(false);
    c2.setMinuto(10);


    Cliente c3=Cliente();
    c3.setId("id3");
    c3.setRegistrado(true);


    Cliente c4=Cliente();
    c4.setId("id4");
    c4.setRegistrado(false);

    /*Pila p;

    p.apilar(c1);
    p.apilar(c2);
    p.apilar(c3);
    p.apilar(c4);

    p.verEntera();*/

    /*Cola c;
    c.encolar(c1);
    c.encolar(c2);
    c.encolar(c3);
    c.encolar(c4);

    c.mostrarCola();*/

    Lista l;
    l.insertar(c1);
    l.insertar(c2);
    l.insertar(c3);
    l.insertar(c4);

    l.mostrar();
}
