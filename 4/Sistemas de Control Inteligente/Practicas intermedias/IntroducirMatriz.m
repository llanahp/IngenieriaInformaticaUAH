function  matriz = IntroducirMatriz(Dimensiones)
   if length(Dimensiones) == 1 
        matriz = zeros(Dimensiones);
    elseif length(Dimensiones) == 2
        matriz = zeros(Dimensiones(1),Dimensiones(2))
   else
       return
   end

    [f,c] = size(matriz);
    ra=input("rellenar la matriz aleatoriamente (r/n)","s");
    if ra == "r"
        for fila = 1:f
             for columna = 1:c
                matriz(fila,columna) = rand(1);
             end
        end
    else
         for fila = 1:f
             for columna = 1:c
                 prompt="fila "+fila+" y columna "+ columna+" introduce su valor";
                 valor = input(prompt);
                  matriz(fila,columna) = valor;
             end
        end
    end
    
end