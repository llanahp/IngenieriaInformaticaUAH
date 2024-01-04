disp("Ejercicio 3")
prompt = "indique la dimension de la matriz [filas columnas] -> ";
Dimensiones = input(prompt);
matrizA = IntroducirMatriz(Dimensiones);
matrizB = IntroducirMatriz(Dimensiones);

disp("Matriz A")
disp(matrizA)
disp("Matriz B")
disp(matrizB)

%Resultado
disp("Matriz A transpuesta")
disp(matrizA.')
disp("Matriz B transpuesta")
disp(matrizB.')

disp("Matriz A inversa")
disp(inv(matrizA))
disp("Matriz B inversa")
disp(inv(matrizB))

disp("Matriz A determinante")
disp(det(matrizA))
disp("Matriz B determinante")
disp(det(matrizB))

disp("Matriz A rango")
disp(rank(matrizA))
disp("Matriz B rango")
disp(rank(matrizB))

disp("A*B matricial")
disp(matrizA*matrizB)

disp("A*B elemento a elemento")
disp(times(matrizA,matrizB))

disp("Primeras filas")
disp([matrizA(1,:),matrizB(1,:)])

disp("Primeras columnas")
disp([matrizA(:,1);matrizB(:,1)])
