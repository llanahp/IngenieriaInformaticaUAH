:-['diccionario.pl'].
:-['comprobadores.pl'].


% ******************************** %
% Advervio %
% ******************************** %
frase_con_adverbio(gadv(Adv)) -->
    adverbio(Adv).

% ******************************** %
% Advervio1 + Advervio2 %
% ******************************** %
frase_con_adverbio(gadv(Adv, Adv2)) -->
    adverbio(Adv),
    adverbio(Adv2).

% ******************************** %
% Advervio + nominal compuesta de preposicion %
% ******************************** %
frase_con_adverbio(gadv(Adv, ParteNominal)) -->
    adverbio(Adv),
    frase_nominal_preposicion(ParteNominal).

% ******************************** %
% Advervio1 + Advervio2 + nominal compuesta de preposicion %
% ******************************** %
frase_con_adverbio(gadv(Adv, Adv2, ParteNominal)) -->
    adverbio(Adv),
    adverbio(Adv2),
    frase_nominal_preposicion(ParteNominal).


% ******************************** %
% Advervio + frase nominal %
% ******************************** %
frase_con_adverbio(gadv(Adv, ParteNominal)) -->
    adverbio(Adv),
    nominal(ParteNominal,_,_,_).



% ******************************** %
% Adjetivo %
% ******************************** %
frase_con_adjetivo(gadj(Adj), GA, NA) -->
    adjetivo(Adj, GA, NA).

% ******************************** %
% Advervio + Adjetivo2 %
% ******************************** %
frase_con_adjetivo(gadj(Adv, Adj), GA, NA) -->
    adverbio(Adv),
    adjetivo(Adj, GA, NA).
