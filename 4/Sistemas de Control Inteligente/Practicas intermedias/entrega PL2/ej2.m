% Carga de datos de ejemplo disponibles en la toolbox
[inputs, targets] = cancer_dataset;

% Creción de una red neuronal para el reconocimiento de patrones
hiddenLayerSize = 10;
net = patternnet(hiddenLayerSize, 'trainbfg');

% División del conjunto de datos para entrenamiento, validación y test
net.divideParam.trainRatio = 80/100;
net.divideParam.valRatio = 10/100;
net.divideParam.testRatio = 10/100;

media = 0;
for i = 1 : 10

    % Entrenamiento de la red
    [net, tr] = train(net, inputs, targets);
    
    % Prueba
    outputs = net(inputs);
    errors = gsubtract(targets, outputs);
    media = media + perform(net, targets, outputs);
end
media = media / 10;

% Visualización
performance = media
view(net)
