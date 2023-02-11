// Ejemplo de C++ para el laboratorio de Estructuras de Datos
// * Destructor de una clase
// * Liberación de memoria

#ifndef FRACCION_H
#define FRACCION_H
#include <iostream>
#include <conio.h>
#include <cmath>

using namespace std;
class Fraccion
{
public:
        Fraccion();
        Fraccion(int x, int y);

        ~Fraccion();
        /*{cout << "Se acaba de destruir "
                          << num << "/" << den << endl;} // Destructor*/
        void Escribir(); /*{cout << num << "/" << den;}*/
        int GetNum();/* {return num;}*/
        int GetDen();/*{return den;}*/

    private:
        int num,den;
        int MCD(int a, int b)
        {
            int aux;
            while (a%b!=0)
            {
                aux=a%b;
                a=b;
                b=aux;
            };
            return b;
        }
        void Reducir()
        {
            int aux=MCD(abs(num),abs(den));
            num/=aux;
            den/=aux;
            if (den<0)
            {
                num=-num;
                den=-den;
            };
            return;
        }
};





#endif // FRACCION_H

