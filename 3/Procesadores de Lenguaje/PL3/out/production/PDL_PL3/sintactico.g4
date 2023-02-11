parser grammar sintactico;

options { tokenVocab = lexico;}

programa: (crearFuncion+)|(linea+) EOF; // AXI0MA

linea: ((declaracion|expr)+finlinea);

expr:   llamarFuncion | //ejemploLlamadaFuncion(arg1,arg2,...,argN); o ejemploLlamadaFuncion(); -> pueden tener 0 o N parámetros
        sim | //++2, --1.213, 12398++, 2.223--, variable++, --x, var--, ++x
        print | //funcion print() -> print("mensaje"); / print(variable);
        variable| //x, y, variable, contador... (nombres de variables)
        condicional | //if(condicion){...}; (nota: {...} es el contenido del bloque), else if(condicion){...}; else{...};
        while | //while(condicion){...};
        doWhile | //do{...}while(condicion){...};
        for | //for(variable;condicion;sim){...};
		asignacion |
        val | //val(parametroPolinomio1, ..., parametroPolinomioN); | val(parametroPolinomio) -> pueden tener 1 o N parámetros
        expr elevado expr | //expresion ^ expresion -> por ejemplo: 3^2
        expr opermultipl expr | //expresion*expresion o expresion/expresion
        expr operadicion expr | //expresion+expresion o expresion-expresion
        expr (resto|modulo) expr | //expresion%expresion o expresion//expresion
        expr opercomparac expr | //expresion comparacion expresion -> x < y, 123.3 == z, hola() != adios()
        expr operlogicos expr | //expresion operadorLogico expresion -> x && y, aceptaCadena(c) || esVacio(a);
        return | //return o return expresion
        ENTERO | //ver léxico.g4
        REAL |
        POLINOMIO |
        TEXTO;

return: RETURN (PARIZ (parametroReturn)? PARDE|(parametroReturn)?);
parametroReturn:
        variable|
		val |
		parametroReturn opercomparac parametroReturn |
		parametroReturn opermultipl parametroReturn |
        parametroReturn operadicion parametroReturn |
		ENTERO |
		REAL |
    	POLINOMIO |
    	TEXTO|
    	llamarFuncion
;


igual:IGUAL;

declaracion: LET (variable | asignacion);
asignacion: variable igual parametroAsignacion;
parametroAsignacion:
        variable|
		val |
((incdec (ENTERO|REAL|variable))|((ENTERO|REAL|variable)incdec)) |
		parametroAsignacion elevado parametroAsignacion |
		parametroAsignacion opercomparac parametroAsignacion |
		parametroAsignacion opermultipl parametroAsignacion |
        parametroAsignacion operadicion parametroAsignacion |
		ENTERO |
		REAL |
    	POLINOMIO |
    	TEXTO|
    	llamarFuncion
;

incdec:(INCREMENTO|DECREMENTO); // ++|--

sim:((incdec (ENTERO|REAL|variable))|((ENTERO|REAL|variable)incdec));

/* LLAMADA A UNA FUNCION */
crearFuncion: FUNC variable PARIZ parametrosCrear? PARDE contenidoFunc; //para crear funciones tal que: function fun(parametros){...} -> puede no tener parámetros
parametrosCrear: variable (COMA variable)*;
parametros: parametro (COMA parametro)*;
parametro: llamarFuncion |
           sim |
           variable |
           val |
           expr elevado expr | //expresion ^ expresion -> por ejemplo: 3^2
           expr operadicion expr | //expresion+expresion
           expr opermultipl expr | //expresion*expresion
           expr (resto|modulo) expr | //expresion/expresion o expresion//expresion
           ENTERO |
           REAL |
           POLINOMIO |
           TEXTO;

contenidoFunc: LLAVEI linea* LLAVED finlinea; //{expresion o asignacion; 0 o N veces};

contenidoBloque: LLAVEI linea* LLAVED; //para los bucles y condiciones

llamarFuncion: variable PARIZ parametros? PARDE; //funcionLLamada(parametros) -> pueden ser 0 o N parámetros

print: PRINT PARIZ parametroPrint PARDE; //print(expresiones separadas por comas); 1 o N expresiones dentro del print
parametroPrint: llamarFuncion |
                 ((incdec (ENTERO|REAL|variable))|((ENTERO|REAL|variable)incdec))  |//no ponemos sim ya que de esta forma no se llama a enterSim/exitSim -> para nuestra implementación es más sencillo así
                variable |
                val |
                parametroPrint opermultipl parametroPrint |
                parametroPrint operadicion parametroPrint |
                parametroPrint elevado parametroPrint |
                parametroPrint (resto|modulo) parametroPrint|
                parametroPrint opercomparac parametroPrint | //expresion comparacion expresion -> x < y, 123.3 == z, hola() != adios()
                parametroPrint operlogicos parametroPrint |
                ENTERO | //ver léxico.g4
                REAL |
                POLINOMIO |
                TEXTO;

/* PALABRAS CLAVE */
//Bucles y condicionales:
condicional: if  (elif)*  else?;
if: IF condiciones contenidoBloque;
elif: ELSE if; // EXTRA
else: ELSE contenidoBloque;
//condiciones: PARIZ parametroCondicion (operlogicos parametroCondicion)* PARDE;
condiciones: PARIZ parametroCondicion PARDE;
parametroCondicion: llamarFuncion |
                   sim |
                   variable |
                   val |
                   OPNEG?  PARIZ  parametroCondicion PARDE |
                   parametroCondicion opercomparac parametroCondicion |
                   parametroCondicion operlogicos parametroCondicion |
                   ENTERO | //ver léxico.g4
                   REAL |
                   POLINOMIO |
                   TEXTO;
while: WHILE condiciones contenidoBloque;
doWhile: DO LLAVEI ((expr|declaracion) finlinea)* LLAVED WHILE condiciones; // EXTRA
for: FOR PARIZ variable finlinea condiciones finlinea variable incdec PARDE contenidoBloque;
//otros reservados:
val: VAL PARIZ polinomioEvaluar COMA parametroPolinomio PARDE;
polinomioEvaluar:
polinomioEvaluar opermultipl polinomioEvaluar |
polinomioEvaluar operadicion polinomioEvaluar |
polinomioEvaluar elevado polinomioEvaluar |
    POLINOMIO|
    VAR|
	ENTERO|
	REAL;

parametroPolinomio:
	operandoVal COMA operandoVal |
	parametroPolinomio COMA parametroPolinomio;
operandoVal:
	POLINOMIO |
	variable|
	ENTERO|
	REAL|
;
operacionConPolinom:(POLINOMIO|variable) (operadicion|opermultipl) (POLINOMIO|variable);

//Identificadores de variables
variable: VAR;

/* CONJUNTO DE OPERADORES */
operadicion: OPS|OPR;
opermultipl: OPM|OPD;
operlogicos: OPAND|OPOR|OPEXC|OPNEG;
opercomparac: OPMAYOR|OPMENOR|OPMAYIG|OPIGUAL|OPMENIG|OPDIST;

/* OPERADORES */
resto:OPRESTO;
modulo:OPMOD;
elevado:OPE;

finlinea:FINLINEA;