#include <iostream>

using namespace std;



int main(){

int introducido=0;
int i=0;
int suma=0;

    do{

        i++;
        suma+=introducido;
        cout << "Introduce un numero (para parar introduce 99): ";
        cin>>introducido;


    } while(introducido!=(-99) && i<=10);

cout << "La media es: "<<(suma/i);

return 0;

}

int[] leerVector(){
    int numero;
    int vector[10];
    for(int i=0;i<10;i++)
    {
    cout<< "introduce un numero"<<endl;
    cin>>numero;
    vector[i]=numero;
    }
    return vector
}
