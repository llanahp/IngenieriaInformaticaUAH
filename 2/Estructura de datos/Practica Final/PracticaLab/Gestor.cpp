#include <ctime>
#include <iostream>
#include <string>
#include <windows.h>

#include "Gestor.h"
#include "Pila.h"
#include "Pila.cpp"
#include "Cola.h"
#include "Lista.h"
#include "ArbolBinario.h"
#include "ArbolBinario.cpp"

Gestor::Gestor()
{
    this->pila=Pila();
    this->cola_No_Registrados=Cola();
    this->cola_Registrados=Cola();
    this->lista=Lista();
    this->arbol=ArbolBinario();
}

Gestor::~Gestor(){}

string Gestor::get_nuevoID(){
    //Aumento el contador
    contador++;
    //Transformo el numero a string
    string idUltimo=to_string(contador);
    //Doy formato para que el numero contenga 3 caracteres
    switch(idUltimo.length()){
            case 1:
                idUltimo="00"+idUltimo;
                break;
            case 2:
                idUltimo="0"+idUltimo;
                break;
    }
    return "CODREG"+idUltimo;
}

int Gestor::numero_Aleatorio(int DESDE, int HASTA){
  return rand()%(HASTA-DESDE+1)+DESDE;

}

void Gestor::reiniciar(){
    this->pila.borrar_Clientes();
    this->cola_No_Registrados.borrar();
    this->cola_Registrados.borrar();
    this->lista.borrar_Lista();
    this->arbol.borrar();
}

void Gestor::crearPrimerosClientes(Pila *pila){
    int aleatorio=numero_Aleatorio(5,15);

      for(int i=0; i<aleatorio; i++){ //Clientes registrados
        if(i%2==0)
            pila->apilar(Cliente(true,numero_Aleatorio(0,59),get_nuevoID()));
        else
            pila->apilar(Cliente(false,numero_Aleatorio(0,59)));
    }

}

void Gestor::crearSegundosClientes(Cola *cola_Regis, Cola *cola_No_Regis){
    int aleatorio=numero_Aleatorio(5,15);


    for(int i=0; i<aleatorio; i++){ //Clientes registrados
        cola_Regis->encolar(Cliente(true,numero_Aleatorio(0,59),get_nuevoID()));
    }


    aleatorio=numero_Aleatorio(5,15);
    for(int i=0; i<aleatorio; i++){ //Clientes NO registrados
        cola_No_Regis->encolar(Cliente(false,numero_Aleatorio(0,59)));
    }

}

char Gestor::menu(){
    char tarea;

    cout<<"\n\t\t-----------SISTEMA GESTOR DE VENTA DE ENTRADAS-----------\n"<<endl;
    cout<<"a. Generar pila de clientes con reserva de entrada y dos colas de clientes registrados y no registrados que van a comprar"<<endl;
    cout<<"b. Generar N clientes con reserva de entrada e incluirlos a la pila"<<endl;
    cout<<"c. Generar N clientes registrados y M no registrados que acceden a la compra de entardas"<<endl;
    cout<<"d. Incluir manualmente un cliente en la pila"<<endl;
    cout<<"e. Incluir manualmente un cliente en la cola"<<endl;
    cout<<"f. Mostrar clientes en la pila"<<endl;
    cout<<"g. Borrar la pila de clientes"<<endl;
    cout<<"h. Mostrar la cola de clientes registrados en espera de compra"<<endl;
    cout<<"i. Mostrar la cola de clientes no registrados en espera de compra"<<endl;
    cout<<"j. Borrar las dos colas"<<endl;
    cout<<"k. Pasar a todos los clientes en espera a la fase de compra"<<endl;
    cout<<"l. Mostrar los datos de todos los clientes de la lista"<<endl;
    cout<<"m. Buscar en la lista y mostrar los datos del primer cliente registrado que ha comprado una entrada"<<endl;
    cout<<"n. Buscar en la lista y mostrar los datos del primer cliente no registrado que ha comprado entrada"<<endl;
    cout<<"o. Buscar en la lista y mostrar, dado el identificador de un concierto, los datos de todos los clientes que han comprado una entrada"<<endl;
    cout<<"p. Borrar los datos de un cliente de la lista, dado su identificador (DNI o codigo de cliente)"<<endl;
    cout<<"q. Borrar la lista de clientes"<<endl;
    cout<<"r. Simular que se finaliza la compra de entradas, sacando los clientes de la lista e insertandolos en el arbol binario de busqueda en el orden indicado. El arbol puede estar o no vacio."<<endl;
    cout<<"s. Insertar un cliente, manualmente, en el arbol."<<endl;
    cout<<"t. Mostrar los datos de todos los clientes registrados, ordenados por codigo de cliente (inorden)"<<endl;
    cout<<"u. Mostrar los datos de todos los clientes no registrados, ordenados por DNI (inorden)."<<endl;
    cout<<"v. Borrar los datos de un cliente en el arbol, dado su identificador (DNI o codigo de cliente)."<<endl;
    cout<<"w. Buscar un cliente, en el arbol, y mostrar los datos de las entradas que ha comprado."<<endl;
    cout<<"x. Mostrar los datos de todos los clientes almacenados en el arbol (recorrido en preorden)."<<endl;
    cout<<"y. Mostrar una estadistica del total de entradas vendidas para un concierto dado, desglosadas por tipo."<<endl;
    cout<<"z. Reiniciar el programa."<<endl;



    cout<<"$. Salir"<<endl;

    cout<<"\nIntroduzca tarea: ";
    cin>>tarea;

    return tarea;
}

void Gestor::programa(){
    ShowWindow(GetConsoleWindow(), SW_MAXIMIZE); //Pantalla completa

    char opcion;
    srand(time(NULL)); //Para generar numeros aleatorios

    while(true){
        opcion=menu();
        switch(opcion){
            case 'a':
                crearPrimerosClientes(&this->pila);
                crearSegundosClientes(&this->cola_Registrados, &this->cola_No_Registrados);
                break;

            case 'b':{
                    int p;
                    cout<<"Cantidad de clientes a generar: ";
                    cin>>p;

                    for(int i=0; i<p; i++){
                        this->pila.apilar(Cliente(true, numero_Aleatorio(0,59), get_nuevoID()));
                    }
                }
                break;

            case 'c':
                {
                    int p;
                    cout<<"Cantidad de clientes registrados a generar: ";
                    cin>>p;

                    for(int i=0; i<p; i++){
                       this->cola_Registrados.encolar(Cliente(true, numero_Aleatorio(0,59), get_nuevoID()));
                    }

                    cout<<"Cantidad de clientes no registrados a generar: ";
                    cin>>p;

                    for(int i=0; i<p; i++){
                       this->cola_No_Registrados.encolar(Cliente(false, numero_Aleatorio(0,59)));
                    }
                }
                break;

            case 'd':
                {
                    //bool registrado=true;//true -> "CODREG000"; false -> "03488795T"
                    bool registrado=false;
                    string id="03488795T";
                    int hora_llegada=numero_Aleatorio(0,59);
                    //Entrada entrada=Entrada(Entrada().tipos[2],Entrada().Concierto[0]);
                    Entrada entrada=Entrada(Entrada().tipos[(rand()%(2-0+1)+0)], Entrada().Concierto[(rand()%(2-0+1)+0)]);

                    this->pila.apilar(Cliente(registrado, hora_llegada, id, entrada));
                }
                break;

            case 'e':
                {
                    bool registrado=true;//true -> "CODREG000"; false -> "03488795T"
                    int hora_llegada=numero_Aleatorio(0,59);
                    //Entrada entrada=Entrada(Entrada().tipos[2],Entrada().Concierto[0]);
                    Entrada entrada=Entrada(Entrada().tipos[(rand()%(2-0+1)+0)], Entrada().Concierto[(rand()%(2-0+1)+0)]);

                    if(registrado){
                        this->cola_Registrados.encolar(Cliente(registrado, hora_llegada, get_nuevoID(), entrada));
                    }else{
                        this->cola_No_Registrados.encolar(Cliente(registrado, hora_llegada, entrada));
                    }
                }
                break;

            case 'f':
                this->pila.verEntera();

                break;

            case 'g':
                this->pila.borrar_Clientes();

                break;

            case 'h':
                this->cola_Registrados.mostrarCola();

                break;

            case 'i':
                this->cola_No_Registrados.mostrarCola();

                break;

            case 'j':
                this->cola_Registrados.borrar();
                this->cola_No_Registrados.borrar();

                break;

            case 'k':
                {
                    int total=this->cola_Registrados.get_longitud();
                    for(int i=0;i<total;i++){
                        this->lista.insertar(this->cola_Registrados.desencolar());
                    }


                    total=this->cola_No_Registrados.get_longitud();
                    for(int i=0;i<total;i++){
                        this->lista.insertar(this->cola_No_Registrados.desencolar());
                    }

                    total=this->pila.contar();
                    for(int i=0;i<total;i++){
                        this->lista.insertar(this->pila.primero());
                        this->pila.desapilar();
                    }
                }
                break;

            case 'l':
                {
                this->lista.mostrar();
                }
                break;

            case 'm':
                {
                this->lista.info_PrimeroRegistrado();
                }
                break;

            case 'n':
                {
                this->lista.info_PrimeroNoRegistrado();
                }
                break;

            case 'o':
                {
                    string p;
                    cout<<"Nombre del concierto (ESTOPA, MALU, MELENDI): ";
                    cin>>p;
                    this->lista.info_concierto(p);
                }
                break;

            case 'p':
                {
                    string p;
                    cout<<"ID del cliente que quieres borrar: ";
                    cin>>p;
                    this->lista.borrar_cliente(p);
                }
                break;

            case 'q':
                {
                this->lista.borrar_Lista();
                }
                break;

            case 'r':
                {
                    this->arbol.insertarClientes(lista);
                }
                break;

            case 's':
                {
                    //bool registrado=true;//true -> "CODREG000"; false -> "03488795T"
                    bool registrado=false;//true -> "CODREG000"; false -> "03488795T"
                    string id= "03488795T";
                    int hora_llegada=numero_Aleatorio(0,59);
                   //Entrada entrada=Entrada(Entrada().tipos[2],Entrada().Concierto[0]);
                    Entrada entrada=Entrada(Entrada().tipos[(rand()%(2-0+1)+0)], Entrada().Concierto[(rand()%(2-0+1)+0)]);

                    if(registrado){
                        this->arbol.insertarCliente(Cliente(registrado, hora_llegada, get_nuevoID(), entrada));
                    }else{
                        this->arbol.insertarCliente(Cliente(registrado, hora_llegada, id, entrada));
                    }
                }
                break;

            case 't':
                {
                    this->arbol.mostrarInordenRegistrados();
                }
                break;

            case 'u':
                {
                    this->arbol.mostrarInordenNoRegistrados();
                }
                break;

            case 'v':
                {
                    string id;
                    cout<<"Id del cliente que quieres borrar: ";
                    cin>>id;
                    this->arbol.borrarCliente(id);
                }
                break;

            case 'w':
                {
                    string id;
                    cout<<"Id del cliente que quieres saber sus entradas: ";
                    cin>>id;
                    this->arbol.infoCliente(id);
                }
                break;

            case 'x':
                {
                    this->arbol.mostrarPreorden();
                }
                break;

            case 'y':
                {
                    string id;
                    cout<<"Id del concierto que quieres saber informacion: ";
                    cin>>id;
                    this->arbol.mostrarInfoEntradas(id);
                }
                break;

            case 'z':
                {
                    this->reiniciar();
                }
                break;


            case '$':
                exit(0);
                break;

            default:
                cout<<"Su tarea no puede realizarse. "<<endl;
                break;
        }
    }
}
