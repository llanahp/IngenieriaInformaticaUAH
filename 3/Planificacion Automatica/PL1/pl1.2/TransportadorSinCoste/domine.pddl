(define (domain gripper-strips-typing)
	(:predicates
		(person ?person)
		(location ?location)
		(box ?box)
		(type ?type)
		(gripper ?gripper)
		(transportador ?transportador)


		(carga-actual ?transportador ?Ncajas)
		(box-at ?box ?location)
		(person-at ?person ?location)

		(box-type ?box ?type)

		(person-have ?person ?type)
		(person-dont-have ?person ?type)


		(transportador-is-carry ?transportador ?gripper)
		(transportador-not-carry ?transportador)		
		(transportador-at ?transportador ?location)

		(siguiente ?numA ?numB)

		(gripper-at ?gripper ?location)
		(free ?gripper)
		(carry ?gripper ?box)

	)
	

	(:action mover-con-transportador
		:parameters (?gripper_l ?transportador ?from ?to)
		:precondition (and (location ?from) (location ?to) (gripper ?gripper_l) (transportador ?transportador)
					(gripper-at ?gripper_l ?from) (transportador-is-carry ?transportador ?gripper_l))
		:effect (and 
			(not(gripper-at ?gripper_l ?from)) 
			(gripper-at ?gripper_l ?to)
			(not(transportador-at ?transportador ?from)) 
			(transportador-at ?transportador ?to))
	)

	(:action mover-sin-transportador
		:parameters (?gripper_l ?transportador ?from ?to)
		:precondition (and (location ?from) (location ?to) (gripper ?gripper_l) (transportador ?transportador)
					(gripper-at ?gripper_l ?from) (transportador-not-carry ?transportador))
		:effect (and 
			(not(gripper-at ?gripper_l ?from)) 
			(gripper-at ?gripper_l ?to))
			
	)

	
	(:action take-box-from-transportador
		:parameters (?location ?gripper ?box ?transportador ?numA ?numB)
		:precondition (and (location ?location) (box ?box) (gripper ?gripper) (transportador ?transportador)
					(gripper-at ?gripper ?location) (box-at ?box ?transportador) (free ?gripper) (transportador-at ?transportador ?location) (carga-actual ?transportador ?numB) (siguiente ?numA ?numB))
		:effect (and
			(not (free ?gripper))
			(carry ?gripper ?box)
			(carga-actual ?transportador ?numA)
			(not (box-at ?box ?transportador))
		)
	)


	(:action take-box-from-floor
		:parameters (?location ?gripper ?box)
		:precondition (and (location ?location) (box ?box) (gripper ?gripper) 
					(gripper-at ?gripper ?location) (box-at ?box ?location) (free ?gripper))
		:effect (and
			(not (free ?gripper))
			(carry ?gripper ?box)
			(not (box-at ?box ?location))
		)
	)

	(:action let-box-in-transportador
		:parameters (?location ?gripper ?box ?transportador ?numA ?numB)
		:precondition (and (location ?location) (box ?box)  (gripper ?gripper) (transportador ?transportador)
					(gripper-at ?gripper ?location) (transportador-at ?transportador ?location)  (carga-actual ?transportador ?numA) (siguiente ?numA ?numB)
				  (carry ?gripper ?box)
					)
		:effect (and
			(free ?gripper)
			(not (carry ?gripper ?box))
			(not(box-at ?box ?transportador))
			(box-at ?box ?transportador)
			(carga-actual ?transportador ?numB)
		)
	)

	(:action let-box-to-person
		:parameters (?location ?gripper ?box ?person ?tipo)
		:precondition (and (location ?location) (box ?box)  (gripper ?gripper) (person ?person) (type ?tipo)
					(gripper-at ?gripper ?location) (person-at ?person ?location)  
					(person-dont-have ?person ?tipo) (box-type ?box ?tipo) (carry ?gripper ?box)
					)
		:effect (and
			(free ?gripper)
			(not (carry ?gripper ?box))
			(person-have ?person ?tipo)
			(not (person-dont-have ?person ?tipo))
		)
		
	)


	(:action take-transportador
		:parameters (?location ?gripper ?transportador)
		:precondition (and (location ?location) (gripper ?gripper) (transportador ?transportador)
					(gripper-at ?gripper ?location) (transportador-at ?transportador ?location) (free ?gripper))
		:effect (and
			(not (free ?gripper))
			(carry ?gripper ?transportador)
			(not (transportador-at ?transportador ?location))
			(transportador-is-carry ?transportador ?gripper)
			(not(transportador-not-carry ?transportador))
		)
	)

	(:action let-transportador
		:parameters (?location ?gripper ?transportador)
		:precondition (and (location ?location) (gripper ?gripper) (transportador ?transportador)
					(gripper-at ?gripper ?location)  (transportador-is-carry ?transportador ?gripper)
				
					)
		:effect (and
			(free ?gripper)
			(not (carry ?gripper ?transportador))
			(transportador-at ?transportador ?location)
			(not (transportador-is-carry ?transportador ?gripper))
			(transportador-not-carry ?transportador)
		)
	)

	

)