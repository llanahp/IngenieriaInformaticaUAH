clear all; close all;
%Tiempo de muestreo
Ts=100e-3 

% N numero de ejecuciones
N = 5
array_errores_x = [];
array_errores_y = [];

for i=1:N
    % Valores aleatorios de refx/refy
    refx=10*rand-5;
    refy=10*rand-5;
     % Simulación
    sim('PositionControl.slx')
    %valores salida
    x=salida_x.signals.values;
    y=salida_y.signals.values;
    %figuras
    figure(i);
    plot(x,y);
    grid on;
    hold on;
    
end