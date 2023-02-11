#include "Fraccion.h"
Fraccion::Fraccion()
{num=0; den=1;};
Fraccion::Fraccion(int x, int y)
        {
            if (y!=0)
            {num=x; den=y; Reducir();}
            else
            {num=0; den=1;};
        }
Fraccion::~Fraccion() {cout << "Se acaba de destruir "
                          << num << "/" << den << endl;}; // Destructor
       void Fraccion::Escribir() {cout << num << "/" << den;};
      int Fraccion:: GetNum() {return num;};
     int Fraccion::GetDen() {return den;};
