(define (domain gripper-strips-typing)
	
	(:predicates
		(person ?person)
		(location ?location)
		(box ?box)
		(type ?type)
		(gripper ?gripper)
		
		(box-at ?box ?location)
		(person-at ?person ?location)

		(box-type ?box ?type)

		(person-have ?person ?type)
		(person-dont-have ?person ?type)

		
		(gripper-at ?gripper ?location)
		(free ?gripper)
		(carry ?gripper ?box)

		(gripper-pair ?gripper1 ?gripper2)
	)

	(:action mover
		:parameters (?gripper_l ?gripper_r ?from ?to)
		:precondition (and (location ?from) (location ?to) (gripper ?gripper_l) (gripper ?gripper_r)
					(gripper-at ?gripper_l ?from) (gripper-at ?gripper_r ?from) (gripper-pair ?gripper_l ?gripper_r))
		:effect (and    
			(not(gripper-at ?gripper_l ?from)) (not(gripper-at ?gripper_r ?from))
			(gripper-at ?gripper_l ?to) (gripper-at ?gripper_r ?to))
	)
	
	(:action take-box
		:parameters (?location ?gripper  ?box)
		:precondition (and (location ?location) (box ?box) (gripper ?gripper) 
					(gripper-at ?gripper ?location) (box-at ?box ?location) (free ?gripper))
		:effect (and    
			(not (free ?gripper))
			(carry ?gripper ?box)
			(not (box-at ?box ?location))
		)
	)

	(:action let-box
		:parameters (?location ?gripper ?box ?person ?tipo)
		:precondition (and (location ?location) (box ?box)  (gripper ?gripper) (person ?person) (type ?tipo)
					(gripper-at ?gripper ?location) (person-at ?person ?location) (carry ?gripper ?box)
					(person-dont-have ?person ?tipo) (box-type ?box ?tipo)
					)
		:effect (and
			(free ?gripper)
			(not (carry ?gripper ?box))
			(person-have ?person ?tipo)
			(not (person-dont-have ?person ?tipo))
		)
	)

	

)