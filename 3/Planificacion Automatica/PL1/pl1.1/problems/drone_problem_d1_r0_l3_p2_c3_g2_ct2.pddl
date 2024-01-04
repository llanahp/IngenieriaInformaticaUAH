(define (problem strips-gripper-x-1)
(:domain gripper-strips-typing)
(:objects
	gripper_1_left gripper_1_right 
	location_deposito loc1 loc2 loc3 
	box1 box2 box3 
	food medicine 
	person1 person2 
	
	)
(:init
	(gripper gripper_1_left)
	(gripper gripper_1_right)

	(location location_deposito)
	(location loc1)
	(location loc2)
	(location loc3)

	(box box1)
	(box box2)
	(box box3)

	(type food)
	(type medicine)

	(person person1)
	(person person2)

	(gripper-at gripper_1_left location_deposito)
	(gripper-at gripper_1_right location_deposito)

	(free gripper_1_left)
	(free gripper_1_right)

	(gripper-pair gripper_1_right gripper_1_left)
	(gripper-pair gripper_1_left gripper_1_right)

	(box-type box1 food)
	(box-type box2 medicine)
	(box-type box3 food)

	(box-at box1 location_deposito)
	(box-at box2 location_deposito)
	(box-at box3 location_deposito)

	(person-at person1 loc1)
	(person-at person2 loc1)

	(person-dont-have person1 food)
	(person-have person1 medicine)
	(person-have person2 food)
	(person-dont-have person2 medicine)

)
(:goal (and
	(person-have person1 food)
	(person-have person1 medicine)
	(person-have person2 food)
	(person-have person2 medicine)
	))
)
