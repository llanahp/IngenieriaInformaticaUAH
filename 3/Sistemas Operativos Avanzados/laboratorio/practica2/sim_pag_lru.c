/*
    sim_pag_aleatorio.c
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

#include "sim_paginacion.h"

// Función que inicia las tablas

void iniciar_tablas(ssistema *S)
{
    int i;

    // Páginas a cero
    memset(S->tdp, 0, sizeof(spagina) * S->numpags);

    // Pila LRU vacía
    S->lru = -1;

    // Tiempo LRU(t) a cero
    S->reloj = 0;

    // Lista circular de marcos libres
    for (i = 0; i < S->nummarcos - 1; i++)
    {
        S->tdm[i].pagina = -1;
        S->tdm[i].sig = i + 1;
    }

    S->tdm[i].pagina = -1; // Ahora i == nummarcos-1
    S->tdm[i].sig = 0;     // Cerrar lista circular
    S->listalibres = i;    // Apuntar al último

    // Lista circular de marcos ocupados vacía
    S->listaocupados = -1;
}

// Funciones que simulan el hardware de la MMU

unsigned sim_mmu(ssistema *S, unsigned dir_virtual, char op)
{
    unsigned dir_fisica;
    int pagina, marco, desplazamiento;

    //Calcular el numero de pagina y el desplazamiento a partir de la dir_virtual
    pagina          = dir_virtual / S->tampag;         //cociente
    desplazamiento  = dir_virtual % S->tampag; //resto

    //comprobar si el acceso a la dirección indicada es legal

    if (pagina < 0 || pagina >= S->numpags)
    {

        S->numrefsilegales++;
        return ~0U; //Devolver la dirección física (-1)
    }

    //mira si la pagina se encuentra cargada en memoria
    //sino, invoca al SO para que la cargue
    if (!S->tdp[pagina].presente)
    { //tdp=tabla de paginas
        tratar_fallo_de_pagina(S, dir_virtual);
    }

    //Ahora ya está presente
    //toca traducir de direccion virtual a la direccion física
    marco = S->tdp[pagina].marco;
    dir_fisica = marco * S->tampag + desplazamiento; // direccion fisica

    //Marco la pagina como referenciada
    referenciar_pagina(S, pagina, op);

    //Si el usuario ejecuta el programa en modo detallado
    if (S->detallado)
    {
        printf("\t %c %u == P %d(M %d)+ %d\n", op, dir_virtual, pagina, marco, desplazamiento);
    }

    return dir_fisica;
}

void referenciar_pagina(ssistema *S, int pagina, char op)
{
    S->tdp[pagina].timestamp=S->reloj;
    S->reloj++;
   

    if(S->reloj ==   0){
        printf("Desbordamiento de reloj");
        
    }


    if (op == 'L'){           // Si es una lectura, contarla
        S->numrefslectura++;
    }
    else if (op == 'E')
    {                                  // Si es una escritura,
        S->tdp[pagina].modificada = 1; // contarla y marcar la página como modificada
        S->numrefsescritura++;      
    }
   
}

// Funciones que simulan el sistema operativo

void tratar_fallo_de_pagina(ssistema *S, unsigned dir_virtual)
{
    int pagina, victima, marco, ult;

    //Calculo la pagina que ha producido el error
    pagina = dir_virtual / S->tampag;

    //aumento el contador de errores
    S->numfallospag++;

    //Si se esta ejecutando el programa en modo detallado, informo
    if(S->detallado){
        printf("Fallo de pagina en: %d\n",pagina);
    }

    //En caso de haber marcos libes, saco uno de la lista (el primero) y lo ocupo con la pagian solicitada
    if(S->listalibres!=-1){ //existen marcos libres
       ult = S->listalibres;
       marco = S->tdm[ult].sig;

       if(marco == ult){ //si son el mismo, significa que solo quedaba uno libre
            S->listalibres=-1;
       }else{
           S->tdm[ult].sig = S->tdm[marco].sig; //actualizo el puntero
       }
       ocupar_marco_libre(S,marco,pagina);

    }else{//si no existen marcos libres, tengo que elegir uno para desalojarlo
        victima = elegir_pagina_para_reemplazo(S);
        reemplazar_pagina(S,victima,pagina);
        //ESTE ELSE ES MUY IMPORTANTE, YA QUE ES LO PRINCIPAL A LA HORA DE IMPLETAR UN METODO U OTRO SE CAMBIA ESTO PRINCIPALMENTE
    }


}



int elegir_pagina_para_reemplazo(ssistema *S)
{
    int  victima,marco=0; 

    //implemente una búsqueda secuencial del marco ocupado cuya página tenga el menor timestamp.
    
    for(int i=1;i < S->nummarcos;i++){
        if(S->tdp[S->tdm[marco].pagina].timestamp > S->tdp[S->tdm[i].pagina].timestamp){
            marco=i;
        }
    }


  
    victima = S->tdm[marco].pagina;

    if (S->detallado)
        printf("@ Eligiendo (LRU) P%d de M%d para " 
               "reemplazarla\n",
               victima, marco);   

    return victima;
}

void reemplazar_pagina(ssistema *S, int victima, int nueva)
{
    int marco;

    marco = S->tdp[victima].marco;

    if (S->tdp[victima].modificada)
    {
        if (S->detallado)
            printf("@ Volcando P%d modificada a disco para "
                   "reemplazarla\n",
                   victima);

        S->numescrpag++;
    }

    if (S->detallado)
        printf("@ Reemplazando víctima P%d por P%d en M%d\n",
               victima, nueva, marco);

    S->tdp[victima].presente = 0;

    S->tdp[nueva].presente = 1;
    S->tdp[nueva].marco = marco;
    S->tdp[nueva].modificada = 0;

    S->tdm[marco].pagina = nueva;
}

void ocupar_marco_libre(ssistema *S, int marco, int pagina)
{
    if (S->detallado)
        printf("@ Alojando P%d en M%d\n", pagina, marco);

    S->tdp[pagina].presente=1;
    S->tdp[pagina].marco=marco;
    S->tdp[pagina].modificada=0;

    
    S->tdm[marco].pagina=pagina;
}

// Funciones que muestran resultados

void mostrar_tabla_de_paginas(ssistema *S)
{
   
    int p;

    printf("%10s %10s %10s   %s %s\n","PÁGINA", "Presente", "Marco", "Modificada","valor reloj");

    for (p = 0; p < S->numpags; p++)
        if (S->tdp[p].presente)
            printf("%8d   %6d     %8d   %6d %6d\n",
                    p,
                    S->tdp[p].presente,
                    S->tdp[p].marco,
                    S->tdp[p].modificada,
                    S->tdp[p].timestamp);
        else
            printf("%8d   %6d     %8s   %6s %6s\n", p,S->tdp[p].presente, "-", "-", "-");

}

void mostrar_tabla_de_marcos(ssistema *S)
{
     
    int p, m;

    printf("%10s %10s %10s   %s\n",
           "MARCO", "Página", "Presente", "Modificada");

    for (m = 0; m < S->nummarcos; m++)
    {
        p = S->tdm[m].pagina;

        if (p == -1)
            printf("%8d   %8s   %6s     %6s\n", m, "-", "-", "-");
        else if (S->tdp[p].presente)
            printf("%8d   %8d   %6d     %6d\n", m, p,
                   S->tdp[p].presente, S->tdp[p].modificada);
        else
            printf("%8d   %8d   %6d     %6s   ¡ERROR!\n", m, p,
                   S->tdp[p].presente, "-");
    }
    
}

void mostrar_informe_reemplazo(ssistema *S)
{
    
    //LRU tiempo minimo
    int tiempoMenor=9999;
    for (int p = 0; p < S->numpags; p++){
        if (S->tdp[p].presente){
             if(S->tdp[p].timestamp < tiempoMenor){ 
                tiempoMenor=S->tdp[p].timestamp;
            }
        }
    }
    printf("timestamp mínimo: %d\n",tiempoMenor);
    
    //LRU Tiempo mayor
    int tiempoMayor;


    for (int p = 0; p < S->numpags; p++){
        if (S->tdp[p].presente){
             if(S->tdp[p].timestamp > tiempoMenor){ 
                tiempoMayor=S->tdp[p].timestamp;
            }
        }
    }
    printf("timestamp máximo: %d\n",tiempoMayor);

}
