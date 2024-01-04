(define 
	(domain gripper-durative-actions)
	(:requirements :strips :fluents :typing :durative-actions)
	(:types
		person location box type dron gripper transportador numero - object
	)


	(:predicates
		
		(carga-actual ?t - transportador ?Ncajas - numero)
		(box-at ?b - box ?l - location)
		(person-at ?p - person ?l - location)

		(box-type ?b - box ?ty - type)

		(person-have ?p - person ?ty - type)
		(person-dont-have ?p - person ?ty - type)


		(transportador-is-carry ?t - transportador ?g - gripper)
		(transportador-not-carry ?t - transportador)		
		(transportador-at ?t - transportador ?l - location)

		(siguiente ?numA - numero ?numB - numero)

		(gripper-assign ?d - dron ?g - gripper)
		(dron-at ?d - dron ?l - location)
		(free ?g - gripper)
		(carry ?g - gripper ?b - box)
		(carryt ?g - gripper ?t - transportador)

	)
	
	(:functions
		(total-cost)
		(cost ?location1 ?location2)
	)

	(:durative-action mover-con-transportador
		:parameters (?d - dron ?g - gripper ?t - transportador ?from - location ?to - location)
		:duration (= ?duration 5)
		:condition (and (at start (and 
					(dron-at ?d ?from)
					(gripper-assign ?d ?g) 
					(transportador-is-carry ?t ?g)))
		)
		:effect (and 
			(at start (and (not (dron-at ?d ?from)) 
					  (not (transportador-at ?t ?from)))
			)
			(at end (and
				(dron-at ?d ?to)
				(transportador-at ?t ?to))
			))
	)

	; (:durative-action mover-sin-transportador
	; 	:parameters (?d - dron ?g - gripper ?t - transportador ?from - location ?to - location)
	; 	:duration (= ?duration 5)
	; 	:condition (and (at start (and 
	; 					(dron-at ?d ?from)
	; 					(gripper-assign ?d ?g)  
	; 					(transportador-not-carry ?t))
	; 		))
	; 	:effect (and 
	; 			(at start (and
	; 				(not(dron-at ?d ?from)))
	; 			)
	; 			(at end(dron-at ?d ?to)
	; 			))
	; )
	
	(:durative-action take-box-from-transportador
		:parameters (?d - dron ?l - location ?g - gripper ?b - box ?t - transportador ?numA - numero ?numB - numero)
		:duration (= ?duration 5)
		:condition (and (at start (and 
					(dron-at ?d ?l) 
					(gripper-assign ?d ?g) 
					(box-at ?b ?l) 
					(free ?g) 
					(transportador-at ?t ?l) 
					(carga-actual ?t ?numB) 
					(siguiente ?numA ?numB))
		))
		:effect (and 
			(at start (and 
				(not (free ?g))
				(carry ?g ?b) 
				(carga-actual ?t ?numA))
			)
			(at end (and
				(not (box-at ?b ?l))))
		)
	)


	(:durative-action take-box-from-floor
		:parameters (?d - dron ?l - location ?g - gripper ?b - box)
		:duration (= ?duration 5)
		:condition (and (at start (and 
			(dron-at ?d ?l) 
			(gripper-assign ?d ?g) 
			(box-at ?b ?l) 
			(free ?g))))

		:effect (and (at start (and
			(not (free ?g))
			(carry ?g ?b)
		))
		(at end (and 
		(not (box-at ?b ?l))
		)))	
	)

	(:durative-action let-box-in-transportador
		:parameters (?d - dron ?l - location ?g - gripper ?b - box ?t - transportador ?numA - numero ?numB - numero)
		:duration (= ?duration 5)
		:condition (and (at start (and 
					(dron-at ?d ?l)
					(gripper-assign ?d ?g) 
					(transportador-at ?t ?l)  
					(carga-actual ?t ?numA) 
					(siguiente ?numA ?numB)
				    (carry ?g ?b))
		))
		:effect (and 
		(at start (and
			(free ?g)
			(not (carry ?g ?b)))
		)
		(at end (and
			(box-at ?b ?l)
			(carga-actual ?t ?numB)
		)))
	)

	(:durative-action let-box-to-person
		:parameters (?d - dron ?l - location ?g - gripper ?b - box ?p - person ?ty - type)
		:duration(= ?duration 5)
		:condition (and (at start (and 
					(dron-at ?d ?l)
					(gripper-assign ?d ?g) 
					(person-at ?p ?l)  
					(person-dont-have ?p ?ty) 
					(box-type ?b ?ty) 
					(carry ?g ?b)
					)))
		:effect (and (at start (and
			(free ?g)
			(not (carry ?g ?b)))
		)
		(at end (and	
			(person-have ?p ?ty)
			(not (person-dont-have ?p ?ty))
		)))
	)


	(:durative-action take-transportador
		:parameters (?l - location ?g - gripper ?d - dron ?t - transportador)
		:duration (= ?duration 5)
		:condition (and (at start (and 
					(dron-at ?d ?l)
					(gripper-assign ?d ?g) 
					(transportador-at ?t ?l) 
					(free ?g))))
		:effect (and (at start (and
			(not (free ?g))
			(carryt ?g ?t)
			)
		)
		(at end (and 
			(not (transportador-at ?t ?l))
			(transportador-is-carry ?t ?g)
			(not(transportador-not-carry ?t))
		)))
	)

	(:durative-action let-transportador
		:parameters (?d - dron ?l - location ?g - gripper ?t - transportador)
		:duration (= ?duration 5)
		:condition (and (at start (and
					(dron-at ?d ?l)
					(gripper-assign ?d ?g) 
					(transportador-is-carry ?t ?g)))
		)
		:effect (and (at start (and
			(free ?g)
			(not (carryt ?g ?t))
			
		))
		(at end (and 
			(transportador-at ?t ?l)
			(not (transportador-is-carry ?t ?g))
			(transportador-not-carry ?t)
		)))
	)

)