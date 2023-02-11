#ifndef NODOLISTAENTRADA_H_INCLUDED
#define NODOLISTAENTRADA_H_INCLUDED

class NodoListaEntrada{
    private:
        Entrada entrada;
        NodoListaEntrada* siguente;
    public:
        NodoListaEntrada(Entrada entrada);
        ~NodoListaEntrada();
        friend class ListaEntrada;
};

#endif // NODOLISTAENTRADA_H_INCLUDED
