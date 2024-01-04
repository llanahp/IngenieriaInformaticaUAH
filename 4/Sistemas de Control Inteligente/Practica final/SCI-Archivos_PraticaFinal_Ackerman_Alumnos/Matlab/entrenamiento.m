training_data = matfile('datos_entrenamiento.mat');

inputs = training_data(:,[1,12]);
outputs = training_data(:,[18,19]);%18 angulo, 19 velocidad
inputs(isinf(inputs)) = 5.0;
inputs = double(inputs);
outputs = double(outputs);

%[neuronas_capa1, neuronas_capa2,... ]
neuronas = 7;
net = feedforwardnet(7, 'trainbfg');
net = configure(net,inputs,outputs);

net.divideParam.trainRatio = 70/100;
net.divideParam.valRatio = 15/100;
net.divideParam.testRatio = 15/100;

net = train(net,inputs,outputs);

gensim(net,Ts)