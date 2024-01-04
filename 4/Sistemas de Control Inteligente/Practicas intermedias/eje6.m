A= zeros(10,4);
A(1,:)=[0 2 10 7];
A(2,:)=[2 7 7 1];
A(3,:)=[1 9 0 5];
A(4,:)=[4 0 0 6];
A(5,:)=[2 8 4 1];
A(6,:)=[10 5 0 4];
A(7,:)=[2 6 4 0];
A(8,:)=[1 1 9 3];
A(9,:)=[6 4 8 2];
A(10,:)=[0 3 0 9];

Aaux  = [90; 59; 15; 10; 80; 17; 93; 51; 41; 76];
%numero de condicion de A
condi = cond(A);
disp("numero de condiciones de A: "+condi);

%operar
x= linsolve(A,Aaux);

disp("Sol. sistema 1")
disp("x1 = "+x(1))
disp("x2 = "+x(2))
disp("x3 = "+x(3))
disp("x4 = "+x(4))

b=zeros(10,4);
b(1,:)=[0.110 0 1 0];
b(2,:)=[0 3.260 0 1];
b(3,:)=[0.425 0 1 0];
b(4,:)=[0 3.574 0 1];
b(5,:)=[0.739 0 1 0];
b(6,:)=[0 3.888 0 1];
b(7,:)=[1.054 0 1 0];
b(8,:)=[0 4.202 0 1];
b(9,:)=[1.368 0 1 0];
b(10,:)=[0 4.516 0 1];

baux=  [317;237;319;239;321;241;323;243;325;245];

%operar
x = linsolve(b,baux);
disp("Sol. sistema 2")
disp("x1 = "+x(1))
disp("x2 = "+x(2))
disp("x3 = "+x(3))
disp("x4 = "+x(4))

%meter ruido

%saco las dimensiones
[filas,columnas] = size(b);
[filas2,columnas2]=size(baux);
%creo una matriz con valores aleatorios de la misma dimension
ruido = rand(filas,columnas)*1+0;
ruido2 = rand(filas2,columnas2)*1+0;
%le sumo el ruido
ruido_b=ruido+ b;
ruido_baux =ruido2+ baux;

%operar
x = linsolve(ruido_b,ruido_baux);
disp("Sol. sistema 2 con ruido")
disp("x1 = "+x(1))
disp("x2 = "+x(2))
disp("x3 = "+x(3))
disp("x4 = "+x(4))

