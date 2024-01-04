%Ejemplo: [[-1+i, -1-i, -3], 1, 2]=raíces([1 2 2], [1 3])
function  [solucion, reales, complejas]=raices(poli_1, poli_2)
    reales=0;
    complejas=0;
    %multiplico los 2 polinomios
    prod_poli = conv(poli_1,poli_2);
    %pedir datos
    entrada =input("¿la solución se aplica a uno de los polinomios o al producto? (poli_1/poli_2/prod_poli)->",'s');
    
    if entrada == "poli_1"
        %saco las raices
        solucion = roots(poli_1);
    elseif entrada == "poli_2"
        %saco las raices
        solucion = roots(poli_2);
    elseif entrada == "prod_poli"
        %saco las raices
        solucion = roots(prod_poli);
    end
    %saco cuantos reales y complejas de la seleccionada
    for i= 1:length(solucion)
        %miro si es real el actual
        if isreal(solucion(i))
            reales=reales+1;
        else
           %si no es real, es commpleja y sumo
           complejas=complejas+1;
        end
    end
    %Representación en el plano
    figure(1);
    plot(solucion);
    title("grafica");
    ylabel('Eje y');
    xlabel('Eje x');
    plot(maximo,'O');
    hold on
    for a=1:length(solucion)
        plot(solucion(a),'X');
    end
    hold off
end