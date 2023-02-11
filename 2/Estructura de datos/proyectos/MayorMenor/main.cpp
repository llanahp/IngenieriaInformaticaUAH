#include <iostream>

using namespace std;

int maineeeeeee()
{
    int a,b;
    int menor,mayor;
    cout<<"\nIntroduce un numero: ";
    cin>>a;
    cout<<"\nIntroduce otro numero: ";
    cin>>b;

    if(a>b)
    {
    mayor=a;
    }else{
    mayor=b;
    }
    menor=a<b?a:b;

    cout <<"\nMenor"<<menor;
    cout <<"\nMayor"<<mayor;

    return 0;
}
