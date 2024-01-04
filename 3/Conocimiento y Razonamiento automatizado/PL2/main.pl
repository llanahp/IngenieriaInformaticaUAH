:-['draw.pl'].
:-['masTiposdeFrases.pl'].
:-['verbal.pl'].
:-['nominal.pl'].
:-['diccionario.pl'].
:-['traductor.pl'].


analiza(Oracion) :-
	split_string(Oracion, " ", "", _),
	oracion(LR, _, []), draw(LR).


% metodo principal
% traducimos la oracion, clasificamos la oracion y ejecutamos el tipo de oracion
oracion(ListaResuelta, Oracion, ListaSobras) :-
	traductor(Oracion),
	clasificar_oracion(Oracion, TipoOracion),
	ejecutar_tipo_oracion(TipoOracion, ListaResuelta, Oracion, ListaSobras).

% metodo para clasificar la oracion segun el numero de verbos y comas
clasificar_oracion(Oracion, TipoOracion) :-
    % obtenemos el numero de verbos
	numero_de_verbos(Oracion, ListaVerbos),
	length(ListaVerbos, NumVerbos),
    % obtenemos el numero de comas
	comas(Oracion, ListaComas),
	length(ListaComas, NumComas),
    % clasificamos la oracion
	clasificar_tipo_oracion(NumVerbos, NumComas, TipoOracion).

% conjunto de tipos de oraciones en las que podemos clasificar
clasificar_tipo_oracion(0, _, oracion_zero).
clasificar_tipo_oracion(1, _, oracion_uno).
clasificar_tipo_oracion(2, 0, oracion_dos).
clasificar_tipo_oracion(2, 1, oracion_tres).
clasificar_tipo_oracion(2, 2, oracion_explicativa).
clasificar_tipo_oracion(3, _, oracion_cuatro).
clasificar_tipo_oracion(4, 2, oracion_cinco).
clasificar_tipo_oracion(5, 1, oracion_seis).
% tipo por defecto
clasificar_tipo_oracion(_, _, oracion_invalida).

% Los siguientes metodos son para ejecutar el tipo de oracion segun su clasificacion
ejecutar_tipo_oracion(oracion_zero, ListaResuelta, Oracion, ListaSobras) :-
    oracion_zero(ListaResuelta, Oracion, ListaSobras).
ejecutar_tipo_oracion(oracion_uno, ListaResuelta, Oracion, ListaSobras) :-
    oracion_uno(ListaResuelta, Oracion, ListaSobras).
ejecutar_tipo_oracion(oracion_tres, ListaResuelta, Oracion, ListaSobras) :-
    oracion_tres(ListaResuelta, Oracion, ListaSobras).
ejecutar_tipo_oracion(oracion_dos, ListaResuelta, Oracion, ListaSobras) :-
    oracion_dos(ListaResuelta, Oracion, ListaSobras).
ejecutar_tipo_oracion(oracion_explicativa, ListaResuelta, Oracion, ListaSobras) :-
    oracion_explicativa(ListaResuelta, Oracion, ListaSobras).
ejecutar_tipo_oracion(oracion_cuatro, ListaResuelta, Oracion, ListaSobras) :-
    oracion_cuatro(ListaResuelta, Oracion, ListaSobras).
ejecutar_tipo_oracion(oracion_cinco, ListaResuelta, Oracion, ListaSobras) :-
    oracion_cinco(ListaResuelta, Oracion, ListaSobras).
ejecutar_tipo_oracion(oracion_seis, ListaResuelta, Oracion, ListaSobras) :-
    oracion_seis(ListaResuelta, Oracion, ListaSobras).
ejecutar_tipo_oracion(oracion_siete, ListaResuelta, Oracion, ListaSobras) :-
    oracion_siete(ListaResuelta, Oracion, ListaSobras).

% tipo por defecto
ejecutar_tipo_oracion(oracion_invalida, _, _, _) :-
    writeln('Oracion no valida para su analisis'), fail.

% En caso de tener una frase clasificada con 0 verbos, solo se analiza la frase nominal
oracion_zero(oracion(SublistaNominal)) --> 
    nominal(SublistaNominal,_,_,_).

% En caso de tener una frase clasificada con 1 verbo, solo se analiza la frase verbal
oracion_uno(oracion(SublistaVerbal)) -->
    grupoVerbal(SublistaVerbal,_,_,_).

% En caso de tener una frase clasificada con 2 verbos, se analiza la frase nominal y la frase verbal
oracion_uno(oracion(SublistaNominal, SublistaVerbal)) --> 
    nominal(SublistaNominal, PersonaN, NumeroN, GeneroN),
    grupoVerbal(SublistaVerbal, PersonaV, NumeroV, GeneroV),
    {igual_sujeto_verbo_Genero(PersonaN, PersonaV),
    igual_sujeto_verbo_Numero(NumeroN, NumeroV),
    genero([GeneroN, GeneroV])}.

% En caso de tener un frase subordinada
oracion_dos(oracion_subordinada(Oracion1, subor(Oracion2))) -->
    oracion_uno(Oracion1),
    oracion_uno(Oracion2).

%  En caso de tener una oracion compuesta con un nexo
oracion_dos(oracion_compuesta(oracion1(Oracion1), nexo(Nx), oracion2(Oracion2))) -->
    oracion_uno(Oracion1),
    nexo(Nx),
    oracion_uno(Oracion2).

% En caso de tener una frase compuesta por 2 nexos
oracion_cuatro(oracion_compuesta(oracion1(Oracion1), nexo(Nx1), oracion2(Oracion2), nexo(Nx2), oracion3(Oracion3))) -->
    oracion_uno(Oracion1),
    nexo(Nx1),
    oracion_uno(Oracion2),
    nexo(Nx2),
    oracion_uno(Oracion3).

% % En caso de tener una frase explicativa
oracion_explicativa(oc(gn(SublistaNominal, Coma1, Nexo, SublistaVerbal1, Coma2),gv(SublistaVerbal2)))-->
    frase_nominal_coordinada_explicativa(SublistaNominal, Coma1, Nexo, SublistaVerbal1, Coma2, PersonaN, NumeroN, GeneroN),
    grupoVerbal(SublistaVerbal2, PersonaV, NumeroV, GeneroV),
    {igual_sujeto_verbo_Genero(PersonaN, PersonaV),
    igual_sujeto_verbo_Numero(NumeroN, NumeroV),
    genero([GeneroN, GeneroV])}.


% En caso de tener una frase compuesta por una coma seguida de un nexo
oracion_tres(oracion_compuesta(oracion1(Oracion1),coma(Coma1), nexo(Nx), oracion2(Oracion2)))-->
    oracion_uno(Oracion1),
    coma(Coma1),
    nexo(Nx),
    oracion_uno(Oracion2).

% En caso de tener una frase compuesta por 2 comas seguidas de un nexo
oracion_cinco(oracion_compuesta(oracion1(Oracion1),coma(Coma1), nexo(Nx), oracion2(Oracion2),coma(Coma2), nexo(Nx2), oracion3(Oracion3), nexo(Nx3), oracion4(Oracion4)))-->
    oracion_uno(Oracion1),
    coma(Coma1),
    nexo(Nx),
    oracion_uno(Oracion2),
    coma(Coma2), 
    nexo(Nx2),
    oracion_uno(Oracion3),
    nexo(Nx3), 
    oracion_uno(Oracion4).



% En caso de tener una frase compuesta por varios nexos
oracion_seis(oracion_compuesta(oracion1(Oracion1),nexo(Nx), oracion2(Oracion2), nexo(Nx2), oracion3(Oracion3), nexo(Nx3), oracion4(Oracion4), coma(Coma1), nexo(Nx4),oracion5(Oracion5)))-->
    oracion_uno(Oracion1),
    nexo(Nx),
    oracion_uno(Oracion2),
    nexo(Nx2),
    oracion_uno(Oracion3),
    nexo(Nx3),
    oracion_uno(Oracion4),
    coma(Coma1),
    nexo(Nx4),
    oracion_uno(Oracion5).


% --== Oraciones de Prueba ==--
%21- oracion(X, [jose, es, moreno, y, maria, es, alta], []), draw(X).
%22- oracion(X, [jose, estudia, filosofia, ',',pero, maria, estudia, derecho], []), draw(X).
%23- oracion(X, [maria, toma, un, cafe, mientras, jose, recoge, la, mesa], []), draw(X).
%24- oracion(X, [jose, toma, cafe, y, lee, el, periodico], []), draw(X).
%25- oracion(X, [jose, y, hector, comen, patatas, fritas, y, beben, cerveza], []), draw(X).
%26- oracion(X, [jose, come, patatas, fritas, ',' , pero, maria, prefiere, paella, ',' ,aunque, hector, toma, cafe, e, irene, lee, una, novela], []), draw(X).
%27- oracion(X, [irene, canta, y, salta, mientras, jose, estudia], []), draw(X).
%28- oracion(X, [hector, come, patatas, fritas, y, bebe, zumo, mientras, jose, canta, y, salta, ',' , aunque, maria, lee, una, novela], []), draw(X).
%29- oracion(X, [jose, ',', que, es, agil, ',', escala, en, el, rocodromo, por, las, tardes], []), draw(X).
%30- oracion(X, [juan, ',', que, es, muy, delicado, ',', come, solamente, manzanas, rojas], []), draw(X).
%31- oracion(X, [el, procesador, de, textos, ',', que, es, una, herramienta, muy, potente, ',', sirve, para, escribir, documentos], []), draw(X).
%32- oracion(X, [el, procesador, de, textos, es, una, herramienta, muy, potente, que, sirve, para, escribir, documentos, pero, es, bastante, lento], []), draw(X).
%33- oracion(X, [el, raton, que, cazo, el, gato, era, gris], []), draw(X).
%34- oracion(X, [el, hombre, que, vimos, ayer, era, mi, vecino], []), draw(X).

% --== Oraciones Extra ==--
% oracion(X, [pablo, vive, en, las, afueras, de, madrid], []), draw(X).
% oracion(X, [pablo, vive, en, madrid], []), draw(X).
% oracion(X, [irene, es, alta, y, juan, es, rapido], []), draw(X).
% oracion(X, [los, mosqueteros, blandieron, las, espadas], []), draw(X).
% oracion(X, [sara, canta, el, sabado], []), draw(X).
% oracion(X, [los, coches, de, carreras, son, muy, rapidos], []), draw(X).
% oracion(X, [sara, toca, la, guitarra], []), draw(X).  