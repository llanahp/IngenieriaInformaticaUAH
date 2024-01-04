; Booleanos

#lang racket
(define true (lambda (x y) x))

(define false (lambda (x y) y))

(define neg (lambda (x) (x false true)))
                         
(define and (lambda (x y) (x y false)))

(define or (lambda (x y) (x true y)))

; Pares ordenados
              
(define par (lambda (x)
              (lambda (y)
                (lambda (f) (f x y)))))

(define primero (lambda (p) (p true)))

(define segundo (lambda (p) (p false)))

;;;;; Combinador de punto fijo

(define Y
  (lambda (f)
    ((lambda (x) (f (lambda (v) ((x x) v))))
     (lambda (x) (f (lambda (v) ((x x) v)))))))

;;;;;; Orden en naturales y test de nulidad

(define esmenoroigualnat (lambda (n)
                             (lambda (m)
                                (escero ((restanat n) m)))))
                         
(define esmayoroigualnat (lambda (n)
                            (lambda (m)
                               (escero ((restanat m) n)))))
                         
(define esmenornat (lambda (n)
                     (lambda (m)
                       (and ((esmenoroigualnat n) m) (noescero ((restanat m) n))))))

(define esmayornat (lambda (n)
                     (lambda (m)
                       (and ((esmayoroigualnat n) m) (noescero ((restanat n) m))))))

(define esigualnat (lambda (n)
                     (lambda (m)
                       (and ((esmayoroigualnat n) m) ((esmenoroigualnat n) m)))))

(define escero (lambda (n)
                 ((n (lambda (x) false)) true)))

(define noescero (lambda (n)
                    (neg (escero n))))

; Aritmética natural. Se define también comprobar para verificar que la cosa va bien. Defino algunos naturales para hacer comprobaciones. Los escribo en francés para distinguirlos de los enteros 
; que escribiré en español.

(define zero (lambda (f)
               (lambda (x) x)))

(define sucesor (lambda (n)
                  (lambda (f)
                    (lambda (x)
                     (f((n f) x))))))

(define un (sucesor zero))

(define deux (sucesor un))

(define trois (sucesor deux))

(define quatre (sucesor trois))

(define cinq (sucesor quatre))

(define six (sucesor cinq))

(define sept (sucesor six))

(define huit (sucesor sept))

(define neuf (sucesor huit))

(define dix (sucesor neuf))

(define onze (sucesor dix))

(define douze (sucesor onze))

(define treize (sucesor douze))

(define quatorze (sucesor treize))

(define quinze (sucesor quatorze))

(define seize (sucesor quinze))

(define dix-sept (sucesor seize))

(define dix-huit (sucesor dix-sept))

(define dix-neuf (sucesor dix-huit))

(define vingt (sucesor dix-neuf))

(define comprobar (lambda (n)
                    ((n (lambda (x) (+ 1 x))) 0)))

(define sumnat (lambda (n)
                 (lambda (m)
                   ((n (lambda (x) (sucesor x))) m))))

(define prodnat (lambda (n)
                   (lambda (m)
                     (lambda (f)
                       (lambda (x) ((m (n f)) x))))))
                     
(define prefn (lambda (f)
                (lambda (p)
                  ((par (f (primero p))) (primero p)))))

(define predecesor (lambda (n)
                     (lambda (f)
                       (lambda (x)
                            (segundo ((n ((lambda (g)
                                             (lambda (p) ((prefn g) p))) f)) ((par x) x)))))))
                         
(define restanat (lambda (n)
                     (lambda (m)
                        ((m (lambda (x) (predecesor x))) n))))                                                 

(define restonataux
    (lambda (n)
        (lambda (m)
            ((Y (lambda (f)
                 (lambda (x)
                    ((((esmayoroigualnat x) m)  
                        (lambda (no_use)
                            (f ((restanat x) m))
                        )
                        (lambda (no_use)
                            x
                        )
                    )
                        zero)    ; Pasa zero como argumento de no_use
                )
            ))
                n)  ; Pasa n como el valor inicial de x.
        )
))

(define restonat (lambda (n)
                      (lambda (m)
                        (((escero m) (lambda (no_use) false) (lambda (no_use) ((restonataux n) m))) zero))))


(define cocientenataux
    (lambda (n)
        (lambda (m)
            ((Y (lambda (f)
                (lambda (x)
                    ((((esmayoroigualnat x) m)  
                        (lambda (no_use)
                            (sucesor (f ((restanat x) m)))  
                        )
                        (lambda (no_use)
                            zero
                        )
                    )
                        zero)    ; Pasa zero como argumento de no_use
                )
            ))
                n)  ; Pasa n como el valor inicial de x.
        )
    )
)

(define cocientenat (lambda (n)
                      (lambda (m)
                        (((escero m) (lambda (no_use) false) (lambda (no_use) ((cocientenataux n) m))) zero))))


(define mcdnat
    (lambda (n)
        (lambda (m)
            (((Y (lambda (f)
                   (lambda (x)
                     (lambda(y)
                      (((escero y)  
                       (lambda (no_use)
                            x
                        ) 
                       (lambda (no_use)
                            ((f y)((restonat x) y)) 
                        )
                        
                    )
                        zero)    ; Pasa zero como argumento de no_use
                ))
            ))
                n) ; Pasa n como el valor inicial de x.
          m)       ; Pasa m como el valor inicial de y.
    )
))

;;;;;; Definición de algunos enteros

(define cero ((par zero) zero))

(define -uno ((par zero) un))

(define -dos ((par zero) deux))

(define -tres ((par zero) trois))

(define -cuatro ((par zero) quatre))

(define -cinco ((par zero) cinq))

(define -seis ((par zero) six))

(define -siete ((par zero) sept))

(define -ocho ((par zero) huit))

(define -nueve ((par zero) neuf))

(define -diez ((par zero) dix))

(define -once ((par zero) onze))

(define -doce ((par zero) douze))

(define -trece ((par zero) treize))

(define -catorce ((par zero) quatorze))

(define -quince ((par zero) quinze))

(define -dieciseis ((par zero) seize))

(define -diecisiete ((par zero) dix-sept))

(define -dieciocho ((par zero) dix-huit))

(define -diecinueve ((par zero) dix-neuf))

(define -veinte ((par zero) vingt))

(define uno ((par un) zero))

(define dos ((par deux) zero))

(define tres ((par trois) zero))

(define cuatro ((par quatre) zero))

(define cinco ((par cinq) zero))

(define seis ((par six) zero))

(define siete ((par sept) zero))

(define ocho ((par huit) zero))

(define nueve ((par neuf) zero))

(define diez ((par dix) zero))

(define once ((par onze) zero))

(define doce ((par douze) zero))

(define trece ((par treize) zero))

(define catorce ((par quatorze) zero))

(define quince ((par quinze) zero))

(define dieciseis ((par seize) zero))

(define diecisiete ((par dix-sept) zero))

(define dieciocho ((par dix-huit) zero))

(define diecinueve ((par dix-neuf) zero))

(define veinte ((par vingt) zero))

;;;;; Orden, valor absoluto y tests de nulidad, positividad y negatividad. 
;;;
;;; m-n > m'-n' si y solo si m+n' > m'+n e igual con el resto

(define esmayoroigualent (lambda (r)
                           (lambda (s)
                             ((esmayoroigualnat ((sumnat (primero r)) (segundo s))) ((sumnat (primero s)) (segundo r)))))) 

(define esmenoroigualent (lambda (r)
                           (lambda (s)
                             ((esmenoroigualnat ((sumnat (primero r)) (segundo s))) ((sumnat (primero s)) (segundo r))))))

(define esmayorent (lambda (r)
                           (lambda (s)
                             ((esmayornat ((sumnat (primero r)) (segundo s))) ((sumnat (primero s)) (segundo r))))))

(define esmenorent (lambda (r)
                           (lambda (s)
                             ((esmenornat ((sumnat (primero r)) (segundo s))) ((sumnat (primero s)) (segundo r))))))

(define esigualent (lambda (r)
                           (lambda (s)
                             ((esigualnat ((sumnat (primero r)) (segundo s))) ((sumnat (primero s)) (segundo r))))))

(define absoluto (lambda (r)
                    (((esmayoroigualnat (primero r)) (segundo r)) ((par ((restanat (primero r)) (segundo r))) zero) ((par ((restanat (segundo r)) (primero r))) zero))))

(define negativo (lambda (r)
                   ((esmenorent r) cero)))

(define positivo (lambda (r)
                   ((esmayorent r) cero)))

(define esceroent (lambda (r)
                     ((esigualnat (primero r)) (segundo r))))
                      
(define noesceroent (lambda (r)
                       (neg (esceroent r))))

;;;;; Reducción a representante canónico de la clase de equivalencia.

(define reducir (lambda (r)
                  (((esmayoroigualnat (primero r)) (segundo r)) 
                        ((par ((restanat (primero r)) (segundo r))) zero)
                        ((par zero) ((restanat (segundo r)) (primero r))))))

;;;;; Aritmética entera. La respuesta está siempre dada por el representante canónico de la clase de equivalencia. 

(define testenteros (lambda (r)
                      (- (comprobar (primero r)) (comprobar (segundo r)))))

(define sument (lambda (r)
                  (lambda (s)
                    (reducir ((par ((sumnat (primero r)) (primero s))) ((sumnat (segundo r)) (segundo s)))))))

(define prodent (lambda (r)
                  (lambda (s)
                    (reducir ((par ((sumnat ((prodnat (primero r)) (primero s))) ((prodnat (segundo r)) (segundo s))))
                          ((sumnat ((prodnat (primero r)) (segundo s))) ((prodnat (segundo r)) (primero s))))))))                       

(define restaent (lambda (r)
                   (lambda (s)
                     (reducir ((par ((sumnat (primero r)) (segundo s))) ((sumnat (segundo r)) (primero s)))))))

;; Lo siguiente reduce la división de enteros a división de naturales. Si m \ge 0 y n> 0, y si q y r son cociente y resto de la división de m entre n, se tiene
;;  m  = q       * n        + r
;;  m  = (-q)    * (-n)     + r
;; -m  = (-(q+1))* n        + (n-r)
;; -m  = (q+1)   * (-n)     + (n-r),
;; siempre y cuando el resto no sea cero. Cuando el divisor es cero, la función cocienteent devuelve false.

(define cocienteent_aux (lambda (r)
                          (lambda (s)
                            ((cocientenat (primero (absoluto r))) (primero (absoluto s))))))

; Caso1: resto cero. Si m= q*n, entonces -m= (-q)*n, -m = q* (-n) y m= (-q)*(-n).

(define cocienteentaux-caso1 (lambda (r)
                               (lambda (s)
                                  ((or (and ((esmayoroigualent r) cero) (positivo s)) (and (negativo r) (negativo s))) ((par ((cocientenat (primero (absoluto r))) (primero (absoluto s)))) zero)
                                                                                                                       ((par zero) ((cocientenat (primero (absoluto r))) (primero (absoluto s))))))))
                              
; Caso 2: resto no nulo

(define cocienteentaux-caso2 (lambda (r)
                                (lambda (s)
                                    (((esmayoroigualent r) cero) ((positivo s) ((par ((cocienteent_aux r) s)) zero) ((par zero) ((cocienteent_aux r) s)))
                                                                 ((positivo s) ((par zero) (sucesor ((cocienteent_aux r) s))) ((par (sucesor ((cocienteent_aux r) s))) zero))))))
; Cociente cuando no hay división por cero

(define cocienteentaux (lambda (r)
                         (lambda (s)
                           ((escero ((restonat (primero (absoluto r))) (primero (absoluto s)))) ((cocienteentaux-caso1 r) s) ((cocienteentaux-caso2 r) s)))))

; Cociente considerando la división por cero

(define cocienteent (lambda (r)
                      (lambda (s)
                        (((esceroent s) (lambda (no_use) false) (lambda (no_use) ((cocienteentaux r) s))) zero))))

; Resto. Si se divide por cero, devuelve false

(define restoentaux1 (lambda (r)
                        (lambda (s)
                          ((or (and ((esmayoroigualent r) cero) (positivo s)) (and ((esmayoroigualent r) cero) (negativo s))) ((par ((restonat (primero (absoluto r))) (primero (absoluto s)))) zero)
                                                                                                           ((par ((restanat (primero (absoluto s)))((restonat (primero (absoluto r))) (primero (absoluto s))))) zero)))))

(define restoentaux (lambda (r)
                       (lambda (s)
                          ((escero ((restonat (primero (absoluto r))) (primero (absoluto s)))) cero ((restoentaux1 r) s)))))

(define restoent (lambda (r)
                      (lambda (s)
                        (((esceroent s) (lambda (no_use) false) (lambda (no_use) ((restoentaux r) s))) zero))))

;; Como mcd (r,s)=mcd(|r|,|s|), se tiene

(define mcdent (lambda (r)
                 (lambda (s)
                   ((par ((mcdnat (primero (absoluto r))) (primero (absoluto s)))) zero))))
;----------------------------------------------------------------------------------------------------------------------------------------------------------------

;-----------------------------------------------------------------
; Operaciones auxiliares con listas
;-----------------------------------------------------------------
(define comprobar-lista (lambda (l)
             (if (= (comprobar (longitud l)) 0)
                          '()
                  (cons (testenteros (cabeza l)) (comprobar-lista (cola l))))))


(define vacia (lambda (x) x))
(define construir (lambda (x)
                    (lambda (y)
                      ((par false) ((par x) y)))))

;-----------------------------------------------------------------
;Concatenar dos listas
;-----------------------------------------------------------------
(define concatenar
    (lambda (l1)
        (lambda (l2)
            (((Y (lambda (f)
                   (lambda (x)
                     (lambda (y)
                      (((vacia? x)
                       (lambda (no_use) y );devolvemos lista contenida en y si x es vacia
                       (lambda (no_use) ((construir (cabeza x)) ((f (cola x)) y)) ;añadimos cabeza y recursion si x no vacia
                        ))zero)  ; zero como argumento de no_use
                ))))  l1) ; establecemos l1 al valor inicial de x.
          l2)  ; establecemos l2 al valor inicial de y.
    )))

;-----------------------------------------------------------------
;Maximo de una lista
;-----------------------------------------------------------------
(define maximo
    (lambda (l)
            ((Y (lambda (f)
                   (lambda (x)
                      (((vacia? (cola x))
                       (lambda (no_use) (cabeza x) ) ;devolvemos la cabeza
                       (lambda (no_use)
                            ((((esmayorent (cabeza x)) (f (cola x)))  ;llamada recursiva usando Y
                             (lambda (no_use) (cabeza x) ) ;devolvemos valor de la cabeza
                             (lambda (no_use) (f (cola x)) );devolvemos el valor recursivo                
                           ) zero) ;argumento de no_use para cumplir aridad
                       )
                    ) zero) )))
          l)  ; Pasamos la lista al valor inicial de x.
 ))

;-----------------------------------------------------------------
;Minimo de una lista
;-----------------------------------------------------------------
(define minimo
    (lambda (l)
            ((Y (lambda (f)
                   (lambda (x)
                      (((vacia? (cola x))
                       (lambda (no_use) (cabeza x) ) ;devolvemos la cabeza
                       (lambda (no_use)
                            ((((esmayorent (cabeza x)) (f (cola x)))  ;llamada recursiva usando Y
                              ;invertimos resultado de condicion respecto al maximo
                             (lambda (no_use) (f (cola x)) );devolvemos el valor recursivo 
                             (lambda (no_use) (cabeza x) ) ;devolvemos valor de la cabeza            
                           ) zero) ;argumento de no_use para cumplir aridad
                       )
                    ) zero) )))
          l)  ; Pasamos la lista al valor inicial de x.
 ))

;-----------------------------------------------------------------
;Calcular la longitud de una lista
;-----------------------------------------------------------------
(define longitud
  (lambda (l)
      ((Y (lambda (f)
         (lambda (x)
          (((vacia? x)
            (lambda (no_use)
              zero
            )
            (lambda (no_use)
              ((sumnat un) (f (cola x)))
            )
          )
            zero)  ; Pasa zero como argumento de no_use
        )
      ))
        l) ; Pasa l como el valor inicial de x.
    )
)

;-----------------------------------------------------------------
; Suma de enteros de una lista
;-----------------------------------------------------------------
(define suma-lista (lambda(l)
                      ((Y (lambda (f)
                            (lambda (x)
                              (((novacia? x)
                                  (lambda (no_use) ((sument (cabeza x)) (f (cola x))))
                                  (lambda (no_use) cero)
                                )
                               zero)
                              )))
                       l)
                     ))


;-----------------------------------------------------------------
; Invertir el orden de una lista
;-----------------------------------------------------------------
(define invertir-lista (lambda(l)
                      ((Y (lambda (f)
                            (lambda (x)
                              (((novacia? x)
                                  (lambda (no_use) ((concatenar (f (cola x))) ((construir (cabeza x)) vacia)))
                                  (lambda (no_use) x)
                                )
                               x))))
                       l)))


;-----------------------------------------------------------------
; Ordenar una lista (merge-short)
;-----------------------------------------------------------------
(define (crear-lista-n n lista)
  (cond ((or (vacia? lista) (<= n 0))
         vacia)
        (else ((construir (cabeza lista))
               (crear-lista-n (- n 1) (cola lista))))))  




(define (crear-lista-desde-n n lista)
  (cond ((<= n 0)
         crear-lista-n (longitud lista) lista)
        (else
               (crear-lista-desde-n (- n 1) (cola lista)))))

(define (merge left right)
     ((vacia? left) right ((vacia? right) left
           (((esmenorent (cabeza left)) (cabeza right))
             ((concatenar left) right)
             ((concatenar right) left)
          ))))

(define merge-sort
  (lambda (lst)
    (cond ((<= (comprobar (longitud lst)) 1) lst)
          (else
           (let ((mid (quotient (comprobar(longitud lst)) 2)))
             (let ((left (crear-lista-n mid lst ))
                   (right (crear-lista-desde-n mid lst)))
               (merge (merge-sort left) (merge-sort right)))))
          )))

(define ordenar
  (lambda (l)
    (merge-sort l)))
   

;-----------------------------------------------------------------
; Se comprueba si un numero pertence a una lista
;-----------------------------------------------------------------

   
; Test de pertenencia.
(define pertenece?
    (lambda (v)
        (lambda (l)
            (((Y (lambda (f)
                   (lambda (x)
                     (lambda (y)
                      (((vacia? y)
                       (lambda (no_use)
                            false
                        )
                       (lambda (no_use)
                            ((((esigualent x) (cabeza y))  
                             (lambda (no_use)
                                  true
                              ) 
                             (lambda (no_use)
                                  ((f x) (cola y))
                              )
                        
                           )
                              zero) ; Pasa zero como argumento de no_use
                       )
                    )
                        zero) ; Pasa zero como argumento de no_use
                ))
            )) 
                v)  ; Pasa v como el valor inicial de x.
          l)        ; Pasa l como el valor inicial de y.
    )
))

;-----------------------------------------------------------------
; Suma de los elementos de dos listas con la misma Long
;-----------------------------------------------------------------

(define suma-Listas ;Se tiene el operador de punto fijo (f), con el agurmento x
  (lambda (l1)   
    (lambda (l2)   
      ((Y (lambda (f)   ;Se tiene el operador de punto fijo (f), con el agurmento x
            (lambda (x)
              ((Y (lambda (f2) ;Se tiene el operador de punto fijo (f2), con el agurmento y
                    (lambda(y)
                      (((vacia? x)
                        (lambda (no_use)
                          vacia
                          )
                        (lambda (no_use)
                          (aux-suma-listas x y f f2)))
                       zero)             
                      )
                    ))
               l1)  ; n como valor inicial de y.
              )
            ))l2); 1 como valor inicial de y.
      )
    )
  )


(define (aux-suma-listas x y f f2)
   (if (not (equal? (comprobar (longitud x)) (comprobar (longitud y))))
       (f2 (cola y)) ;quita la cabeza de y (lista l1)
       (if (not (equal? (comprobar (longitud x)) 1))
           ((construir ((sument (cabeza x)) (cabeza y))) (f (cola x)))
           ((construir ((sument (cabeza x)) (cabeza y))) vacia))))

;----------------------------------------------------------------------------------------------------------------------------------------------------------------
;listas codificadas
(define lista-1 ((construir uno) vacia))
(define lista-2 ((construir tres) ((construir uno) vacia)))
(define lista-3 ((construir diecisiete) ((construir veinte) ((construir dos) ((construir doce) ((construir seis) vacia))))))
(define lista-4 ((construir quince) ((construir diez) ((construir doce) ((construir nueve) ((construir seis) ((construir siete) vacia)))))))
(define lista-5 ((construir siete) ((construir cero) ((construir doce) ((construir diez) ((construir quince) ((construir uno) vacia)))))))


;operaciones de listas
(define vacia? (lambda (x) (primero x)))
(define novacia? (lambda (x) (neg(vacia? x))))
(define cabeza (lambda (z) (primero (segundo z))))
(define cola (lambda (z) (segundo (segundo z))))


;Interfaz
;----------------------------------------------------------------------------------------------------------------------------------------------------------------
(define (pedir-numero)
  (display "Listas disponibles:")(newline)
  (display "lista-1: '(1)")(newline)
  (display "lista-2: '(3, 1)")(newline)
  (display "lista-3: '(17, 20, 2, 12, 6)")(newline)
  (display "lista-4: '(15, 10, 12, 9, 6, 7)")(newline)
  (newline)
  (display "Operaciones:")(newline)
  (display "1. Longitud") (newline)
  (display "2. Concatenar") (newline)
  (display "3. Invertir") (newline)
  (display "4. Sumar lista") (newline)
  (display "5. Maximo de lista") (newline)
  (display "6. Minimo de lista") (newline)
  (display "7. Ordenar lista") (newline)
  (display "8. Sumar listas") (newline)
  (display "9. Pertenencia de numero en lista") (newline)
  (display "Introduzca un número (1, 2, 3, 4, 5, 6, 7 , 8 o 9): ")
  (read))

(define (interfaz)
  (let ((numero (pedir-numero)))
    (cond ((= numero 1) (opciones 1))
          ((= numero 2) (opciones 2))
          ((= numero 3) (opciones 3))
          ((= numero 4) (opciones 4))
          ((= numero 5) (opciones 5))
          ((= numero 6) (opciones 6))
          ((= numero 7) (opciones 7))
          ((= numero 8) (opciones 8))
          ((= numero 9) (opciones 9))
          (else (display "Número inválido")))))

(define (opciones opcion)
  (cond ((= opcion 1)
         (display "Calcular Longitud: ")(newline)
         (display "Ahora elige una lista (1, 2, 3 o 4): ")
         (let ((numero (read)))
           (display " longitud= ")
           (cond ((= numero 1) (comprobar (longitud lista-1)))
                 ((= numero 2) (comprobar (longitud lista-2)))
                 ((= numero 3) (comprobar (longitud lista-3)))
                 ((= numero 4) (comprobar (longitud lista-4)))
                 (else (display "Número inválido")))))

        ((= opcion 2)
         (display "Concatenar listas: ") (newline)
         (display "Ahora elige una lista (1, 2, 3 o 4): ")
         (let ((numero (read)))
         (cond ((= numero 1) 
                (display "y otra lista para concatenar: ")
                (let ((numero (read)))
                  (display " concatenacion= ")
                  (cond ((= numero 1) (comprobar-lista ((concatenar lista-1) lista-1)))
                        ((= numero 2) (comprobar-lista ((concatenar lista-1) lista-2)))
                        ((= numero 3) (comprobar-lista ((concatenar lista-1) lista-3)))
                        ((= numero 4) (comprobar-lista ((concatenar lista-1) lista-4)))
                        (else (display "Número inválido"))))
                              )
               ((= numero 2)
                (display "y otra lista para concatenar: ")
                (let ((numero (read)))
                  (display " concatenacion= ")
                  (cond ((= numero 1) (comprobar-lista ((concatenar lista-2) lista-1)))
                        ((= numero 2) (comprobar-lista ((concatenar lista-2) lista-2)))
                        ((= numero 3) (comprobar-lista ((concatenar lista-2) lista-3)))
                        ((= numero 4) (comprobar-lista ((concatenar lista-2) lista-4)))
                        (else (display "Número inválido"))))
                              )
               ((= numero 3)
                (display "y otra lista para concatenar: ")
                (let ((numero (read)))
                  (display " concatenacion= ")
                  (cond ((= numero 1) (comprobar-lista ((concatenar lista-3) lista-1)))
                        ((= numero 2) (comprobar-lista ((concatenar lista-3) lista-2)))
                        ((= numero 3) (comprobar-lista ((concatenar lista-3) lista-3)))
                        ((= numero 4) (comprobar-lista ((concatenar lista-3) lista-4)))
                        (else (display "Número inválido"))))
                              )
               ((= numero 4)
                (display "y otra lista para concatenar: ")
                (let ((numero (read)))
                  (display " concatenacion= ")
                  (cond ((= numero 1) (comprobar-lista ((concatenar lista-4) lista-1)))
                        ((= numero 2) (comprobar-lista ((concatenar lista-4) lista-2)))
                        ((= numero 3) (comprobar-lista ((concatenar lista-4) lista-3)))
                        ((= numero 4) (comprobar-lista ((concatenar lista-4) lista-4)))
                        (else (display "Número inválido"))))
                              )
               (else (display "Número inválido")))))

        ((= opcion 3)
         (display "Invertir lista: ")(newline)
         (display "Ahora elige una lista (1, 2, 3 o 4): ")
         (let ((numero (read)))
           (display " inversion= ")
           (cond ((= numero 1) (comprobar-lista (invertir-lista lista-1)))
                 ((= numero 2) (comprobar-lista (invertir-lista lista-2)))
                 ((= numero 3) (comprobar-lista (invertir-lista lista-3)))
                 ((= numero 4) (comprobar-lista (invertir-lista lista-4)))
                 (else (display "Número inválido"))))
         
         )




         ((= opcion 4)
         (display "Sumar lista: ")(newline)
         (display "Ahora elige una lista (1, 2, 3 o 4): ")
         (let ((numero (read)))
           (display " sumar= ")
           (cond ((= numero 1) (testenteros (suma-lista lista-1)))
                 ((= numero 2) (testenteros (suma-lista lista-2)))
                 ((= numero 3) (testenteros (suma-lista lista-3)))
                 ((= numero 4) (testenteros (suma-lista lista-4)))
                 (else (display "Número inválido"))))
         
         )

         ((= opcion 5)
         (display "Maximo de lista: ")(newline)
         (display "Ahora elige una lista (1, 2, 3 o 4): ")
         (let ((numero (read)))
           (display " maximo= ")
           (cond ((= numero 1) (testenteros (maximo lista-1)))
                 ((= numero 2) (testenteros (maximo lista-2)))
                 ((= numero 3) (testenteros (maximo lista-3)))
                 ((= numero 4) (testenteros (maximo lista-4)))
                 (else (display "Número inválido"))))
     
         )

         ((= opcion 6)
         (display "Minimo de lista: ")(newline)
         (display "Ahora elige una lista (1, 2, 3 o 4): ")
         (let ((numero (read)))
           (display " minimo= ")
           (cond ((= numero 1) (testenteros (minimo lista-1)))
                 ((= numero 2) (testenteros (minimo lista-2)))
                 ((= numero 3) (testenteros (minimo lista-3)))
                 ((= numero 4) (testenteros (minimo lista-4)))
                 (else (display "Número inválido"))))
     
         )

          ((= opcion 7)
         (display "Ordenar lista: ")(newline)
         (display "Ahora elige una lista (1, 2, 3 o 4): ")
         (let ((numero (read)))
           (display " ordenar= ")
           (cond ((= numero 1) (comprobar-lista (ordenar lista-1)))
                 ((= numero 2) (comprobar-lista (ordenar lista-2)))
                 ((= numero 3) (comprobar-lista (ordenar lista-3)))
                 ((= numero 4) (comprobar-lista (ordenar lista-4)))
                 (else (display "Número inválido")))))


         ((= opcion 8)
         (display "Sumar listas: ") (newline)
         (display "Ahora elige una lista (1, 2, 3 o 4): ")
         (let ((numero (read)))
         (cond ((= numero 1) 
                (display "y otra lista para sumar: ")
                (let ((numero (read)))
                  (display " Resultado de la suma= ")
                  (cond ((= numero 1) (comprobar-lista ((suma-Listas lista-1) lista-1)))
                        ((= numero 2) (comprobar-lista ((suma-Listas lista-1) lista-2)))
                        ((= numero 3) (comprobar-lista ((suma-Listas lista-1) lista-3)))
                        ((= numero 4) (comprobar-lista ((suma-Listas lista-1) lista-4)))
                        (else (display "Número inválido"))))
                              )
               ((= numero 2)
                (display "y otra lista para sumar: ")
                (let ((numero (read)))
                  (display "  Resultado de la suma= ")
                  (cond ((= numero 1) (comprobar-lista ((suma-Listas lista-2) lista-1)))
                        ((= numero 2) (comprobar-lista ((suma-Listas lista-2) lista-2)))
                        ((= numero 3) (comprobar-lista ((suma-Listas lista-2) lista-3)))
                        ((= numero 4) (comprobar-lista ((suma-Listas lista-2) lista-4)))
                        (else (display "Número inválido"))))
                              )
               ((= numero 3)
                (display "y otra lista para sumar: ")
                (let ((numero (read)))
                  (display "  Resultado de la suma= ")
                  (cond ((= numero 1) (comprobar-lista ((suma-Listas lista-3) lista-1)))
                        ((= numero 2) (comprobar-lista ((suma-Listas lista-3) lista-2)))
                        ((= numero 3) (comprobar-lista ((suma-Listas lista-3) lista-3)))
                        ((= numero 4) (comprobar-lista ((suma-Listas lista-3) lista-4)))
                        (else (display "Número inválido"))))
                              )
               ((= numero 4)
                (display "y otra lista para sumar: ")
                (let ((numero (read)))
                  (display " Resultado de la suma= ")
                  (cond ((= numero 1) (comprobar-lista ((suma-Listas lista-4) lista-1)))
                        ((= numero 2) (comprobar-lista ((suma-Listas lista-4) lista-2)))
                        ((= numero 3) (comprobar-lista ((suma-Listas lista-4) lista-3)))
                        ((= numero 4) (comprobar-lista ((suma-Listas lista-4) lista-4)))
                        (else (display "Número inválido"))))
                              )
               (else (display "Número inválido")))))

         ((= opcion 9)
         (display "c: ") (newline)
         (display "Elige una lista (1, 2, 3 o 4): ")
         (let ((numero (read)))
         (cond ((= numero 1) 
                (display "elige un numero de la lista (1, 2, 3 o 4): ")
                (let ((numero (read)))
                  (display " Pertence= ")
                  (cond ((= numero 1)  (if ( equal? ((pertenece? uno) lista-1) true ) (display "True") (display "False")))
                        ((= numero 2)  (if ( equal? ((pertenece? dos) lista-1) true ) (display "True") (display "False")))
                        ((= numero 3)  (if ( equal? ((pertenece? tres) lista-1) true ) (display "True") (display "False")))
                        ((= numero 4)  (if ( equal? ((pertenece? cuatro) lista-1) true ) (display "True") (display "False")))
                        (else (display "Número inválido"))))
                              )
               ((= numero 2)
                (display "elige un numero de la lista (1, 2, 3 o 4): ")
                (let ((numero (read)))
                  (display " Pertence= ")
                  (cond ((= numero 1)  (if ( equal? ((pertenece? uno) lista-2) true ) (display "True") (display "False")))
                        ((= numero 2)  (if ( equal? ((pertenece? dos) lista-2) true ) (display "True") (display "False")))
                        ((= numero 3)  (if ( equal? ((pertenece? tres) lista-2) true ) (display "True") (display "False")))
                        ((= numero 4)  (if ( equal? ((pertenece? cuatro) lista-2) true ) (display "True") (display "False")))
                        (else (display "Número inválido"))))
                              )
               ((= numero 3)
                (display "elige un numero de la lista (1, 2, 3 o 4): ")
                (let ((numero (read)))
                  (display " Pertence= ")
                  (cond ((= numero 1)  (if ( equal? ((pertenece? uno) lista-3) true ) (display "True") (display "False")))
                        ((= numero 2)  (if ( equal? ((pertenece? dos) lista-3) true ) (display "True") (display "False")))
                        ((= numero 3)  (if ( equal? ((pertenece? tres) lista-3) true ) (display "True") (display "False")))
                        ((= numero 4)  (if ( equal? ((pertenece? cuatro) lista-3) true ) (display "True") (display "False")))
                        (else (display "Número inválido"))))
                              )
               ((= numero 4)
                (display "elige un numero de la lista: ")
                (let ((numero (read)))
                  (display " Pertence= ")
                  (cond ((= numero 1)  (if ( equal? ((pertenece? uno) lista-4) true ) (display "True") (display "False")))
                        ((= numero 2)  (if ( equal? ((pertenece? dos) lista-4) true ) (display "True") (display "False")))
                        ((= numero 3)  (if ( equal? ((pertenece? tres) lista-4) true ) (display "True") (display "False")))
                        ((= numero 4)  (if ( equal? ((pertenece? cuatro) lista-4) true ) (display "True") (display "False")))
                        (else (display "Número inválido"))))
                              )
               (else (display "Número inválido"))))))) 




