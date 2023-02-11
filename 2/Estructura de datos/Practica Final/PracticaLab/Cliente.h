#ifndef CLIENTE_H_INCLUDED
#define CLIENTE_H_INCLUDED

#include <string>
#include "Entrada.h"

using namespace std;

class Cliente{
    private:
        bool registrado;
        int minuto;
        string id;
        Entrada entrada;
        int Numero_Aleatorio(int DESDE, int HASTA);


    public:
        Cliente(); //Constructor
        Cliente(bool registrado, int minuto, string id, Entrada entrada);
        Cliente(bool registrado, int minuto, Entrada entrada);
        Cliente(bool registrado, int minuto, string id);
        Cliente(bool registrado, int minuto);
        ~Cliente(); //Destructor

        Entrada getEntrada();
        bool isRegistrado();
        int getMinuto();
        string getId();
        string getTipo();
        string getIdConcierto();
        string getHoraLlegada();

        void generar_Entrada();
        void setRegistrado(bool estado);
        void setMinuto(int minuto);
        void setId(string id);
        void setEntrada(Entrada entrada);
        void mostrarDatos();
        bool contiene_entrada();
        string Generar_DNI();
};

#endif
