disp("Ejercicio 1")
    A = [1 ,2;3 ,4;5, 6;7 ,8];
    v = [14;16;18;20];
    B = [A,v];
    disp(B)
    vfila = [B(:)]';
    disp(vfila)
    vcolum = [B(:)];
    disp(vcolum)
