#include "cuda_runtime.h"
#include "device_launch_parameters.h"
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <cassert>

#define MATRIX_WIDTH 16
constexpr int CONVOLUCION_WIDTH = 3;
constexpr int TILE_WIDTH = 16 / 2;

//Define para obtener la posicion global de la matriz
#define GET_INDEX(x, y, width) (y) * (width) + (x)

//Funcion para el calculo de la convolucion recibe la matriz para convolucion en matriz y en convolucion
__global__ void Convolucion(const int* matriz, const int* convolucion, int* resultado) {
	
	int x = blockIdx.x * blockDim.x + threadIdx.x;
	int y = blockIdx.y * blockDim.y + threadIdx.y;
	
	//Calculamos el inicio y el final del bloque
	int startX = blockIdx.x * blockDim.x;
	int startY = blockIdx.y * blockDim.y;
	
	//El final es el primer elemento del siguiente bloque menos 1
	int endX = blockIdx.x * blockDim.x + blockDim.x - 1;
	int endY = blockIdx.y * blockDim.y + blockDim.y - 1;
	
	//Matriz compartida
	__shared__ int sharedMatriz[TILE_WIDTH][TILE_WIDTH];
	
	//Cada thread rellena su numero de la compartida
	sharedMatriz[threadIdx.x][threadIdx.y] = matriz[GET_INDEX(x, y, MATRIX_WIDTH)];

	__syncthreads();

	//Si no es de un borde
	if (x > 0 && x < MATRIX_WIDTH - 1 && y > 0 && y < MATRIX_WIDTH - 1) {
		int value = 0;
		//Cogemos los elementos de la matriz para la convolucion
		for (int diffX = -1; diffX < 1; diffX++) {
			
			for (int diffY = -1; diffY < 1; diffY++) {
				//Si esta dentro de los limites de la memoria compartida
				if (x + diffX >= startX && x + diffX <= endX && y + diffY >= startY && y + diffY <= endY)
					//Se 
					value += sharedMatriz[threadIdx.x + diffX][threadIdx.y + diffY] * convolucion[GET_INDEX(diffX + 1, diffY + 1, CONVOLUCION_WIDTH)];
				
				else
					value += matriz[GET_INDEX(x + diffX, y + diffY, MATRIX_WIDTH)] * convolucion[GET_INDEX(diffX + 1, diffY + 1, CONVOLUCION_WIDTH)];
				
			}
		}
		
		//Se resta 1 para comenzar desde la primera fila ya que la X empieza en la segunda columna
		resultado[GET_INDEX(x - 1, y - 1, MATRIX_WIDTH - 2)] = value;
	}

	__syncthreads();
}

int main()
{
	//declaracion de matrices
	int matriz[MATRIX_WIDTH * MATRIX_WIDTH];
	int convolucion[CONVOLUCION_WIDTH * CONVOLUCION_WIDTH];
	int resultado[(MATRIX_WIDTH - 2) * (MATRIX_WIDTH - 2)];

	int* matriz_dev = nullptr;
	int* convolucion_dev = nullptr;
	int* resultado_dev = nullptr;

	//reservo memoria en Device
	cudaMalloc(&matriz_dev, sizeof(matriz));
	cudaMalloc(&convolucion_dev, sizeof(convolucion));
	cudaMalloc(&resultado_dev, sizeof(resultado));

	//Declaracion de semilla aleatoria con la hora local para el generador de numeros aleatorios
	srand(time(NULL));

	//relleno las matrices

	for (int i = 0; i < _countof(matriz); i++)
		matriz[i] = rand() % 256;

	for (int i = 0; i < _countof(convolucion); i++)
		convolucion[i] = rand() % 11;

	int matrizTemporal[CONVOLUCION_WIDTH * CONVOLUCION_WIDTH];
	//cambio las posiciones del filtro
	for (int i = 0; i < _countof(matrizTemporal); i++)
		matrizTemporal[i] = convolucion[abs(((CONVOLUCION_WIDTH * CONVOLUCION_WIDTH) - 1) - i)];


	//muestro las matrices por pantalla
	printf("Primera Matriz \n");
	for (int i = 0; i < _countof(matriz); i++) {
		if (i != 0 && i % 16 == 0)
			printf("\n");
		printf("%i, ", matriz[i]);
	}
	printf("\n");


	printf("\nSegunda Matriz \n");
	for (int i = 0; i < _countof(convolucion); i++) {
		if (i != 0 && i % 3 == 0)
			printf("\n");
		printf("%i, ", convolucion[i]);
	}
	printf("\n");
	printf("\nSegunda Matriz transpuesta\n");
	for (int i = 0; i < _countof(matrizTemporal); i++) {
		if (i != 0 && i % 3 == 0)
			printf("\n");
		printf("%i, ", matrizTemporal[i]);
	}
	printf("\n\n");



	cudaMemcpy(matriz_dev, &matriz, sizeof(matriz), cudaMemcpyHostToDevice);
	cudaMemcpy(convolucion_dev, &matrizTemporal, sizeof(matrizTemporal), cudaMemcpyHostToDevice);

	//cambio el valor en la GPU
	dim3 dimGrid(MATRIX_WIDTH / TILE_WIDTH, MATRIX_WIDTH / TILE_WIDTH);
	dim3 dimBlock(TILE_WIDTH, TILE_WIDTH);


	//Realizamos la convolucion
	Convolucion <<<dimGrid, dimBlock>>>(matriz_dev, convolucion_dev, resultado_dev);

	printf("Resultado size: %i\n", sizeof(resultado));
	cudaMemcpy(&resultado, resultado_dev, sizeof(resultado), cudaMemcpyDeviceToHost);

	printf("Resultado\n");
	for (int i = 0; i < _countof(resultado); i++) {
		if (i != 0 && i % 14 == 0)
			printf("\n");
		printf("%i, ", resultado[i]);
	}

	cudaFree(matriz_dev);
	cudaFree(resultado_dev);

	//get char X2
	getchar();
	getchar();

	return 0;
}
