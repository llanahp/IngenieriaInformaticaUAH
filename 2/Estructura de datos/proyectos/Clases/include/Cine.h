#ifndef CINE_H
#define CINE_H


class Cine
{
    public:
        Cine();
        ~Cine();
         bool esta_vacio();
         int fila_MasCompleta();
    protected:

    private:
        bool matriz[10][10];
};

#endif // CINE_H
