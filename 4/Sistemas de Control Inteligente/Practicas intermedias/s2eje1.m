syms k a z;
%1.-
%Declaro la funcion
fun=(2 + 5*k + k^2);
%Calculo su transformada
fun_trans = ztrans(fun, k);
%Represento graficamente
figure(1);
subplot(4,1,1);
hold on;
%Dibujo las graficas con distintos colores
fplot(fun,'color', 'b');
fplot(fun_trans,'color', 'r');  
hold off;

%2.-
%Calculo las funciones
fun2=(sin(k) * exp(-a*k));
fun2_trans = ztrans(fun2, k, a);
%Dibujar la gráfica
subplot(4,1,2);
hold on;
ezplot(fun2);
ezplot(fun2_trans);
hold off;


%3.-
%creo la función de transferencia
%ft([1 0 0.4], [1 -1 0.1 0.02], 0.5);
fun_t = tf([1 0 0.4], [1 -1 0.1 0.02], 0.5);
subplot(4,1,3);
hold on;
impulse(fun_t);
hold off;

%Escalón
subplot(4,1,4);
hold on;
step(fun_t);
hold off;


