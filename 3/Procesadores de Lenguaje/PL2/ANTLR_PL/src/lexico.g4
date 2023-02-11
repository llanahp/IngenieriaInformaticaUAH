lexer grammar lexico;

/* PALABRAS CLAVE */
LET:'let';
IF:'if';
ELSE:'else'; // EXTRA
WHILE:'while';
DO:'do'; // EXTRA
FOR:'for'; // EXTRA
FUNC:'function';
RETURN:'return';
VAL:'val';

/* FUNCION INTEGRADA */
PRINT:'print';

/* OPERADORES */
PARIZ:'(';
PARDE:')';
LLAVEI:'{';
LLAVED:'}';
OPR:'-';
OPS:'+';
OPM:'*';
OPD:'/';
OPE:'^';
OPRESTO:'%';
OPMOD:'//'; // EXTRA - MODULO
OPAND:'&&';
OPOR:'||';
OPEXC:'##';
OPNEG: '!';
OPMAYOR:'>';
OPMENOR:'<';
OPMAYIG:'>=';
OPMENIG:'<=';
OPIGUAL:'==';
OPDIST:'!=';
IGUAL:'=';
INCREMENTO:'++';
DECREMENTO: '--';

/* SEPARADORES */
PUNTO:'.';
COMA:',';
FINLINEA:';';

/* TIPOS DE DATOS */
ENTERO:(SIGNO)?NUM+; // EXTRA
REAL:(SIGNO?NUM)*((PUNTO)NUM+);
fragment NUM: [0-9];
TEXTO:'"' .*? '"';
VAR:[a-z][a-zA-Z0-9_]*;
MONOMIO: (NUM|VAR)(OPE(NUM|VAR))?;
POLINOMIO: '\'' SIGNO?MONOMIO((SIGNO)MONOMIO)* '\'';
fragment SIGNO: (OPS|OPR);

/* COMENTARIOS */
COMENTLINC:'%%%' .*? '\n'->skip;
COMENTARIO:COM .*? COM->skip;
fragment COM:'***';


/* SKIPEAR */
WS:[ \t\r\n]->skip;

