#include "NodoArbol.h"
#include "ListaEntrada.cpp"

using namespace std;

NodoArbol::NodoArbol(string idCliente,Entrada entrada, NodoArbol *hijo_izquierdo, NodoArbol *hijo_derecho)
{
    this->idCliente=idCliente;
    this->hijo_derecho=hijo_derecho;
    this->hijo_izquierdo=hijo_izquierdo;
    this->listaEntradas.insertarEntrada(entrada);

}

void NodoArbol::mostrarDatos(){
    cout << this->idCliente<<endl;
    this->listaEntradas.mostrar();
    cout <<endl;
}
