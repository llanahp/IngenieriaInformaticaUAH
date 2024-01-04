
% Sensores 0 - 11
inputs = transpose(training_data(:, [1:12]));
inputs(isinf(inputs)) = 5.0;
% Velocidad y ángulo del volante
outputs = transpose(training_data(:, [18, 19]));

net = feedforwardnet([7], 'trainbfg');
net.trainParam.epochs = 5000;
net.trainParam.goal = 0.01;
net = configure(net, inputs, outputs);
net = train(net, inputs, outputs);

gensim(net, 0.1);
