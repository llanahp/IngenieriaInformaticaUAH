
% *********************************************************************************************************** %
% Se tienen definidas todas las palabras que aparecen en las oraciones.
% Estan organizadas por el tipo de palabras y se asocian las caracteristicas pertienetes
% Por ejemplo en los verbos, la persona y el numero. En nos nombres el genero, el numero y persona. ...
% *********************************************************************************************************** %

%Verbos:
%Se definen todos los verbos de la oraciones indicando la persona y si es singular o plural
verbo(v(X),Persona,Numero) --> [X],{v(X,Persona,Numero)}, !.
v(lee, 3, s).
v(prefiere, 3, s).
v(bebe, 3, s).
v(escala, 3, s).
v(ama, 3, s).
v(come, 3, s).
v(comen, 3, p).
v(estudia, 3, s).
v(hace, 3, s).
v(canta, 3, s).
v(alzo, 3, s).
v(esta, 3, s).
v(es, 3, s).
v(era, 1, s).
v(era, 3, s).
v(habla, 3, s).
v(depende, 3, s).
v(vimos, 1, p).
v(recoge, 3, s).
v(toma, 3, s).
v(compre, 3, s).
v(beben, 3, p).
v(salta, 3, s).
v(sonrie, 3, s).
v(sirve, 3, s).
v(cazo, 3, s).
v(vive, 3, s).
v(blandieron, 3, p).
v(toca, 3, s).
v(son, 3, p).

% Nombres:
%Se definen todos los nombres de la oraciones indicando el genero (Masculino o Femenino), el numero (Singular o Plural) y la persona.
nombre(n(X), Gen, Num, Persona) --> [X],{n(X,Gen, Num, Persona)}.
n(jose, m, s, 3).
n(filosofia, m, s, 3).
n(derecho, m, s, 3).
n(periodico, m, s, 3).
n(paella, m, s, 3).
n(novela, f, s, 3).
n(zumo, m, s, 3).
n(rocodromo, m, s, 3).
n(tardes, f, p, 3).
n(vecino, m, s, 3).
n(hombre, m, s, 3).
n(mujer, f, s, 3).
n(gato, m, s, 3).
n(raton, m, s, 3).
n(ratones, m, p, 3).
n(alumno, m, s, 3).
n(alumna, f, s, 3).
n(manzana, f, s, 3).
n(manzanas, f, p, 3).
n(patatas, f, p, 3).
n(tenedor, m, s, 3).
n(cuchillo, m, s, 3).
n(juan, m, s, 3).
n(maria, f, s, 3).
n(el, m, s, 3).
n(ella, f, s, 3).
n(practica, f, s, 3).
n(canario, m, s, 3).
n(paloma, f, s, 3).
n(vuelo, m, s, 3).
n(madrid, _, s, 3).
n(reflejos, m, p, 3).
n(esperanza, f, s, 3).
n(vida, f, s, 3).
n(nino, m, s, 3).
n(lugar, m, s, 3).
n(universidad, f, s, 3).
n(nacimiento, m, s, 3).
n(profesor, m, s, 3).
n(mesa, f, s, 3).
n(cafe, m, s, 3).
n(pantalon, m, s, 3).
n(corbata, f, s, 3).
n(hector, m, s, 3).
n(cerveza, f, s, 3).
n(irene, f, s, 3).
n(procesador,m,s,3).
n(textos, m, p, 3).
n(herramienta, f, s, 3).
n(documentos, m, p, 3).
n(escribir, m, s, 3).
n(pablo, m, s, 3).
n(afueras, f, p, 3).
n(irene, f, s, 3).
n(mosqueteros, m, p, 3).
n(espadas, f, p, 3).
n(sara, f, s, 3).
n(sabado, m, s, 3).
n(coches, m, p, 3).
n(carreras, f, p, 3).
n(guitarra, f, s, 3).

% Determinantes:
%Se definen todos los determinantes de la oraciones indicando el genero (Masculino o Femenino), el numero (Singular o Plural).
determinante(det(X), Gen, Num) --> [X],{det(X, Gen, Num)}.
det(el, m, s).
det(la, f, s).
det(los, m, p).
det(un, m, s).
det(uno, m, s).
det(unos, m, p).
det(las, f, p).
det(una, f, s).
det(unas, f, p).
% Posesivos
det(mi, _, s).
det(tu, _, s).
det(su, _, _).
det(nuestro, m, p).
det(nuestra, f, p).
det(vuestro, m, p).
det(vuestra, f, p).

% Adjetivos:
%Se definen todos los Adjetivos de la oraciones indicando el genero (Masculino o Femenino), el numero (Singular o Plural).
adjetivo(adj(X), Gen, Num) --> [X], {adj(X, Gen, Num)}.
adj(agil, _, s).
adj(grande, _, s).
adj(roja, f, s).
adj(rojas, f, p).
adj(negro, m, s).
adj(negros, m, p).
adj(blanca, f, s).
adj(moreno, m, s).
adj(morena, f, s).
adj(alta, f, s).
adj(alto, m, s).
adj(delicado, m, s).
adj(fritas, f, p).
adj(alegre, _, s).
adj(potente, _, s).
adj(gris, m, s).
adj(rapido, m, s).
adj(rapidos, m, p).

% Preposiciones:
%Se definen todos las Preposiciones de la oraciones.
preposicion(prep(X)) --> [X],{prep(X)}.
prep(a).
prep(ante).
prep(bajo).
prep(cabe).
prep(con).
prep(contra).
prep(de).
prep(desde).
prep(en).
prep(entre).
prep(hacia).
prep(hasta).
prep(para).
prep(por).
prep(segun).
prep(sin).
prep(so).
prep(sobre).
prep(tras).
prep(durante).
prep(mediante).

% Conjunciones:
%Se definen todos las Conjunciones de la oraciones.
conjuncion(conj(X)) --> [X],{conj(X)}.
conj(y).
conj(que).
conj(e).
conj(o).
conj(u).

% Adverbios:
%Se definen todos los Adverbios de la oraciones.
adverbio(adv(X)) --> [X], {adv(X)}.
adv(ayer).

adv(muy).
adv(claramente).
adv(lejos).
adv(mucho).
adv(lento).
adv(solamente).
adv(bastante).

%Que, para formar ciertas frases especiales:
que(q(X)) --> [X], {q(X)}.
q(que).

% Nexos:
nexo(nx(X)) --> [X], {nx(X)}.
nx(y).
nx(pero).
nx(que).
nx(mientras).
nx(aunque).
nx(e).

% Coma:
coma(com(X)) --> [X],{com(X)}.
com(',').
