#ifndef NODO_H
#define NODO_H


class Nodo
{
    protected:

    public:
        Nodo(int v, Nodo *sig = NULL){
            valor=v;
            siguiente=sig;
        }
        typedef Nodo *pNodo;




    private:
        int valor;
        Nodo *siguiente;
        friend class pila;
};

#endif // NODO_H
