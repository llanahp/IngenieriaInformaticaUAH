%Aproximación de funciones
clear all;
close all;

%Definimos vectores de entrada-salida
t = -3:.1:3;%tiempo
F=sinc(t)+.001*randn(size(t));%fun + ruido

plot(t,F,'+');
title('Vector de entrenamiento');
xlabel('Vector de entrada P');
ylabel('Vector target T');

%Definimos la red
hiddenLayerSize = 7;
net = fitnet(hiddenLayerSize, 'trainbfg');

%Divido los datos en conjuntos
net.divideParam.trainRatio = 70/100;
net.divideParam.valRatio = 15/100;
net.divideParam.testRatio = 15/100;

%Entreno la red
net = train(net, t, F);

Y = net(t);

%Muestro resultados
plot(t,F,'+');
hold on;
plot(t,Y,'-r');
hold off;
title('Vector de entrenamiento');
xlabel('Vector de entrada P');
ylabel('Vector target T');