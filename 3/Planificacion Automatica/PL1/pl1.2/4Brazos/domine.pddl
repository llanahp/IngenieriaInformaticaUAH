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

		(person-has ?person ?type)
		(person-doesnt-have ?person ?type)

		
		(gripper-at ?gripper ?location)
		(free ?gripper)
		(carry ?gripper ?box)

		(gripper-group ?gripper1 ?gripper2 ?gripper3 ?gripper4)
	)

	(:action mover
		:parameters (?gripper1 ?gripper2 ?gripper3 ?gripper4 ?from ?to)
		:precondition (and (location ?from) (location ?to) (gripper ?gripper1) (gripper ?gripper2) (gripper ?gripper3) (gripper ?gripper4)
			(gripper-at ?gripper1 ?from) (gripper-at ?gripper2 ?from) (gripper-at ?gripper3 ?from) (gripper-at ?gripper4 ?from) (gripper-group ?gripper1 ?gripper2 ?gripper3 ?gripper4))
		:effect (and    
			(not(gripper-at ?gripper1 ?from)) (not(gripper-at ?gripper2 ?from)) (not(gripper-at ?gripper3 ?from)) (not(gripper-at ?gripper4 ?from))
			(gripper-at ?gripper1 ?to) (gripper-at ?gripper2 ?to) (gripper-at ?gripper3 ?to) (gripper-at ?gripper4 ?to))
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
		:parameters (?location ?gripper ?box ?person ?type)
		:precondition (and (location ?location) (box ?box)  (gripper ?gripper) (person ?person) (type ?type)
					(gripper-at ?gripper ?location) (person-at ?person ?location) (carry ?gripper ?box)
					(person-doesnt-have ?person ?type) (box-type ?box ?type)
					)
		:effect (and
			(free ?gripper)
			(not (carry ?gripper ?box))
			(person-has ?person ?type)
			(not (person-doesnt-have ?person ?type))
		)
	)
)
