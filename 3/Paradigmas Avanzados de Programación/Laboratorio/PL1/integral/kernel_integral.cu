#include "cuda_runtime.h"
#include "device_launch_parameters.h"
#include <stdio.h>


//Funcion auxiliar para el calculo de la integral
__device__ float Funcion(float x) {
    return (x / (x * x + 4)) * sin(1.0f / x);
}


__global__ void Integral(float* valor, int numTrapecios) {
    

    // La integral es de 1 a 3.
    // Cada trapecio tendrá una base de 2 / número de trapecios,
    // de tal manera que la suma de todas las bases sea 2.
    float base = 2.0f / numTrapecios;
    float x = 1 + threadIdx.x * base;

    // El tamaño del array se asignara dinamicamente durante ejecucion, que será el máximo numero de threads de un bloque
    extern __shared__ float areas[];

    // Área del trapecio: (altura del primer punto + altura del segundo punto) / 2.
    areas[threadIdx.x] = base * (Funcion(x) + Funcion(x + base)) / 2;

    __syncthreads();

    //Un único recorre el array sumando todos los valores de las areas para obtener el resultado
    if (x == 1)
        for (int i = 0; i < numTrapecios; i++) {
            *valor += areas[i];
        }
    __syncthreads();
}

int main() {

    //Obtenemos las propiedades de la tarjeta
    cudaDeviceProp gpuProperties{};
    cudaGetDeviceProperties(&gpuProperties, 0);

    //Obtenemos el maximo numero de threads por bloque:
    int maxNumThreads = gpuProperties.maxThreadsPerBlock;

    //Declaramos la dimension del array que despues se pasará en el kernel
    int dimArray = sizeof(int) * maxNumThreads;

    //Asignamos las variables para el resultado en el dispositivo y en la CPU
    float* resultado_dev;
    float resultado = 0;

    //Reservamos la memoria en el dispositivo
    cudaMalloc(&resultado_dev, sizeof(float));

    //cudaMemcpy(resultado_dev, &resultado, sizeof(float), cudaMemcpyKind::cudaMemcpyHostToDevice);

  

    //Creamos un grid con un bloque con el maximo numero de threads que nos permite la tarjeta
    dim3 dimGrid = dim3(1, 1);
    dim3 dimBlock = dim3(maxNumThreads, 1);
    
    //Invocamos la kernel con las dimensiones, la variable resultado y el maximo numero de Threads como parametros
    Integral << <dimGrid,dimBlock,dimArray >> > (resultado_dev, maxNumThreads);

    //Copiamos el resultado de vuelta de la tarjeta
    cudaMemcpy(&resultado, resultado_dev, sizeof(float), cudaMemcpyKind::cudaMemcpyDeviceToHost);

    //Imprimimos el resultado
    printf("resultado: %f", resultado);

    //Liberamos las variables
    cudaFree(resultado_dev);

    return 0;
}
