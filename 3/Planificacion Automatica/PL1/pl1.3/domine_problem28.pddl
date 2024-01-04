(define (problem gripper-durative-actions-problem1)
(:domain gripper-durative-actions)
(:objects
    t1 t2 - transportador
	n0 n1 n2 n3 n4 - numero
    d1 d2 - dron
	gripper_1_left gripper_1_right gripper_2_left gripper_2_right - gripper
	location_deposito loc1 loc2 loc3 loc4 loc5 - location
	box1 box2 box3 box4 box5 box6 box7 box8 - box
	food medicine - type
	person1 person2 person3 person4 person5 - person
	
	)
(:init
	(siguiente n0 n1)
	(siguiente n1 n2)
	(siguiente n2 n3)
	(siguiente n3 n4)

	(carga-actual t1 n0)
    (carga-actual t2 n0)


	(transportador-not-carry t1)
    (transportador-not-carry t2)


    (gripper-assign d1 gripper_1_left)
    (gripper-assign d1 gripper_1_right)
    (gripper-assign d2 gripper_2_left)
    (gripper-assign d2 gripper_2_right)

	(dron-at d1 location_deposito)
    (dron-at d2 location_deposito)

	(free gripper_1_left)
    (free gripper_1_right)
    (free gripper_2_left)
    (free gripper_2_right)

	(transportador-at t1 location_deposito)
	(transportador-at t2 location_deposito)

	(box-type box1 food)
	(box-type box2 medicine)
	(box-type box3 food)
	(box-type box4 medicine)
	(box-type box5 food)
    (box-type box6 medicine)
	(box-type box7 food)
	(box-type box8 medicine)

	(box-at box1 location_deposito)
	(box-at box2 location_deposito)
	(box-at box3 location_deposito)
	(box-at box4 location_deposito)
	(box-at box5 location_deposito)
    (box-at box6 location_deposito)
	(box-at box7 location_deposito)
	(box-at box8 location_deposito)

	(person-at person1 loc2)
	(person-at person2 loc3)
	(person-at person3 loc1)
	(person-at person4 loc3)

	;(person-dont-have person1 food)
	;(person-have person1 medicine)
	;(person-have person2 food)
	;(person-dont-have person2 medicine)
	;(person-dont-have person3 food)
	;(person-have person3 medicine)
	;(person-have person4 food)
	;(person-dont-have person4 medicine)
	;(person-dont-have person5 food)
	;(person-have person5 medicine)


    (person-dont-have person1 food)
	(person-dont-have person1 medicine)
	(person-dont-have person2 food)
	(person-dont-have person2 medicine)
	(person-dont-have person3 food)
	(person-dont-have person3 medicine)
	(person-dont-have person4 food)
	(person-dont-have person4 medicine)

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
	))
)