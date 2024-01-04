

% Datos de entrada:
x = [0.1, 0.7, 0.8, 0.8, 1.0, 0.3, 0.0, -0.3, -0.5, -1.5, 0.0];
y = [1.2, 1.8, 1.6, 0.6, 0.8, 0.5, 0.2, 0.8, -1.5, -1.3, -1.5];

entrada = [x; y];

% Clasificación de los datos (en números binarios):
%
clases = [1 1 1 0 0 1 1 1 0 0 1;
          0 0 0 0 0 1 1 1 1 1 1];

% Entrenamiento
net = perceptron;
net = train(net, entrada, clases);

% Salida
plotpv(entrada, clases);
plotpc(net.iw{1, 1}, net.b{1});
