parser grammar sintactico;

options { tokenVocab = lexico;}

programa: ((crearFuncion)+)|(((expr|asignacion)FINLINEA)+) EOF; // AXI0MA

expr:   llamarFuncion | //ejemploLlamadaFuncion(arg1,arg2,...,argN); o ejemploLlamadaFuncion(); -> pueden tener 0 o N parámetros
        sim | //++2, --1.213, 12398++, 2.223--, variable++, --x, var--, ++x
        print | //funcion print() -> print("mensaje"); / print(variable);
        variable| //x, y, variable, contador... (nombres de variables)
        if | //if(condicion){...}; (nota: {...} es el contenido del bloque)
        elif |//else if(condicion){...};
        else | //else{...};
        while | //while(condicion){...};
        doWhile | //do{...}while(condicion){...};
        for | //for(variable;condicion;sim){...};
        val | //val(parametroPolinomio1, ..., parametroPolinomioN); | val(parametroPolinomio) -> pueden tener 1 o N parámetros
        expr elevado expr | //expresion ^ expresion -> por ejemplo: 3^2
        expr opermultipl expr | //expresion*expresion
        expr operadicion expr | //expresion+expresion
        expr resto|modulo expr | //expresion/expresion o expresion//expresion
        expr opercomparac expr | //expresion comparacion expresion -> x < y, 123.3 == z, hola() != adios()
        expr operlogicos expr | //expresion operadorLogico expresion -> x && y, aceptaCadena(c) || esVacio(a);
        expr IGUAL expr | //expresion = expresion
        RETURN (expr)?| //return o return expresion
        ENTERO | //ver léxico.g4
        REAL |
        POLINOMIO |
        TEXTO;

asignacion: LET variable (IGUAL expr)?; //let nombreVariable = expresion;

incdec:(INCREMENTO|DECREMENTO); // ++|--

sim:((incdec (ENTERO|REAL|variable))|((ENTERO|REAL|variable)incdec));

/* LLAMADA A UNA FUNCION */
crearFuncion: FUNC variable PARIZ parametros? PARDE contenidoFunc; //para crear funciones tal que: function fun(parametros){...} -> puede no tener parámetros
parametros: expr (COMA expr)*;
contenidoFunc: LLAVEI ((expr|asignacion) FINLINEA)* LLAVED FINLINEA; //{expresion o asignacion; 0 o N veces};

contenidoBloque: LLAVEI ((expr|asignacion) FINLINEA)* LLAVED; //para los bucles y condiciones

llamarFuncion: variable PARIZ parametros? PARDE; //funcionLLamada(parametros) -> pueden ser 0 o N parámetros

print: PRINT PARIZ expr (COMA expr)* PARDE; //print(expresiones separadas por comas); 1 o N expresiones dentro del print

/* PALABRAS CLAVE */
//Bucles y condicionales:
if: IF condicion contenidoBloque;
elif: ELSE if; // EXTRA
else: ELSE contenidoBloque;
condicion: PARIZ expr(operlogicos|opercomparac)expr* PARDE;
while: WHILE condicion contenidoBloque;
doWhile: DO LLAVEI ((expr|asignacion) FINLINEA)* LLAVED WHILE condicion; // EXTRA
for: FOR PARIZ variable FINLINEA condicion FINLINEA variable incdec PARDE contenidoBloque;
//otros reservados:
val: VAL PARIZ parametroPolinomio(COMA parametroPolinomio)* PARDE;
parametroPolinomio: POLINOMIO|ENTERO|REAL|variable;

//Identificadores de variables
variable: VAR;

/* CONJUNTO DE OPERADORES */
operadicion: sum|restar;
opermultipl: mul|div;
operlogicos: OPAND|OPOR|OPEXC|OPNEG;
opercomparac: OPMAYOR|OPMENOR|OPMAYIG|OPIGUAL|OPMENIG|OPDIST;

/* OPERADORES */
sum: OPS;
restar: OPR;
mul: OPM;
div: OPD;
resto: OPRESTO;
modulo: OPMOD;
elevado: OPE;