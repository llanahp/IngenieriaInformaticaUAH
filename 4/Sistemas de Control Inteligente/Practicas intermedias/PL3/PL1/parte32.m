clear all; close all;
% Inicializamos las variables necesarias para el sistema
Ts = 0.1;
%inicializazmos las variables de la simulacion
x_0 = 0;
y_0 = 0;
th_0 = 0;
% Hacemos la simulacion
sim('PositionControlFuzzy.slx');
% Guardamos los valores devueltos por la simulacion
trayectoria_x = salida_xref.signals.values';
trayectoria_y = salida_yref.signals.values';
%guardamos los valores de salida
x = salida_x.signals.values';
y = salida_y.signals.values';
% Pintamos ambas trayectorias en un figure
figure(1);
hold on;
%añadimos las trayectorias a la grafica
tray_original = plot(trayectoria_x, trayectoria_y);
tray_robot = plot(x, y);
hold off;
grid on;
%incluimos las leyendas a la grafica
legend([tray_original tray_robot], {'Trayectoria generada', 'Trayectoria robot'});
title('Comparativa de las trayectorias');
