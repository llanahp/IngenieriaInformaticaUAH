disp("Ejercicio 4")
array_rank = zeros(1,25);
array_det = zeros(1,25);
f = figure('Name','Tiempo','NumberTitle','off');

for dim = 1:25
    start = tic;
        matriz = rand(dim);
        rank(matriz);
    finran = toc(start);
    array_rank(dim)=finran;
    startdet = tic;
        det(matriz);
    fin= toc(startdet);
    array_det(dim)=fin;
end
hold on
plot(array_rank,'X');
plot(array_det,'O');
hold off
xlabel("dimension");
ylabel("tiempo");