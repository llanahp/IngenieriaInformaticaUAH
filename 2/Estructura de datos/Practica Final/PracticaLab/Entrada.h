#ifndef ENTRADA_H_INCLUDED
#define ENTRADA_H_INCLUDED

#include <string>

using namespace std;

class Entrada{
    private:
        string tipo;
        string idConcierto;

        friend class Cliente;

    public:
        Entrada(string tipo, string idConcierto); //Constructor
        Entrada(); //Sobrecarga de constructor
        ~Entrada(); //Destructor

        //Getters
        string getTipo();
        string getIdConcierto();

        //Setters
        void setTipo(string tipo);
        void setIdConcierto(string idConcierto);

        Entrada Generar_Entrada_Aleatoria();
        int Numero_Aleatorio(int DESDE, int HASTA);
        void mostrar();
        bool tiene_entrada();
        string tipos[3] = {"PALCO","GALLINERO","PATIO"} ;
        string Concierto[3] = {"ESTOPA","MALU","MELENDI"};
};


#endif // ENTRADA_H_INCLUDED
