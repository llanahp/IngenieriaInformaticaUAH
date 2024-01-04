% ------------------------ Verifica si una lista contiene el valor ------------------------

contiene([], _):-false.
contiene([Head|Tail], Valor):-
	(Head =:= Valor -> true;contiene(Tail, Valor)).
contiene([Head|Tail], Valor, Numero):-
	(Head =:= Valor -> true;Numero is Head,contiene(Tail, Valor, Numero)).


% ------------------------------------------------

% ------------------------ Verifico si los dos sudokus son iguales ------------------------
sudokus_iguales([], []).
sudokus_iguales([H1|T1], [H2|T2]) :- H1 = H2, sudokus_iguales(T1, T2).
% ------------------------------------------------

% ------------------------ Igual 2 listas  ------------------------
igual([], []).
igual([H1|T1], [H2|T2]) :- H1 =:= H2, igual(T1, T2).
% ------------------------------------------------


% ------------------------ Reemplazar valor en una posi de una lista  ------------------------
replace([_|T], 0, X, [X|T]).
replace([H|T], I, X, [H|R]):- I > 0, NI is I-1, replace(T, NI, X, R).
% ------------------------------------------------


% ------------------------ Longitud de una lista  ------------------------
longitud([], 0).
longitud(X, L) :-
	 X == '.',        % si el elemento actual no es un punto
	L is 0.
longitud(N, 1) :-
	number(N).
longitud([X|_], L) :-
	X == '.',        % si el elemento actual no es un punto
	L is 0.
longitud([_ | Cola], N) :-
	longitud(Cola, N1),
	N is N1 + 1.
% ------------------------------------------------

% ------------------------ Mostrar el sudoku por pantalla  ------------------------
mostrar_sudoku([X|Tail]):-
	write("                 Sudoku                   "),nl,
	write("=========================================="),nl,write("|| "),
	mostrar_sudoku([X|Tail], 0),
	nl,
	write("=========================================="),
	nl.
mostrar_sudoku([], _).
mostrar_sudoku([X|Tail], Count) :-
	NewCount is Count + 1,
	(NewCount mod 3 =:= 0 ->
		write(" "),write(X), write(" ||")
		; 
		write(" "),write(X), write(" |")),
	(NewCount mod 9 =:= 0 , Tail \== [] ->
		nl,
		% si es multiplo de 3, escribo una linea mas
		(NewCount mod 27 =:= 0 ->
			write("==========================================")
			;
			write("------------------------------------------")),
			nl,
			write("|| ")
		;
		true),
	mostrar_sudoku(Tail, NewCount).
% ------------------------------------------------

% ------------------------ Combinar 2 listas  ------------------------
interseccion(Lista1, Lista2, Interseccion) :-
	 longitud(Lista2,Lon),
	 (Lon =:= 1 -> Interseccion = Lista2;
	 intersection(Lista1, Lista2, Interseccion)).
% ------------------------------------------------

% ------------------------ Posibles numeros mirando su Columna  ------------------------
% Introducimos la posicion(F, C), el sudoku S y la lista con los valores de la columna
get_numbers_in_column(C, S, Column) :-
	findall(X, (nth0(I, S, X), I mod 9 =:= C), Column).
get_possible_numbers_in_column(S, N, Posibles, Result):-
	%calculamos de que coordenada se trata introduciendo N. N = coordenada que queremos chequear
	C is mod(N - 1, 9), %columna 1
	%obtenemos la lista de numeros que se encuentran en la columna de la coordenada a chequear
	get_numbers_in_column(C, S, Column),
	Nr is N - 1,
	nth0(Nr, S, A),
	longitud(A,Lon),
	(Lon =:= 1 -> Result = A;
	%Filtramos los numeros que se encuentran en la columna
	numeros_usados(Column,[], UsedNumbers),
	% Filtramos los números que quedan posibles para la celda (F, C)
	exclude(not_member, Posibles, UnusedNumbers),
	% Retornamos la lista de números posibles para la celda mirando solo los elementos de su fila
	subtract(UnusedNumbers, UsedNumbers, Result)
	).
% ------------------------------------------------


% ------------------------ Posibles numeros mirando su Fila  ------------------------
% Definimos un predicado que verifica si un número N no está en una lista de números L
not_member(X) :- member(X, ['.', '-', ' ', '', '\n']).
numeros_usados([],Result, Res):-
	Res = Result.
numeros_usados([Head|Tail],Result, Res):-
	longitud(Head,Lon),
	(Lon =:= 1 ->
		append(Result, [Head], L3),
		numeros_usados(Tail, L3, Res)
	;
 		numeros_usados(Tail,Result, Res)).
% Definimos un predicado que dado una posición (F, C) y una lista que representa un sudoku S, retorna la lista de números que ya se encuentran en la fila F del sudoku
get_numbers_in_row(F, _, S, Row) :-
	% Calculamos el índice de la primera celda de la fila F
	Start is (F - 1) * 9 + 1,
	End is F * 9,
	% Obtenemos los elementos correspondientes a la fila F
	findall(X, (between(Start, End, Index), nth1(Index, S, X)), Row).

% Definimos un predicado que dado una posición (F, C) y una lista que representa un sudoku S,
%  retorna la lista de números que se pueden poner en la celda (F, C) mirando solo los elementos de su fila
get_possible_numbers_in_row(S, N,  PossibleNumbers) :-
	F is div(N - 1, 9) + 1,
	C is mod(N - 1, 9) + 1,
	% Obtenemos la lista de números que ya se encuentran en la fila F del sudoku
	get_numbers_in_row(F, C, S, Row),
	Nr is N - 1,
	nth0(Nr, S, A),
	longitud(A,Lon),
	(Lon =:= 1 -> PossibleNumbers = A;
	% Obtenemos la lista de todos los números posibles para el sudoku (1 a 9)
	numlist(1, 9, AllNumbers),
	% Filtramos los números que ya se encuentran en la fila F
	numeros_usados(Row,[], UsedNumbers),
	% Filtramos los números que quedan posibles para la celda (F, C)
	exclude(not_member, AllNumbers, UnusedNumbers),
	% Retornamos la lista de números posibles para la celda mirando solo los elementos de su fila
	subtract(UnusedNumbers, UsedNumbers, PossibleNumbers)).
% ------------------------------------------------

% ------------------------ Posibles numeros mirando Cuadrado --------------------
% Definimos un predicado que dado una posición absoluta nos devuelva el cuadrado al que pertenece
% cuadrado( A, B). B es posicion del cuadrado A
cuadrado(1,0). cuadrado(1,1). cuadrado(1,2). cuadrado(1,9). cuadrado(1,10). cuadrado(1,11). cuadrado(1,18). cuadrado(1,19). cuadrado(1,20).
cuadrado(2,3). cuadrado(2,4). cuadrado(2,5). cuadrado(2,12). cuadrado(2,13). cuadrado(2,14). cuadrado(2,21). cuadrado(2,22). cuadrado(2,23).
cuadrado(3,6). cuadrado(3,7). cuadrado(3,8). cuadrado(3,15). cuadrado(3,16). cuadrado(3,17). cuadrado(3,24). cuadrado(3,25). cuadrado(3,26).
cuadrado(4,27). cuadrado(4,28). cuadrado(4,29). cuadrado(4,36). cuadrado(4,37). cuadrado(4,38). cuadrado(4,45). cuadrado(4,46). cuadrado(4,47).
cuadrado(5,30). cuadrado(5,31). cuadrado(5,32). cuadrado(5,39). cuadrado(5,40). cuadrado(5,41). cuadrado(5,48). cuadrado(5,49). cuadrado(5,50).
cuadrado(6,33). cuadrado(6,34). cuadrado(6,35). cuadrado(6,42). cuadrado(6,43). cuadrado(6,44). cuadrado(6,51). cuadrado(6,52). cuadrado(6,53).
cuadrado(7,54). cuadrado(7,55). cuadrado(7,56). cuadrado(7,63). cuadrado(7,64). cuadrado(7,65). cuadrado(7,72). cuadrado(7,73). cuadrado(7,74).
cuadrado(8,57). cuadrado(8,58). cuadrado(8,59). cuadrado(8,66). cuadrado(8,67). cuadrado(8,68). cuadrado(8,75). cuadrado(8,76). cuadrado(8,77).
cuadrado(9,60). cuadrado(9,61). cuadrado(9,62). cuadrado(9,69). cuadrado(9,70). cuadrado(9,71). cuadrado(9,78). cuadrado(9,79). cuadrado(9,80). 

/**
 * casillasCuadrado
 * @param Cuadrado: entero del 1 al 9
 * @param Lista: lista con las posiciones del cuadrado
 * Permite retornar una lista con las posiciones del cuadrado indicado
 */
casillasCuadrado(Cuadrado, Lista):- findall( X, cuadrado(Cuadrado, X), Lista).

/**
 * posibilidadesCuadrado
 * @param Sudoku: lista que representa un sudoku
 * @param Posicion: entero que representa una posicion del sudoku
 * @param Posibilidades: lista con las posibilidades de esa posicion teniendo en cuenta el cuadrado o el valor de la posicion si ya esta definido
 * Retorna las posibilidades de una posicion teniendo en cuenta el caudrado donde se encuentre, para ello comprobamos que no es un numero ya definido
 * y llamamos a descartar para ver que valores son posibles
 */
posibilidadesCuadrado(Sudoku, Posicion, Posibilidades):- 
	%Obtenemos el valor de la posicion
	nth0(Posicion, Sudoku, Valor),
	%Si el valor es un punto, es decir, no esta definido, entonces obtenemos los valores del cuadrado y los descartamos con los valores ya usados
	(Valor = '.' -> 
		(cuadrado(A, Posicion),
		valoresCuadrado(Sudoku, A, Lista),
		%Descartamos los valores ya usados
		once(descartar(Lista, [1,2,3,4,5,6,7,8,9], Posibilidades)))
	;
		longitud(Valor,Lon),
		(Lon > 1 ->
			(cuadrado(A, Posicion),
			valoresCuadrado(Sudoku, A, Lista),
			%Descartamos los valores ya usados
			once(descartar(Lista, [1,2,3,4,5,6,7,8,9], Posibilidades)))
			;
			%Si el valor esta definido, entonces retornamos la lista con el valor
			Posibilidades = Valor
		)
	).

/**
 * descartar
 * @param Lista1
 * @param Lista2
 * @param Lista
 * Permite retornar una lista que es la interseccion de Lista1 y Lista2
 */
descartar([], L, L).
%Descartamos los valores ya usados
descartar([H|T], L, R) :-
	member(H, L),
	select(H, L, Temp),
	descartar(T, Temp, R).
%Si el valor no esta en la lista, lo descartamos
descartar([H|T], L, [H|R]) :-
	\+ member(H, L),
	descartar(T, L, R).

/**
 * valoresCuadrado
 * @param Sudoku: lista que representa un sudoku
 * @param Cuadrado: entero que representa un cuadrado del 1 al 9
 * @param Lista: lista
 * Permite retornar una lista con los valores de las posiciones del cuadrado indicado
 */
valoresCuadrado(Sudoku, Cuadrado, Lista):- 
	%Obtenemos las posiciones del cuadrado
	findall(Valor, (cuadrado(Cuadrado, X),
	%Obtenemos el valor de la posicion
	nth0(X, Sudoku, Valor),
	%Si el valor es un punto, es decir, no esta definido, entonces lo descartamos
	Valor \== '.'),
	Lista2),
	numeros_usados(Lista2,[], Lista).
% -------------------------------------------------------------------------------

% ------------------------ Crear lista con todas las posibilidades  ------------------------
posibilidades_celda(Original, Count, Res):-
	Nr is Count - 1,
	%obtenemos las posibilidades de la fila
	get_possible_numbers_in_row(Original, Count, PosibleR),
	%obtenemos las posibilidades de la columna
	get_possible_numbers_in_column(Original,Count,PosibleR,Posibles),
	%obtenemos las posibilidades del cuadrado
	posibilidadesCuadrado(Original,Nr,Posibilidades_cuadrado),
	%obtenemos la interseccion de las posibilidades
	interseccion(Posibilidades_cuadrado,Posibles,Res).


insert_posible_aux(Original,  Resultado):-insert_posible_aux(Original, [], 1, Resultado).

insert_posible_aux(Original, S_aux, Count, PossiblesList):-
	% Si el contador es 82, significa que hemos recorrido toda la lista
  (Count =:= 82 -> PossiblesList = S_aux;
	% Obtenemos la lista de posibles numeros para la celda
 	posibilidades_celda(Original, Count, Posibles_R),
	NewCount is Count + 1,
	% Añadimos la lista de posibles numeros a la lista auxiliar
	append(S_aux, [Posibles_R], L3),
	% Llamada recursiva
	insert_posible_aux(Original, L3, NewCount, PossiblesList)
  ).
% ------------------------------------------------

% ------------------------ Regla 0  ------------------------
/**
 * regla_0
 * @param lista: lista original
 * @param Resultado: lista con los valores que se han podido deducir
 */
regla_0(Lista,Resultado):-regla_0_aux(Lista, [], 1, Resultado).

/**
 * regla_0_aux
 * @param Original: lista original
 * @param S_aux: lista auxiliar
 * @param Count: Contador
 * @param PossiblesList: lista con los valores que se han podido deducir
 */
regla_0_aux(Original, S_aux, Count, PossiblesList):-
  (Count =:= 82 -> PossiblesList = S_aux;
	 Nr is Count - 1,
	 %obtener posibles
	 nth0(Nr, Original, Posibles),
	 %obtener longitud
	 longitud(Posibles,Lon),
	 %si longitud es 1
	 (Lon =:= 1 ->
		NewCount is Count + 1,
		%verifico si la posicion actual es una lista de valores
		(is_list(Posibles) ->
				%si es una lista de valores, concateno la lista de valores con la lista auxiliar
				append(S_aux, Posibles, L3),
				%relleno el resto de la lista con los valores que ya tenia antes
				rellenar_resto(Original, L3, NewCount, Original_new),
				%llamo recursivamente a la funcion
				regla_0_aux(Original_new, [], 1, PossiblesList)
			;
				%si no es una lista de valores, concateno el valor con la lista auxiliar
				append(S_aux, [Posibles], L3),
				%relleno el resto de la lista con los valores que ya tenia antes
				regla_0_aux(Original, L3, NewCount, PossiblesList))
		;
			NewCount is Count + 1,
			%concateno la lista de posibles con la lista auxiliar
			append(S_aux, [Posibles], L3),
			%relleno el resto de la lista con los valores que ya tenia antes
			regla_0_aux(Original, L3, NewCount, PossiblesList))).

/**
 * rellenar_resto
 * @param Original: lista original
 * @param S_aux: lista auxiliar
 * @param Count: Contador
 * @param Result: lista con los valores que se han podido deducir
 */
rellenar_resto(Original, S_aux, Count, Result):-
 (Count =:= 82 ->
	%si el contador es 82, significa que ya he rellenado toda la lista
   	Result = S_aux
  	;
   Nr is Count - 1,
   %obtener posibles
   nth0(Nr, Original, Posibles),
   NewCount is Count + 1,
   %concateno la lista de posibles con la lista auxiliar
   append(S_aux, [Posibles], L3),
   %llamo recursivamente a la funcion
   rellenar_resto(Original, L3, NewCount, Result)).
% ------------------------------------------------

% ------------------------ Regla 1  ------------------------
aparece_una_vez_2_aux(_, [],Num, Res):-
	Res is Num,
	true.
aparece_una_vez_2_aux(X, [Head|Taial],Num, Res):-
	(integer(Head) ->
		Head is [Head]
	),
	(contiene(Head, X) ->
		NewNum is Num + 1,
		aparece_una_vez_2_aux(X, Taial, NewNum, Res)
		;
		longitud(Head, Lon),
		
		(Lon =:= 1 , igual(Head, X)->
			NewNum is Num + 1,
			aparece_una_vez_2_aux(X, Taial, NewNum, Res)
		;
			aparece_una_vez_2_aux(X, Taial, Num, Res)
			)	
	).
aparece_una_vez_2([], _, _, _):-false.
aparece_una_vez_2([X|Tail], ListaDeListas, Num, Res):-
	(aparece_una_vez_2_aux(X, ListaDeListas, 0, Res) , Res =:= 1 ->
		Num is X,
		Res is X,
		true
		;
		aparece_una_vez_2(Tail, ListaDeListas, 0, Res)
	).

aparece_una_vez([X|Y], ListaDeListas, Apariciones, Posicion) :-
	% Obtenemos el numero de apariciones de X en ListaDeListas
	findall(X, (member(Lista, ListaDeListas), member(X, Lista)), Numero),
	(length(Numero, 1) ->
		Apariciones is Numero,
		longitud(Y, Lon),
		Posicion is 9 - Lon,
		true
		;
		aparece_una_vez(Y, ListaDeListas,Apariciones, Posicion)
	).

	
get_numbers_in_row(F, S, Row) :-
	% Calculamos el indice de la primera celda de la fila F
	Start is (F - 1) * 9 + 1,
	End is F * 9,
	% Obtenemos los elementos correspondientes a la fila F
	findall(X, (between(Start, End, Index), nth1(Index, S, X)), Row).
		


%Se introduce la lista de posibilidades, el contador con la columna que se trate y la lista de elementos de la columna y te devuelve el resultado.
otro_en_Columna_regla_1(Original, Count, _, Res):-
	Pos2 is Count - 1,
	nth0(Pos2, Original, Cambiar),
	C is Count - 1 mod 9,
	
	get_numbers_in_column(C, Original, Column),

	(aparece_una_vez(Cambiar, Column, Num, _) ->
		replace(Original, Pos2 , Num, Resultado),
		Res = Resultado, 
		true
	;
		false
	).


%Comprueba si no se repite ningun numero de las filas de la lista, sino se repite cambia la lista.
%Se introduce como parametro la lista de posibilidades, el contador por el que va en la funcion original, el numero de Fila  y la lista de posibilidades. Devuelve
otro_en_fila_regla_1(Original, Count, F, _, Res):-
	Pos2 is Count - 1,
	F is div(Count - 1, 9) + 1,
	get_numbers_in_row(F, Original, Fila),
	nth0(Pos2, Original, Cambiar),

	(aparece_una_vez(Cambiar , Fila,Num, _) ->
		replace(Original, Pos2 , Num, Resultado),
		Res = Resultado, 
		true
	;
		false
	).


valores_en_celdas(_, [], Lista_valores,Res):-
		Res = Lista_valores.
valores_en_celdas(Sudoku, [Celda_Head|Celda_Tail], Lista_valores,Res):-
	%Obtengo el valor de la celda
	nth0(Celda_Head, Sudoku, Valor),
	append(Lista_valores, [Valor], L3),
	valores_en_celdas(Sudoku, Celda_Tail, L3,Res)	.

ver_posi_cambio_cuadrado(Original, [Head|Tail], Num, Res):-
		N2 is Head ,
		nth0(N2, Original, Valores),
		(contiene(Valores, Num) ->
			Res = N2
		;
			ver_posi_cambio_cuadrado(Original, Tail, Num, Res)
	).


otro_en_cuadrado_regla_1(Original, Count, _, Res):-
	cuadrado(Cuadrado, Count),
	%Enceuntra todos los elementos del cuadrado y los devuelve en la lista Xs
	casillasCuadrado(Cuadrado, Celdas),
	Pos2 is Count - 1,
	nth0(Pos2, Original, Cambiar),
	valores_en_celdas(Original, Celdas, [], Xs),
	(aparece_una_vez_2(Cambiar , Xs ,Num, _) ->
		ver_posi_cambio_cuadrado(Original,Celdas,Num,Posicion_cambio),
		replace(Original, Posicion_cambio , Num, Resultado),
		Res = Resultado, 
		true
	;
		false
	).

%Da comienzo a la regla 1
%Se introduce como parametro la lista de posibilidades.
regla_1(Lista, Resultado):-regla_1_aux(Lista, 1, Resultado).
regla_1_aux(Original, Count, PossiblesList):-
	%Si el contador es igual a 82, ya ha recorrido toda la lista, por lo que termina la funcion y guarda el resultado.
	(Count =:= 82 -> PossiblesList = Original;
		Nr is Count - 1,
		NewCount is Count + 1,
		%Obtiene el valor de cada posicion de la lista
		nth0(Nr, Original, Posibles),
		longitud(Posibles,Lon),
		%Se obtiene la fila y columna de la lista
		F is div(Count - 1, 9) + 1,
		%Se compueba si es una lista de posibilidades o un numero solo
		(Lon > 1 ->
			%Si esta una lista de posibilidades, se miran los numeros que no esten repetidos en las filas
			(otro_en_fila_regla_1(Original, Count, F, Posibles, Res) ->
				actualizar_posibilidades(Res, Res2),
				regla_1_aux(Res2, 1, PossiblesList)
			;%Si ya no estan repetidos en las filas, es que ya se han cambiado todos los valores conflictos de las filas y se continua mirando que numeros no se repiten en las columnas.
				(otro_en_Columna_regla_1(Original, Count, Posibles, Res) ->
					actualizar_posibilidades(Res, Res2),
					regla_1_aux(Res2, 1, PossiblesList)
				;
					%Cuando ya se ha completado la sustitucion en las filas y columnas se chequean los cuadrados
					(otro_en_cuadrado_regla_1(Original, Count, Posibles, Res) ->
						actualizar_posibilidades(Res, Res2),
						regla_1_aux(Res2, 1, PossiblesList)
					;
						%Significa que no hay ninguno que se repita, por lo que, no puede variar nada y vuelve a llamar a la funcion 
						regla_1_aux(Original, NewCount, PossiblesList)
					)		
				)	
			)
		;
			%Si la longitud es 1, no habria que modificar la lista, por lo que se vuelve a llamar a la funcion
			regla_1_aux(Original, NewCount, PossiblesList)
		)
	).
% -----------------------------------------------
actualizar_posibilidades(Lista, Res):-

	actualizar_posibilidades_aux(Lista, 1, Res).

actualizar_posibilidades_aux(Lista, Count, Res):-
	(Count =:= 82 -> Res = Lista;
	Nr is Count - 1,
	NewCount is Count + 1,
	nth0(Nr, Lista, Posibles),
	longitud(Posibles,Lon),
	(Lon > 1 ->
		
		posibilidades_celda(Lista, Count, Posibilidades),
		Pos1 is Count - 1,
		longitud(Posibilidades,Lon2),
		(Lon2 =:= 1->
			nth0(0, Posibilidades, Nuevo)
			;
			Nuevo = Posibilidades),
		(igual(Posibles, Posibilidades) -> 
			actualizar_posibilidades_aux(Lista, NewCount,Res)
		;
			replace(Lista, Pos1 , Nuevo, Result),
			actualizar_posibilidades_aux(Result, 1,Res)
		)
		;
		actualizar_posibilidades_aux(Lista, NewCount, Res)
	)).



% ----------------------- Funciones Auxiliares ------------
/**
 * longitud_lista
 * @param lista: lista original
 * @param Resultado: numero entero con la longitud
 */
longitud_lista([], 0).
longitud_lista(Lista, 0) :- \+ is_list(Lista).
longitud_lista([_ | Resto], Longitud) :-
    longitud_lista(Resto, LongitudResto),
    Longitud is LongitudResto + 1.

/**
 * CasillasFila
 * @param entero: entero del 1 al 9 que represena una fila
 * @param lista: lista con las posiciones de la fila
 * Esta funcion retorna una lista con las posiciones de la fila que queramos
 */
casillasFila(Fila, Listado):-
    Inicio is (Fila - 1) * 9,     % inicio de la fila
    Fin is Inicio + 8,            % final de la fila
    findall(Casilla, (between(Inicio, Fin, Casilla)), Listado). % Crear la lista de casillas posibles

/**
 * CasillasColumna
 * @param entero: entero del 1 al 9 que represena una columna
 * @param lista: lista con las posiciones de la fila
 * Esta funcion retorna una lista con las posiciones de la columna indicada
 */
casillasColumna(Columna, Listado ):-
    findall(Casilla, (between(0, 8, Fila), Casilla is Fila * 9 + Columna - 1), Listado).

% ---------------------------------------------------------

% ------------------- Funciones Auxiliares para Regla 2 y Regla 3 --------
/**
 * buscar_similitud
 * @param Sudoku: lista que representa un sudoku, contiene enteros y listas de enteros
 * @param Valor: elemento a comparar con el resto de elementos de las posiciones
 * @param Listado: lista con las posiciones que hay que visitar de Sudoku
 * @param Coincidencias: Numero de veces a comprobar que Valor se repite
 * Funcion que busca similitudes en casillas y retorna true si contador = coincidencias
 * Permite ver cuantos elementos son iguales en las posiciones que pasamos via listado[]
 */
buscar_similitud(Sudoku, Valor, Listado, Coincidencias) :-
    once( buscar_similitud_aux(Sudoku, Valor, Listado, 0, Contador) ),
    Contador == Coincidencias.

/**
 * buscar_similitud_aux
 * @param Sudoku: lista que representa un sudoku, contiene enteros y listas de enteros
 * @param Valor: elemento a comparar con el resto de elementos de las posiciones
 * @param ContadorActual: entero que representa un contador iterativo de 1 en 1
 * @param Contador: entero que representa el contador final
 * Funcion auxiliar de buscar_similitud que permite retornar un contador con las veces que se repite Valor
 * en las posiciones de Listado
 */
buscar_similitud_aux(_, _, [], Contador, Contador).
buscar_similitud_aux(Sudoku, Valor, [X|Listado], ContadorActual, Contador) :-
    nth0(X, Sudoku, Valor2),
    (Valor == Valor2 ->
        ContadorSiguiente is ContadorActual + 1,
        buscar_similitud_aux(Sudoku, Valor, Listado, ContadorSiguiente, Contador);
    buscar_similitud_aux(Sudoku, Valor, Listado, ContadorActual, Contador)).

/**
 * comprobarCuadrado
 * @param Sudoku: lista que representa un sudoku, contiene enteros y listas de enteros
 * @param CuadradosRecorridos: contador para cuando llegue a 10 frenar la recursividad
 * @param Coincidencias: Numero de veces a comprobar que Valor se repite
 * @param NewSudoku: lista que representa un sudoku actualizado
 * Permite aplicar las reglas 2 o 3 segun el parametro Coincidencias sea 2 o 3
 * Para ello buscamos aplicar la regla en las posiciones del cuadrado 1, luego en cuadrado 2, etc
 * Caso base: cuando CuadradosRecorridos llega a 10
 */
comprobarCuadrado(Sudoku, 10, _,SudokuFinal):-SudokuFinal = Sudoku. 
comprobarCuadrado(Sudoku, CuadradosRecorridos, Coincidencias, SudokuFinal) :-
    casillasCuadrado(CuadradosRecorridos, Listado),
	  regla(Sudoku, Listado, Coincidencias, NewSudoku),
	
    NewCuadradosRecorridos is CuadradosRecorridos + 1,
    comprobarCuadrado(NewSudoku, NewCuadradosRecorridos, Coincidencias, SudokuFinal).

/**
 * comprobarFila
 * @param Sudoku: lista que representa un sudoku, contiene enteros y listas de enteros
 * @param FilasRecorridas: contador para cuando llegue a 10 frenar la recursividad
 * @param Coincidencias: Numero de veces a comprobar que Valor se repite
 * @param NewSudoku: lista que representa un sudoku actualizado
 * Permite aplicar las reglas 2 o 3 segun el parametro Coincidencias sea 2 o 3
 * Para ello buscamos aplicar la regla en las posiciones de la fila 1, luego en la fila 2, etc
 * Caso base: cuando FilasRecorridas llega a 10
 */
comprobarFila(Sudoku,10, _,SudokuFinal):-
	SudokuFinal = Sudoku.
comprobarFila( Sudoku, FilasRecorridas, Coincidencias, SudokuFinal):-
	casillasFila( FilasRecorridas, Listado),
	regla( Sudoku, Listado, Coincidencias, NewSudoku),
	NewFilasRecorridas is FilasRecorridas+1,
	comprobarFila( NewSudoku, NewFilasRecorridas, Coincidencias, SudokuFinal).

/**
 * comprobarColumna
 * @param Sudoku: lista que representa un sudoku, contiene enteros y listas de enteros
 * @param ColumnasRecorridas: contador para cuando llegue a 10 frenar la recursividad
 * @param Coincidencias: Numero de veces a comprobar que Valor se repite
 * @param NewSudoku: lista que representa un sudoku actualizado
 * Permite aplicar las reglas 2 o 3 segun el parametro Coincidencias sea 2 o 3
 * Para ello buscamos aplicar la regla en las posiciones de la columna 1, luego en la columna 2, etc
 * Caso base: cuando ColumnasRecorridas llega a 10
 */
comprobarColumna(Sudoku, 10, _,SudokuFinal):-
	SudokuFinal = Sudoku.
comprobarColumna( Sudoku, ColumnasRecorridas, Coincidencias, SudokuFinal):-
	casillasColumna(ColumnasRecorridas, Listado),
	regla(Sudoku, Listado, Coincidencias, NewSudoku),
	NewColumnasRecorridas is ColumnasRecorridas +1,
	comprobarColumna(NewSudoku, NewColumnasRecorridas, Coincidencias, SudokuFinal).

% ------------------------------------------------------------------------

% ------------------------ Regla 2  ------------------------
/**
 * regla2
 * @param Sudoku: lista que representa un sudoku, contiene enteros y listas de enteros
 * @param NewSudoku: lista que representa un sudoku actualizado
 * Permite aplicar la regla2 llamando a comprobarCuadrado, comprobarFila y comprobarColumna
 * con el segundo parametro a 1 indicado que empiezan a aplicar la regla en el cuadrado, fila o columna  1
 * y con el tercero a 2 indicando que se buscan 2 similitudes
 */
regla2( Sudoku, SudokuFinal ):-
	comprobarCuadrado(Sudoku, 1, 2, NewSudoku),
	comprobarFila( NewSudoku, 1, 2, NewSudoku2),
	comprobarColumna( NewSudoku2, 1, 2, SudokuFinal).
	

% ------------------------------------------------------------

% ------------------------ Regla 3 ----------------------------
/**
 * regla3
 * @param Sudoku: lista que representa un sudoku, contiene enteros y listas de enteros
 * @param NewSudoku: lista que representa un sudoku actualizado
 * Permite aplicar la regla3 llamando a comprobarCuadrado, comprobarFila y comprobarColumna
 * con el segundo parametro a 1 indicado que empiezan a aplicar la regla en el cuadrado, fila o columna  1
 * y con el tercero a 3 indicando que se buscan 3 similitudes
 */
regla3( Sudoku, SudokuFinal ):-
	comprobarCuadrado( Sudoku, 1, 3, NewSudoku),
	comprobarFila( NewSudoku, 1, 3, NewSudoku2),
	comprobarColumna( NewSudoku2, 1, 3, SudokuFinal).

% -------------------------------------------------------------

% ----------------------- Funcion Regla 2 y 3 -----------------
/**
 * regla
 * @param Sudoku: lista que representa un sudoku, contiene enteros y listas de enteros
 * @param Listado: lista que contiene las posiciones a visitar
 * @param Coincidencias: entero que representa las coincidencias entre elementos, 2 para regla2 y 3 para regla3
 * @param NewSudoku: lista que representa un sudoku actualizado
 * Implementacion de las reglas 2 y 3, para ello llamamos a regla_aux con el tercer parametro a 0 indicando
 * que empezamos a comprobar en el primer elemento del listado, es decir, primera posicion a visitar
 */
regla( Sudoku, Listado, Coincidencias, NewSudoku):-
	regla_aux( Sudoku, Listado, 0, Coincidencias, NewSudoku);
	NewSudoku = Sudoku.

/**
 * regla_aux
 * @param Sudoku: lista que representa un sudoku, contiene enteros y listas de enteros
 * @param Listado: lista que contiene las posiciones a visitar
 * @param Contador: entero que se incrementa para acceder a los elementos de Listado
 * @param Coincidencias: entero que representa las coincidencias entre elementos, 2 para regla2 y 3 para regla3
 * @param NewSudoku: lista que representa un sudoku actualizado
 * Implementacion auxiliar de regla que busca encontrar similitudes de valores cuya longitud sea de Coincidencias, es decir, 
 * 2 o 3 dependiendo de la regla. Cuando se encuentre una similitud, habra un valor de 2 o 3 elementos( posibilidades en el sudoku)
 * que se repita 2 o 3 veces y se procedera a eleminar los elementos de las restantes casillas segun la teorica de la regla 2 y regla 3
 */
regla_aux(Sudoku,_,10,_,NewSudoku):- 
	NewSudoku = Sudoku.
regla_aux( Sudoku, Listado, Contador, Coincidencias, SudokuFinal):-
    nth0(Contador, Listado, Posicion),
    nth0(Posicion, Sudoku, Valor),
	longitud_lista(Valor, L),
	(L == Coincidencias ->
        (buscar_similitud(Sudoku, Valor, Listado, Coincidencias) ->
	
            borrarPosibilidades(Sudoku, Valor, Listado, NewSudoku),
		
			NewContador is Contador + 1,
        	regla_aux(NewSudoku, Listado, NewContador, Coincidencias, SudokuFinal)
        ; 
			NewContador is Contador + 1,
        	regla_aux(Sudoku, Listado, NewContador, Coincidencias, SudokuFinal)
        )
    ;
        NewContador is Contador + 1,
        regla_aux(Sudoku, Listado, NewContador, Coincidencias, SudokuFinal)
    );
	SudokuFinal = Sudoku.
% ------------------------------------------------------------

% ------------------- Ordenacion ascendente por inserccion ----------------
/**
 * ordenacion_ascendente
 * @param Lista1
 * @param Lista2
 * Ordena mediante el metodo de inserccion directa una lista de menor a mayor
 */
ordenar_ascendente([], []).   % Caso base: lista vacía, retorna lista vacía
ordenar_ascendente([X|Xs], Sorted) :-    % Caso recursivo
    ordenar_ascendente(Xs, SortedXs),    % Ordena la cola de la lista
    inserta_ascendente(X, SortedXs, Sorted).  % Inserta la cabeza de la lista en la lista ordenada

% Predicado para insertar un elemento en una lista ordenada de manera ascendente
inserta_ascendente(X, [], [X]).    % Caso base: lista vacía, retorna lista con X
inserta_ascendente(X, [Y|Ys], [X,Y|Ys]) :-   % X es menor que Y, inserta X antes de Y
    X =< Y.
inserta_ascendente(X, [Y|Ys], [Y|Zs]) :-     % X es mayor que Y, continúa con el siguiente elemento de la lista
    X > Y,
    inserta_ascendente(X, Ys, Zs).

% -------------------------------------------------------------------------


% ------------------ quitar posibilidades de casillas ------------------
quitar_valores_aux([], _, Lista_aux, Res):-Res = Lista_aux.
quitar_valores_aux([X|Tail], Valores, Lista_aux, Res):-
	%si X no esta en valores, lo agrego a la lista auxiliar
	(member(X, Valores) -> quitar_valores_aux(Tail, Valores, Lista_aux, Res);
	quitar_valores_aux(Tail, Valores, [X|Lista_aux], Res)).

quitar_valores(Posibles, Valores, Res):-
	quitar_valores_aux(Posibles, Valores,[], Res).


	reverse([], []).
reverse([X|Xs], Ys) :- reverse(Xs, Zs), append(Zs, [X], Ys).



borrarPosibilidades(Sudoku, _, [], Res):- Res = Sudoku.
borrarPosibilidades(Sudoku,Valores,[Posi|Res_casilla], Res):-
	% quito los valores de esa posicion que estan en Valores
	nth0(Posi, Sudoku, Posibles),
	longitud(Posibles,Lon),
	(Lon =:= 1 ->
		borrarPosibilidades(Sudoku, Valores, Res_casilla, Res)
	;	
		ordenar_ascendente(Posibles, PosiblesOrdenados),
		PosiblesOrdenados == Valores,
		borrarPosibilidades(Sudoku, Valores, Res_casilla, Res)
		;
		quitar_valores(Posibles, Valores, Posibles_sin_valores),
		reverse(Posibles_sin_valores, Posibles_sin_valores_invertida),
		replace(Sudoku, Posi, Posibles_sin_valores_invertida, Res_aux),
		borrarPosibilidades(Res_aux, Valores, Res_casilla, Res)	
	).
% -----------------------------------------------


/**
 * Esta funcion intenta aplicar las reglas de definidas hasta que no produzcan cambios
 */
ciclo(Lista, Resultado):-
	%Aplico la regla 0
	regla_0(Lista, Res1),
	actualizar_posibilidades(Res1,Res2),
	regla_1(Res2, Res3),
	regla2(Res3, Res4),
	regla3(Res4, Res5),
	%Si no se ha producido ningun cambio, devuelvo el sudoku
	(sudokus_iguales(Lista, Res5) ->Resultado = Res5 ; ciclo(Res5, Resultado)).

ejecutar(Lista):-
	insert_posible_aux(Lista,Res1),
	ciclo(Res1, Resultado),
	mostrar_sudoku(Resultado),nl.


bateria():-
	ejecutar([.,.,3,.,2,.,7,.,.,
                5,.,.,.,.,.,4,.,3,
                .,.,.,3,.,.,.,2,5,
                .,.,5,.,1,.,6,.,.,
                .,.,4,8,.,7,.,.,.,
                2,3,7,6,.,4,8,.,.,
                .,8,.,.,.,2,.,7,.,
                3,.,.,4,.,.,2,.,8,
                .,.,9,.,.,.,.,6,.]),

				ejecutar([.,8,.,2,6,.,3,.,.,
                5,.,.,9,3,7,.,8,.,
                .,7,4,.,.,.,.,9,.,
                .,9,7,3,.,.,2,6,.,
                .,2,5,.,8,.,7,.,3,
                4,.,.,.,.,6,.,1,.,
                .,.,3,4,7,.,9,.,6,
                .,4,.,.,.,.,.,3,1,
                2,.,6,8,.,.,.,.,5]),

				ejecutar([.,.,.,7,.,.,.,5,.,
                .,6,.,.,.,.,3,.,1,
                8,.,5,.,.,6,9,.,.,
                .,.,8,.,6,.,.,4,3,
                .,9,.,.,3,.,8,2,.,
                .,7,.,.,2,.,.,1,.,
                .,.,.,5,.,.,1,.,.,
                .,5,7,.,8,.,.,.,2,
                6,.,1,.,.,3,.,.,8]),
                
				ejecutar([.,.,.,.,6,.,.,.,.,
                .,.,.,9,5,.,8,.,3,
                .,.,4,.,.,7,.,.,.,
                .,6,.,4,7,.,.,.,.,
                .,4,8,5,.,.,.,.,6,
                .,7,.,8,9,.,.,.,.,
                .,3,.,.,.,.,2,.,8,
                6,.,.,.,.,.,3,.,4,
                2,.,.,7,.,.,.,9,.]),
                              
				ejecutar([.,1,.,3,.,6,8,.,2,
                7,.,3,5,.,.,.,.,.,
                .,.,.,.,.,.,4,.,.,
                9,5,.,8,.,.,.,4,1,
                .,.,.,.,.,.,2,6,.,
                6,.,1,.,.,.,.,9,5,
                .,.,.,6,2,.,.,.,.,
                .,.,5,.,7,.,1,.,.,
                .,.,4,.,5,8,6,2,.]), 

				ejecutar([.,.,4,2,.,.,.,8,.,
                2,3,.,4,.,7,9,.,6,
                5,.,.,.,3,.,.,2,.,
                3,.,.,.,.,.,.,.,.,
                .,7,5,.,.,.,.,.,.,
                9,.,.,3,.,.,5,.,.,
                .,.,.,.,.,8,.,3,4,
                4,.,.,7,.,.,.,.,.,
                .,.,.,1,5,.,.,6,2]),

				ejecutar([.,7,.,2,5,.,6,8,.,
                .,3,.,.,.,.,2,7,.,
                .,.,.,.,.,.,.,.,.,
                .,.,6,.,7,.,.,.,.,
                .,.,4,.,.,2,7,.,5,
                5,.,.,4,6,.,9,.,.,
                .,2,.,.,8,.,5,.,.,
                .,.,.,6,.,.,.,.,.,
                .,.,.,.,.,.,3,4,8]),
              
				ejecutar([.,.,.,1,.,.,5,8,.,
                .,.,2,.,9,.,.,.,.,
                .,7,1,6,.,4,9,.,.,
                .,.,.,9,6,8,.,4,.,
                8,.,6,.,.,1,.,9,5,
                .,.,.,.,.,.,.,.,.,
                4,3,.,.,.,2,.,.,.,
                .,.,.,.,3,.,.,.,.,
                6,.,5,.,.,.,2,3,.]),
                                
				ejecutar([.,.,8,.,1,3,2,.,.,
                .,9,.,5,.,.,.,.,.,
                .,7,.,.,.,.,.,.,8,
                .,6,.,1,.,.,3,.,.,
                2,.,.,.,.,.,.,.,9,
                .,.,1,.,.,6,.,7,.,
                6,.,.,.,.,.,.,5,.,
                .,.,.,.,.,9,.,3,.,
                .,.,3,2,7,.,9,.,.]),
               
				ejecutar([8,.,.,1,.,.,5,7,.,
                 2,.,.,.,5,7,.,.,.,
                 1,.,.,9,.,.,.,.,.,
                 7,.,.,.,.,.,.,1,.,
                 .,8,6,.,.,5,7,.,.,
                 .,.,.,8,.,.,.,.,.,
                 .,.,.,.,.,3,.,6,9,
                 .,2,.,.,9,.,1,.,5,
                 .,.,.,2,.,.,.,3,.]), 

				 ejecutar([7,.,.,5,.,9,.,.,.,
                 5,1,.,.,.,.,.,3,.,
                 .,.,3,.,.,.,8,.,.,
                 .,.,.,4,.,8,9,.,.,
                 4,.,.,.,.,6,.,7,.,
                 .,7,.,9,.,1,5,.,.,
                 9,6,.,.,.,.,1,5,.,
                 8,5,.,.,.,.,.,.,4,
                 .,.,.,.,.,.,.,.,.]), 
                
				 ejecutar([.,.,3,9,.,1,.,8,.,
                 7,.,.,4,3,.,9,.,.,
                 .,.,.,.,7,.,5,3,.,
                 .,.,4,.,.,.,.,.,.,
                 .,1,7,.,.,4,.,.,.,
                 3,6,.,.,.,.,.,.,.,
                 .,7,1,.,4,.,.,9,.,
                 .,.,5,1,.,.,.,6,.,
                 .,4,.,.,.,9,8,.,.]), 
                 
				 ejecutar([6,.,.,.,3,.,.,.,4,
                 2,.,4,.,.,.,7,.,.,
                 .,.,.,.,7,6,2,.,.,
                 .,3,5,.,.,.,.,.,8,
                 .,.,2,.,6,1,.,.,.,
                 .,.,.,.,.,4,5,.,7,
                 .,.,.,2,9,.,.,6,.,
                 .,.,6,.,.,5,.,.,.,
                 9,7,.,.,.,.,4,.,.]),  
                 
				 ejecutar([.,.,2,4,.,.,.,9,7,
                 .,.,.,.,1,.,.,.,.,
                 .,3,.,.,.,6,.,2,.,
                 5,.,3,.,7,.,.,8,.,
                 .,.,.,.,.,.,.,.,.,
                 .,6,.,.,4,.,2,.,3,
                 .,4,.,6,.,.,.,1,.,
                 .,.,.,.,9,.,.,.,.,
                 2,1,.,.,.,8,6,.,.]), 
                 
				 ejecutar([.,.,.,7,.,.,.,2,.,
                 .,7,.,.,.,5,9,.,.,
                 .,.,4,.,.,1,.,6,.,
                 .,9,.,.,.,7,.,.,2,
                 3,.,.,.,.,.,.,.,8,
                 6,.,.,2,.,.,.,7,.,
                 .,4,.,3,.,.,1,.,.,
                 .,.,6,9,.,.,.,8,.,
                 .,1,.,.,.,4,.,.,.]),             

				 ejecutar([.,.,.,.,.,1,.,2,.,
                 .,.,8,7,.,3,5,.,.,
                 9,.,3,.,.,2,.,.,.,
                 2,.,5,.,.,.,.,.,6,
                 .,.,.,.,7,.,.,.,.,
                 6,.,.,.,.,.,8,.,1,
                 .,.,.,3,.,.,4,.,9,
                 .,.,2,9,.,8,7,.,.,
                 .,4,.,1,.,.,.,.,.]), 
                 
				 ejecutar([.,5,.,.,6,.,.,2,9,
                 3,2,4,.,.,.,.,.,7,
                 9,.,.,.,1,.,.,.,.,
                 4,.,1,.,.,.,7,.,.,
                 .,.,9,.,.,4,.,.,2,
                 5,3,.,.,.,9,4,.,6,
                 .,.,.,.,.,.,3,.,.,
                 .,.,.,7,9,.,.,.,.,
                 .,.,.,.,5,.,.,.,.]),
                 
				 ejecutar([.,5,7,.,.,.,.,.,9,
                 4,.,1,.,.,3,.,.,.,
                 .,6,.,.,9,5,.,.,.,
                 .,.,.,.,.,4,.,5,.,
                 .,.,4,.,.,.,3,.,.,
                 .,.,3,1,.,.,.,2,6,
                 .,.,6,.,.,2,.,7,3,
                 2,.,.,.,.,.,5,.,.,
                 .,3,.,.,.,1,.,4,.]), 
                         
				 ejecutar([.,.,9,.,1,.,.,8,.,
                 .,4,3,.,8,.,.,.,1,
                 .,.,.,.,.,3,9,6,.,
                 .,.,.,1,.,7,.,.,.,
                 4,.,.,5,9,.,8,.,.,
                 .,9,5,.,.,.,.,1,4,
                 .,5,.,.,.,.,7,9,.,
                 .,.,.,6,.,.,.,.,.,
                 .,.,8,.,.,.,.,4,.]),
                 
				 ejecutar([4,.,9,.,.,.,.,.,.,
                 .,1,.,.,.,.,5,.,.,
                 5,6,.,9,2,.,.,.,.,
                 6,7,.,3,.,.,.,1,2,
                 .,5,.,.,1,.,4,.,.,
                 .,.,1,6,4,.,.,.,9,
                 .,9,.,.,3,.,.,6,.,
                 2,.,6,.,.,.,.,.,.,
                 .,.,.,4,.,.,.,.,.]),  
                 
				 ejecutar([.,.,.,.,.,6,.,.,7,
                 6,.,.,.,.,.,.,2,.,
                 1,.,4,.,5,7,.,3,.,
                 .,.,.,.,.,9,8,.,.,
                 .,6,7,.,3,.,.,4,.,
                 .,.,2,.,1,.,3,.,.,
                 7,.,.,5,.,.,.,.,.,
                 .,.,5,9,.,.,.,.,.,
                 .,8,.,.,2,.,4,.,.]),                 
                                
				 ejecutar([.,.,.,.,7,.,.,.,9,
                 4,6,.,1,.,3,.,8,.,
                 3,7,.,9,.,.,1,.,6,
                 8,.,.,.,2,4,.,.,7,
                 6,2,.,.,.,.,.,.,.,
                 .,.,1,.,.,.,.,.,.,
                 .,.,.,.,.,.,.,.,.,
                 .,8,6,2,.,.,.,9,.,
                 9,.,.,.,.,7,.,.,3]),

				 ejecutar([.,8,3,.,.,7,.,.,.,
                 .,.,.,.,.,4,.,.,.,
                 5,.,4,.,.,3,.,7,6,
                 .,3,5,.,.,9,.,.,.,
                 8,.,.,3,.,5,1,.,.,
                 6,.,.,.,.,.,.,4,.,
                 .,.,.,.,.,.,9,1,.,
                 1,.,.,.,.,.,6,.,4,
                 4,.,.,.,5,.,.,8,.]), 
                  
				 ejecutar([.,.,5,.,.,.,.,3,2,
                 .,3,2,7,.,.,9,.,.,
                 1,4,.,.,.,.,.,.,.,
                 .,.,.,.,5,.,4,.,.,
                 7,.,.,.,.,.,.,6,.,
                 .,9,3,4,.,.,2,.,.,
                 6,.,.,.,7,2,.,.,.,
                 .,.,1,.,.,.,.,9,.,
                 .,.,.,.,.,4,5,.,.]), 

				 ejecutar([5,.,.,.,6,.,.,4,.,
                 9,.,.,3,.,.,6,.,.,
                 .,.,2,.,.,9,.,.,.,
                 .,.,.,8,.,.,3,9,.,
                 .,.,5,.,.,.,.,2,.,
                 .,.,.,.,3,.,5,.,.,
                 .,2,8,.,.,.,.,.,3,
                 .,.,.,.,.,.,.,.,6,
                 .,.,4,.,1,5,8,.,9]).
