#include "cuda_runtime.h"
#include "device_launch_parameters.h"
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

const int N = 16;
const int M = 3;
const int width = 16;
const int TILE_WIDTH = 16 / 2;


__global__ void stencil(const int *a, const int *b, int*c)
{

	int fila = blockIdx.y*TILE_WIDTH + threadIdx.y;
	int columna = blockIdx.x*TILE_WIDTH + threadIdx.x;

	//Si no es de un borde
	if (columna != 0 && columna != N - 1 && fila != 0 && fila != N - 1) {
		
		int total = 0;
		int posicion = (fila*width + columna);
		//Calcula la columna de la izquierda
		int i = -1;
		total += a[posicion - width + i] * b[0] + a[posicion + i] * b[3] +a[posicion + width +i]* b[6];
		

		//Calcula la columna central
		
		total = total + (a[posicion - width ] * b[1]+ a[posicion] * b[4] + a[posicion + width ] * b[7] );

		
		//Calcula la columna de la derecha 
		i = 1;
		total = total + (a[posicion - width + i] * b[2] + a[posicion + i] * b[5] + a[posicion + width + i] * b[8]);
					
		
		//almaceno el resultado
		c[(fila - 1)*(width - 2) + columna - 1] = total;
	}
}

int main()
{
	//declaracion de matrices
	int  primeraMatrizH[N*N],segundaMatrizH[M*M], resultadoH[(N - 2)*(N - 2)];
	int* primeraMatrizD, *segundaMatrizD, *resultadoD;

	//size que van a tener las matrices
	int size = N * N* sizeof(int);

	//reservo memoria en Device
	cudaMalloc((void **)&primeraMatrizD, size);
	cudaMalloc((void **)&resultadoD, size);

	cudaMalloc((void **)&segundaMatrizD, M*M * sizeof(int));
	
	//Declaracion de semilla aleatoria con la hora local para el generador de numeros aleatorios
	srand(time(NULL));

	//relleno las matrices
	
	for (int i = 0; i < N*N; i++) {	
		primeraMatrizH[i] = rand() % 256;
	}

	for (int i =0 ;i<M*M;i++) {
		segundaMatrizH[i] =rand() % 11;
	}
	int matrizTemporal[M*M];
	//cambio las posiciones del filtro
	for (int i = 0; i < M*M; i++) {
		
			matrizTemporal[i] = segundaMatrizH[abs(((M*M)-1)-i)];
	}
	

	//muestro las matrices por pantalla
	printf("Primera Matriz \n");
	for (int i = 0; i < N*N; i++) {
		if (i !=0 && i%16==0)
			printf("\n");
		printf("%d, ", primeraMatrizH[i]);
	}
	printf("\n");


	printf("\nSegunda Matriz \n");
	for (int i = 0; i < M*M; i++) {
		if (i != 0 && i % 3 == 0)
			printf("\n");
		printf("%d, ", segundaMatrizH[i]);
	}
	printf("\n");
	printf("\nSegunda Matriz transpuesta\n");
	for (int i = 0; i < M*M; i++) {
		if (i != 0 && i % 3 == 0)
			printf("\n");
		printf("%d, ", matrizTemporal[i]);
	}
	printf("\n\n");



	cudaMemcpy(primeraMatrizD, &primeraMatrizH, size, cudaMemcpyHostToDevice);
	cudaMemcpy(segundaMatrizD, &matrizTemporal, M*M * sizeof(int), cudaMemcpyHostToDevice);
	cudaMemcpy(resultadoD, &resultadoH, size, cudaMemcpyHostToDevice);

	//cambio el valor en la GPU
	dim3 dimGrid(width / TILE_WIDTH, width / TILE_WIDTH);
	dim3 dimBlock(TILE_WIDTH, TILE_WIDTH);


	//Stencil
	stencil << < dimGrid, dimBlock >> > (primeraMatrizD,segundaMatrizD, resultadoD);
	cudaMemcpy(&resultadoH, resultadoD, size, cudaMemcpyDeviceToHost);

	printf("Resultado\n");
	for (int i = 0; i < (N - 2)*(N - 2); i++) {
		if (i != 0 && i % 14 == 0)
			printf("\n");
		printf("%d, ", resultadoH[i]);
	}

	cudaFree(primeraMatrizD);
	cudaFree(resultadoD);

	//get char X2
	getchar();
	getchar();

	return 0;
}
