%cargo los datos
[inputs,targets] = simplefit_dataset;

%creo la red
hiddenLayerSize = 10;
net = fitnet(hiddenLayerSize, 'trainlm');

% División del conjunto de datos para entrenamiento, validación y test
net.divideParam.trainRatio = 40/100;
net.divideParam.valRatio = 30/100;
net.divideParam.testRatio = 30/100;

% Entrenamiento de la red
[net,tr] = train(net,inputs,targets);

% Prueba
outputs = net(inputs);
errors = gsubtract(outputs,targets);
performance = perform(net,targets,outputs)

% Visualización de la red
%view(net)