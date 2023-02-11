#include <iostream>
#include <conio.h>
#include <string.h>
#include "Fraccion.h"
using namespace std;

Fraccion Sumar(Fraccion x, Fraccion y)
{
    int auxden=x.GetDen()*y.GetDen();
    int auxnum=(x.GetNum()*y.GetDen())+(x.GetDen()*y.GetNum());
    Fraccion f(auxnum,auxden);
    return f;
}
int main()
{
    Fraccion f;
    cout << "Creada la fraccion: f "; f.Escribir(); cout<<endl;
    Fraccion f2(4,6);
    cout << "Creada la fraccion: f2 "; f2.Escribir(); cout<<endl;
    Fraccion *f3 = new Fraccion(14,8);
    cout << "Creada la fraccion: f3 " ; (*f3).Escribir(); cout<<endl;
    Fraccion f4 = Fraccion(2,7);
    cout << "Creada la fraccion: f4 "; f4.Escribir(); cout<<endl;
    cout<<endl;
    cout << "Vamos a sumar ";
    f2.Escribir();
    cout << " y ";
    f4.Escribir();
    cout << endl << endl;
    f=Sumar(f2,f4); // Al acabar la función se destruyen las fracciones locales
                    // y se dispara el destructor
     cout<<endl<<endl;
     cout << "El resultado de la suma es: ";
    f.Escribir();
    cout << endl << endl;

    cout << "Vamos a destruir ";
    (*f3).Escribir();
    cout << endl;
    delete f3; // Destrucción voluntaria

    cout << "\nPulsa una tecla\n";
    _getch();

	return 0;
}



