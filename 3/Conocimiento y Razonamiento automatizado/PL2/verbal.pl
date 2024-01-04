% ------- Oraciones/frases que contienen verbo -------


/**
 * verbo
 * @param Verbo: verbo de la oracion/frase
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * Esta regla se apoya en verbo() que nos permite verificar la conjugacion del verbo 
 *      u obtener su persona y numero.
 */
grupoVerbal(gv(Verbo), Persona, Numero,_)-->
	verbo(Verbo, Persona, Numero).

/**
 * verbo + sintagma nominal
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaNominal: parte de la oracion/frase que representa el sintagma nominal
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * "-->" para definir una gramatica en prolog
 * Esta regla se apoya en verbo() y frase_nominal() para verificar la conjugacion del verbo 
 *      y obtener la informacion del sustantivo a partir del sintagma nominal.
 */
grupoVerbal(gv(Verbo, SintagmaNominal), Persona, Numero, _) -->
	verbo(Verbo, Persona, Numero),
	nominal(SintagmaNominal, _, _, _).

/**
 * verbo + sintagma adverbial
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaAverbial: parte de la oracion/frase que representa el sintagma adverbial
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * "-->" para definir una gramatica en prolog
 * Esta regla se apoya en verbo() y frase_con_adverbio() para verificar la conjugacion del verbo
 *      y obtener informacion del adverbio que esta en parte adverbial de la oracion/frase
 * Se ejecuta cuando el verbo esta seguido de un sintagma adverbial
 */
grupoVerbal(gv(Verbo, SintagmaAdverbial), Persona, Numero, _) -->
	verbo(Verbo, Persona, Numero),
	frase_con_adverbio(SintagmaAdverbial).

/**
 * sintagma adverbial + verbo
 * @param SintagmaAverbial: parte de la oracion/frase que representa el sintagma adverbial
 * @param Verbo: verbo de la oracion/frase
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * "-->" para definir una gramatica en prolog
 * Esta regla se apoya en verbo() y frase_con_adverbio() para verificar la conjugacion del verbo
 *      y obtener informacion del adverbio que esta en parte adverbial de la oracion/frase.
 * Se ejecuta cuando el sintagma nominal esta seguido del verbo.
 */
grupoVerbal(gv(SintagmaAdverbial, Verbo), Persona, Numero, _) -->
	frase_con_adverbio(SintagmaAdverbial),
	verbo(Verbo, Persona, Numero).

/**
 * verbo + sintagma adverbial + sintagma nominal
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaAverbial: parte de la oracion/frase que representa el sintagma adverbial
 * @param SintagmaNominal: parte de la oracion/frase que representa el sintagma nominal
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * "-->" para definir una gramatica en prolog
 * Esta regla se apoya en verbo(), frase_con_adverbio() y frase_nominal() para verificar la conjugacion del verbo
 *      , obtener informacion del adverbio que esta en parte adverbial de la oracion/frase
 *      y obtener informacion del sujeto en el sintagma nominal.
 * Se ejecuta cuando el verbo va seguido de un adverbio, seguido de un sintagma nominal.
 */
grupoVerbal(gv(Verbo, SintagmaAdverbial, SintagmaNominal), Persona, Numero, _) -->
	verbo(Verbo, Persona, Numero),
	frase_con_adverbio(SintagmaAdverbial),
	nominal(SintagmaNominal, _, _, _).

/**
 * sintagma adverbial + verbo + sintagma nominal
 * @param SintagmaAdverbial: parte de la oracion/frase que representa el sintagma adverbial
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaNominal: parte de la oracion/frase que representa el sintagma nominal
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * "-->" para definir una gramatica en prolog
 * Esta regla se apoya en verbo(), frase_con_adverbio() y frase_nominal() para verificar la conjugacion del verbo
 *      , obtener informacion del adverbio que esta en parte adverbial de la oracion/frase
 *      y obtener informacion del sujeto en el sintagma nominal.
 * Se ejecuta cuando el sintagma adverbial va seguido del verbo, seguido del sintagma nominal
 */
grupoVerbal(gv(SintagmaAdverbial, Verbo, SintagmaNominal), Persona, Numero, _) -->
	frase_con_adverbio(SintagmaAdverbial),
	verbo(Verbo, Persona, Numero),
	nominal(SintagmaNominal,_,_, _).

/**
 * verbo + sintagma preposicional
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaPreposicional: parte de la oracion/frase que representa el sintagma preposicional
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * "-->" para definir una gramatica en prolog
 * Esta regla se apoya en verbo() y frase_nominal_preposicion(), para verificar la conjugacion del verbo
 *      y obtener informacion del sintagma preposicional
 * Se ejecuta cuando el verbo va seguido de un sintagma preposicional
 */
grupoVerbal(gv(Verbo, SintagmaPreposicional), Persona, Numero,_) -->
	verbo(Verbo, Persona, Numero),
	frase_nominal_preposicion(SintagmaPreposicional).

/**
 * verbo + sintagma preposicional + sintagma nominal
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaPreposicional: parte de la oracion/frase que representa el sintagma preposicional
 * @param SintagmaNominal: parte de la oracion/frase que representa el sintagma nominal
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * "-->" para definir una gramatica en prolog
 * Esta regla se apoya en verbo(), frase_nominal_preposicion() y frase_nominal(), para verificar la conjugacion del verbo
 *      y obtener informacion del sintagma preposicional y del sintagma nominal
 * Se ejecuta cuando el verbo va seguido del sintagma preposicional, seguido del nominal
 */
grupoVerbal(gv(Verbo, SintagmaPreposicional, SintagmaNominal), Persona, Numero,_) -->
	verbo(Verbo, Persona, Numero),
	frase_nominal_preposicion(SintagmaPreposicional),
	nominal(SintagmaNominal, _,_,_).

/**
 * verbo + adjetivo
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaAdverbial: parte de la oracion/frase que representa el sintagma adverbial
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * @param GeneroAdjetivo: representa el genero (masculino o femenino) del adjetivo
 * "-->" para definir una gramatica en prolog
 * Se ejecuta cuando el verbo va seguido de un sintagma adverbial seguido de una parte con adjetivo     
 */
grupoVerbal(gv(Verbo, SintagmaAdverbial), Persona, Numero, GeneroAdjetivo) -->
	verbo(Verbo, Persona, Numero),
	frase_con_adjetivo(SintagmaAdverbial, GeneroAdjetivo,_).

/**
 * verbo + adjetivo + sintagma nominal
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaAdverbial: parte de la oracion/frase que representa el sintagma adverbial
 * @param SintagmaNominal: parte de la oracion/frase que representa el sintagma nominal
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * @param GeneroAdjetivo: representa el genero (masculino o femenino) del adjetivo
 * "-->" para definir una gramatica en prolog
 * Se ejecuta cuando hay un verbo seguido de una parte con adjetivo y sintagma nominal   
 */
grupoVerbal(gv(Verbo, SintagmaAdverbial, SintagmaNominal), Persona, Numero, GeneroAdjetivo) -->
	verbo(Verbo, Persona, Numero),
	frase_con_adjetivo(SintagmaAdverbial, GeneroAdjetivo,_),
	nominal(SintagmaNominal, _, _, _).

/**
 * sintagma nominal + que + verbo + sintagma preposicional
 * @param SintagmaNominal: parte de la oracion/frase que representa el sintagma nominal
 * @param Que: representa la conjuncion que
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaPreposicional: parte de la oracion/frase que representa el sintagma preposicional
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * "-->" para definir una gramatica en prolog
 * Se ejecuta cuando hay un verbo precedido por un sintagma nominal seguido de una conjuncion
 *      y luego esta seguido de un sitagma preposicional.
 *  "El hombre que vimos en la universidad era mi profesor"  
 */
grupoVerbal(gv(SintagmaNominal, Que, Verbo, SintagmaPreposicional), Persona, Numero, _) -->
	nominal(SintagmaNominal, _, _, _),
	que(Que),
	verbo(Verbo, Persona, Numero),
	frase_nominal_preposicion(SintagmaPreposicional).

/**
 * que + verbo + sintagma nominal
 * @param Que: representa la conjuncion que
 * @param Verbo: verbo de la oracion/frase
 * @param SintagmaNominal: parte de la oracion/frase que representa el sintagma nominal
 * @param Persona: representa la persona del verbo
 * @param Numero: representa el numero del verbo, singular o plural
 * "-->" para definir una gramatica en prolog
 * Se ejecuta cuando el verbo esta precedido por una conjuncion y seguido de un sintagma nominal 
 */
grupoVerbal(gv(Que, Verbo, SintagmaNominal), Persona, Numero, _) -->
	que(Que),
	verbo(Verbo, Persona, Numero),
	nominal(SintagmaNominal, _, _, _).



grupoVerbal(gv(SublistaNominal, Que, Ver, SublistaNominal2), PersonaV, NumeroV, _) -->
	nominal(SublistaNominal, _, _, _),
	que(Que),
	verbo(Ver, PersonaV, NumeroV),
	frase_con_adverbio(SublistaNominal2).
