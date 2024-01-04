:-['draw.pl'].
:-['diccionario.pl'].

% ******************************** %
% Verificar si el genero concuerda %
% ******************************** %
genero([Genero1, Genero2|Tail_Genero]):-
    igual_genero(Genero1, Genero2),  
    genero([Genero2|Tail_Genero]).    

genero([_|[]]).
% ******************************** %
% Valido si los generos son iguales %
% ******************************** %
igual_genero(Genero1, Genero2):-Genero1=Genero2.
igual_genero(Genero1, Genero2):-Genero1\=Genero2,writeln('El genero no es el mismo.'), fail.


% ******************************** %
% Verificar si el numero concuerda %
% ******************************** %
numero([Numero1, Numero2|Tail_Numero]):-
    igual_numero(Numero1, Numero2),  
    numero([Numero2|Tail_Numero]).  

numero([_|[]]).

% ******************************** %
% Valido si los numeros son iguales %
% ******************************** %
igual_numero(Numero1, Numero2):-Numero1=Numero2.
igual_numero(Numero1, Numero2):-Numero1\=Numero2,writeln('El numero no es el mismo.'), fail.


% ******************************** %
% Verificar si el genero de verbos y sujeto concuerda %
% ******************************** %
igual_sujeto_verbo_Genero(Persona_Numero, Persona_Verbo):-Persona_Numero=Persona_Verbo.
igual_sujeto_verbo_Genero(Persona_Numero, Persona_Verbo):-Persona_Numero\=Persona_Verbo, fail.


% ******************************** %
% Verificar si el numero de verbos y sujeto concuerda %
% ******************************** %
igual_sujeto_verbo_Numero(Numero_Sujeto, Numero_Verbo):-Numero_Sujeto=Numero_Verbo.
igual_sujeto_verbo_Numero(Numero_Sujeto, Numero_Verbo):-Numero_Sujeto\=Numero_Verbo, fail.


% ******************************** %
% Devuelve el numero de verbos de la frase %
% ******************************** %
numero_de_verbos(Frase, Verbos):- numero_verbos_aux(Frase, [],Verbos).

% ******************************** %
%   Añade verbos a una lista       %
% ******************************** %
numero_verbos_aux([Cabeza|Tail], ListaVerbos,Verbos):-
    v(Cabeza,_,_) -> 
    numero_verbos_aux(Tail, [Cabeza|ListaVerbos], Verbos);
    numero_verbos_aux(Tail, ListaVerbos, Verbos).

% ******************************** %
%   Devuelve la lista de verbos   %
% ******************************** %
numero_verbos_aux([], V,V). 

% ******************************** %
%   Numero de comas en una frase   %
% ******************************** %
comas(Frase, Comas):- comas_aux(Frase, [], Comas).

% ******************************** %
%   Añade comas a una lista        %
% ******************************** %
comas_aux([Cabeza|Tail], ListaComas, Comas):-
    com(Cabeza) ->
        comas_aux(Tail, [Cabeza|ListaComas], Comas);
        comas_aux(Tail, ListaComas, Comas).

% ******************************** %
%   Devuelve la lista de comas     %
% ******************************** %
comas_aux([],C,C).