
[X,Y]  =  meshgrid(-5:0.1:5,-5:0.1:5);
Z = Y*sin(pi*(X/10))+5*cos((power(X,2)+power(Y,2))/8)+cos(X+Y)*cos(3*X-Y);
figure(1);
%parte de arriba
subplot(2,2,[1,2]);
surf(X,Y,Z);
title("grafica");
ylabel('Eje y');
xlabel('Eje x');
%parte de abajo
subplot(2,2,3);
surf(X,Y,Z);
title("grafica");
ylabel('Eje y');
xlabel('Eje x');
%parte de abajo
subplot(2,2,4);
contourf (X,Y,Z);
title("grafica");
ylabel('Eje y');
xlabel('Eje x');
colorbar
