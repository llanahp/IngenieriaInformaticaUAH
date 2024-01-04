disp("Ejercicio 2")
    prompt = "indique el tamaño de la matriz";
    tamano = input(prompt);
    matriz = rand(tamano);
    disp(matriz)
    aux = size(matriz);
    mimpar = matriz(:,1:2:aux(:,1));
    disp(mimpar)
    diago = diag(matriz);
    disp(diago)
    
    maximo = max(matriz);
    minimo = min(matriz);
    medio = mean(matriz);
    varianza = var(matriz);


    f = figure('Name','Valores','NumberTitle','off');
    
    plot(maximo,'O');
    hold on
    plot(minimo,'O');
    plot(medio,'O');
    plot(varianza,'O');
    hold off
    xlabel("Fila");
    ylabel("valor");
