(define (problem strips-gripper-x-1)
(:domain gripper-strips-typing)
(:objects
transportador
	n0 n1 n2 n3 n4
		gripper_1_left 
	location_deposito loc1 loc2 loc3 loc4 loc5 
	box1 box2 box3 box4 box5 
	food medicine 
	person1 person2 person3 person4 person5 
	
	)
(:init
	(siguiente n0 n1)
	(siguiente n1 n2)
	(siguiente n2 n3)
	(siguiente n3 n4)

	(carga-actual transportador n0)

	(transportador transportador)

	(transportador-not-carry transportador)

	(gripper gripper_1_left)

	(location location_deposito)
	(location loc1)
	(location loc2)
	(location loc3)
	(location loc4)
	(location loc5)

	(box box1)
	(box box2)
	(box box3)
	(box box4)
	(box box5)

	(type food)
	(type medicine)

	(person person1)
	(person person2)
	(person person3)
	(person person4)
	(person person5)

	(gripper-at gripper_1_left location_deposito)
	(free gripper_1_left)
	(transportador-at transportador location_deposito)

	(box-type box1 food)
	(box-type box2 medicine)
	(box-type box3 food)
	(box-type box4 medicine)
	(box-type box5 food)

	(box-at box1 location_deposito)
	(box-at box2 location_deposito)
	(box-at box3 location_deposito)
	(box-at box4 location_deposito)
	(box-at box5 location_deposito)

	(person-at person1 loc2)
	(person-at person2 loc3)
	(person-at person3 loc1)
	(person-at person4 loc3)
	(person-at person5 loc4)

	(person-dont-have person1 food)
	(person-have person1 medicine)
	(person-have person2 food)
	(person-dont-have person2 medicine)
	(person-dont-have person3 food)
	(person-have person3 medicine)
	(person-have person4 food)
	(person-dont-have person4 medicine)
	(person-dont-have person5 food)
	(person-have person5 medicine)

	(=(cost location_deposito location_deposito) 0)
	(=(cost location_deposito loc1) 80)
	(=(cost location_deposito loc2) 80)
	(=(cost location_deposito loc3) 80)
	(=(cost location_deposito loc4) 80)
	(=(cost location_deposito loc5) 80)
	(=(cost loc1 location_deposito) 80)
	(=(cost loc1 loc1) 0)
	(=(cost loc1 loc2) 20)
	(=(cost loc1 loc3) 20)
	(=(cost loc1 loc4) 20)
	(=(cost loc1 loc5) 20)
	(=(cost loc2 location_deposito) 80)
	(=(cost loc2 loc1) 20)
	(=(cost loc2 loc2) 0)
	(=(cost loc2 loc3) 20)
	(=(cost loc2 loc4) 20)
	(=(cost loc2 loc5) 20)
	(=(cost loc3 location_deposito) 80)
	(=(cost loc3 loc1) 20)
	(=(cost loc3 loc2) 20)
	(=(cost loc3 loc3) 0)
	(=(cost loc3 loc4) 20)
	(=(cost loc3 loc5) 20)
	(=(cost loc4 location_deposito) 80)
	(=(cost loc4 loc1) 20)
	(=(cost loc4 loc2) 20)
	(=(cost loc4 loc3) 20)
	(=(cost loc4 loc4) 0)
	(=(cost loc4 loc5) 20)
	(=(cost loc5 location_deposito) 80)
	(=(cost loc5 loc1) 20)
	(=(cost loc5 loc2) 20)
	(=(cost loc5 loc3) 20)
	(=(cost loc5 loc4) 20)
	(=(cost loc5 loc5) 0)

	(= (total-cost) 0)
)
(:goal (and
	(person-have person1 food)
	(person-have person1 medicine)
	(person-have person2 food)
	(person-have person2 medicine)
	(person-have person3 food)
	(person-have person3 medicine)
	(person-have person4 food)
	(person-have person4 medicine)
	(person-have person5 food)
	(person-have person5 medicine)
	))
	(:metric minimize
	(
		total-cost
	)
	)
)