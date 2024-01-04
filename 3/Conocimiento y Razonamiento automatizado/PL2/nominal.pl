:-['diccionario.pl'].
:-['comprobadores.pl'].
:-['verbal.pl'].


% ******************************** %
% Comprueba si el genero y el numero son correctos %
% ******************************** %
validacion_N(Numero_a_evaluar, Numero) -->
	{numero([Numero_a_evaluar, Numero])}.

validacion_G(Genero_a_evaluar, Genero) -->
	{genero([Genero_a_evaluar, Genero])}.

% ******************************** %
% Comprueba si el genero y el numero son correctos %
% ******************************** %


validacion_N(Numero_a_evaluar1, Numero_a_evaluar2, Numero) -->
	{numero([Numero_a_evaluar1, Numero, Numero_a_evaluar2])}.


validacion_G( Genero_a_evaluar1, Genero_a_evaluar2, Genero) -->
	{genero([Genero_a_evaluar1, Genero, Genero_a_evaluar2])}.

% ******************************** %
% Valida si el genero y el numero son correctos dentro de las frases de una conjuncion %
% ******************************** %
atribujos_en_conjuncion(Persona1, Persona2, Numero, Genero, Genero2 , PersonaTotal, GeneroTotal) --> 
	{Numero = p,
	(Genero == Genero2 -> GeneroTotal = Genero; GeneroTotal = m),
	(Persona1 == Persona2 -> PersonaTotal = Persona1 ; 
		(Persona1 == 1, Persona2 == 1 -> PersonaTotal = 1;
			(Persona1 == 2, Persona2 == 2 -> PersonaTotal = 2;
				(Persona1 == 3, Persona2 == 3 -> PersonaTotal = 3;
					PersonaTotal = -1
	))))}. 

% ******************************** %
% Nombre %
% ******************************** %
nominal(gn(Nombre), Persona, Numero, Genero) -->
	nombre(Nombre, Genero, Numero, Persona).

% ******************************** %
% Determinante + nombre %
% ******************************** %
nominal(gn(Determinante,Nombre), Persona, Numero, Genero) --> 
	determinante(Determinante, GeneroDeterminante, NumeroDeterminante),
	nombre(Nombre, Genero, Numero, Persona),
	validacion_G(GeneroDeterminante, Genero),
	validacion_N(NumeroDeterminante, Numero).

% ******************************** %
% Adjetivo + nombre %
% ******************************** %
nominal(gn(Adjetivo,Nombre), Persona, Numero, Genero) --> 
	frase_con_adjetivo(Adjetivo, GeneroAdjetivo, NumeroAdjetivo),
	nombre(Nombre, Genero, Numero, Persona),
	validacion_G(GeneroAdjetivo, Genero),
	validacion_N(NumeroAdjetivo, Numero).



% ******************************** %
% Nombre + adjetivo %
% ******************************** %
nominal(gn(Nombre,Adjetivo), Persona, Numero, Genero) --> 
	nombre(Nombre, Genero, Numero, Persona),
	frase_con_adjetivo(Adjetivo, GeneroAdjetivo, NumeroAdjetivo),
	validacion_G(GeneroAdjetivo, Genero),
	validacion_N(NumeroAdjetivo, Numero).
	

% ******************************** %
% Determinante + nombre + adjetivo %
% ******************************** %
nominal(gn(Determinante,Nombre, SAdv), Persona, Numero, Genero) --> 
	determinante(Determinante, GeneroDeterminante, NumeroDeterminante), 
	nombre(Nombre, Genero, Numero, Persona), 
	frase_con_adjetivo(SAdv,GeneroAdjetivo, NumeroAdjetivo),
	validacion_G(GeneroDeterminante,GeneroAdjetivo, Genero),
	validacion_N(NumeroDeterminante,NumeroAdjetivo, Numero).


% ******************************** %
% Determinante + adjetivo + nombre %
% ******************************** %
nominal(gn(Determinante,Adjetivo, Nombre), Persona, Numero, Genero) --> 
	determinante(Determinante, GeneroDeterminante, NumeroDeterminante),
	adjetivo(Adjetivo, GeneroAdjetivo, NumeroAdjetivo),
	nombre(Nombre, Genero, Numero, Persona),
	validacion_G(GeneroDeterminante,GeneroAdjetivo, Genero),
	validacion_N(NumeroDeterminante,NumeroAdjetivo, Numero).


% ******************************** %
% nombre + conjuncion + nombre %
% ******************************** %
nominal(gn(Nombre,Conjuncion,Nombre2), PersonaTotal, Numero, GeneroTotal) -->
	nombre(Nombre, Genero, _, Persona1),
	conjuncion(Conjuncion),
	nombre(Nombre2, Genero2, _, Persona2),
	atribujos_en_conjuncion(Persona1, Persona2, Numero, Genero, Genero2 , PersonaTotal, GeneroTotal). 


% ******************************** %
% nombre + preposicion %
% ******************************** %
nominal(gn(Nombre, SublistaNominal), Persona, Numero, Genero) --> 
	nombre(Nombre, Genero, Numero, Persona),
	frase_nominal_preposicion(SublistaNominal).



% ******************************** %
% Determinante + nombre + preposicion %
% ******************************** %
nominal(gn(Determinante,Nombre, SublistaNominal), Persona, Numero, Genero) --> 
	determinante(Determinante, GeneroDeterminante, NumeroDeterminante),
	nombre(Nombre, Genero, Numero, Persona),

	validacion_G(GeneroDeterminante, Genero),
	validacion_N(NumeroDeterminante, Numero),
	
	frase_nominal_preposicion(SublistaNominal).


% ******************************** %
% Determinante + nombre + adjetivo + preposicion %
% ******************************** %
nominal(gn(Determinante,Nombre, Adjetivo, SublistaNominal), Persona, Numero, Genero) --> 
	determinante(Determinante, GeneroDeterminante, NumeroDeterminante),
	nombre(Nombre, Genero, Numero, Persona),
	frase_con_adjetivo(Adjetivo, GeneroAdjetivo, NumeroAdjetivo),

	validacion_G(GeneroDeterminante,GeneroAdjetivo, Genero),
	validacion_N(NumeroDeterminante,NumeroAdjetivo, Numero),

	frase_nominal_preposicion(SublistaNominal).


% ******************************** %
% Determinante + adjetivo + nombre + preposicion %
% ******************************** %
nominal(gn(Determinante,Adjetivo, Nombre, SublistaNominal), Persona, Numero, Genero) --> 
	determinante(Determinante, GeneroDeterminante, NumeroDeterminante),
	frase_con_adjetivo(Adjetivo, GeneroAdjetivo, NumeroAdjetivo),
	nombre(Nombre, Genero, Numero, Persona),

	validacion_G(GeneroDeterminante,GeneroAdjetivo, Genero),
	validacion_N(NumeroDeterminante,NumeroAdjetivo, Numero),

	frase_nominal_preposicion(SublistaNominal).



% ******************************** %
% Determinante + nombre + conjuncion + determinante + nombre %
% ******************************** %
nominal(gn(Determinante,Nombre,Conjuncion,Determinante2,Nombre2), PersonaTotal, Numero, GeneroTotal) -->
	determinante(Determinante, GeneroDeterminante, NumeroDeterminante),
	nombre(Nombre, Genero, Numero, Persona1),
	validacion_G(GeneroDeterminante, Genero),
	validacion_N(NumeroDeterminante, Numero),

	conjuncion(Conjuncion),

	determinante(Determinante2, GeneroDeterminante2, NumeroDeterminante2),
	nombre(Nombre2, GeneroNombre2, NumeroNombre2, Persona2),
	validacion_G(GeneroDeterminante2, GeneroNombre2),
	validacion_N(NumeroDeterminante2, NumeroNombre2),

	atribujos_en_conjuncion(Persona1, Persona2, Numero, Genero, GeneroNombre2 , PersonaTotal, GeneroTotal).
	

% ******************************** %
% Determinante + nombre + conjuncion + determinante + nombre + adjetivo %
% ******************************** %
nominal(gn(Determinante,Nombre,Conjuncion,Determinante2,Nombre2,Adjetivo), PersonaTotal, Numero, GeneroTotal) -->
	determinante(Determinante, GeneroDeterminante, NumeroDeterminante),
	nombre(Nombre, Genero, Numero, Persona1),
	validacion_G(GeneroDeterminante, Genero),
	validacion_N(NumeroDeterminante, Numero),
	
	conjuncion(Conjuncion),

	determinante(Determinante2, GeneroDeterminante2, NumeroDeterminante2),
	nombre(Nombre2, GeneroNombre2, NumeroNombre2, Persona2),

	validacion_G(GeneroDeterminante2, GeneroNombre2),
	validacion_N(NumeroDeterminante2, NumeroNombre2),
	
	frase_con_adjetivo(Adjetivo, GeneroAdjetivo, NumeroAdjetivo),
	atribujos_en_conjuncion(Persona1, Persona2, Numero, Genero, GeneroNombre2 , PersonaTotal, GeneroTotal),

	validacion_G(GeneroTotal, GeneroAdjetivo),
	validacion_N(Numero, NumeroAdjetivo).


% ******************************** %
% Preposicion + nombre %
% ******************************** %
frase_nominal_preposicion(gp(Preposicion, SublistaNominal)) -->
	preposicion(Preposicion),
	nominal(SublistaNominal, _, _, _).



% ******************************** %
% oracion explicativa %
% ******************************** %
frase_nominal_coordinada_explicativa(SublistaNominal, Coma1, Nexo, SublistaVerbal, Coma2, PersN, Numero, GeneroN) -->
	nominal(SublistaNominal, PersN, Numero, GeneroN),
	coma(Coma1),
	nexo(Nexo),
	grupoVerbal(SublistaVerbal, PersV, NV, GeneroV),
	coma(Coma2),
	{igual_sujeto_verbo_Genero(PersN, PersV)},
	{igual_sujeto_verbo_Numero(Numero, NV)},
	{genero([GeneroN, GeneroV])}.


