#include "NodoPila.h"

NodoPila::NodoPila()
{
    valor = 0 ;
    siguiente = NULL;
}

NodoPila::NodoPila(int v, NodoPila *sig)
{
    valor =v;
    siguiente=sig;
}
NodoPila::~NodoPila()
{

}
