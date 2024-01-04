(define (problem strips-gripper-x-1)
	(:domain gripper-strips-typing)
	(:objects location_1 location_2 location_3 location_4 location_5 location_6 location_deposito
	box_1 box_2 box_3 box_4
	person_1 person_2 person_3
	food medicine
	gripper_1_left gripper_1_right)

	(:init
		(type food)
		(type medicine)

		(gripper gripper_1_left)
		(gripper gripper_1_right)

		(box box_1)
		(box box_2)
		(box box_3)
		(box box_4)

		(location location_1)
		(location location_2)
		(location location_3)
		(location location_4)
		(location location_5)
		(location location_6)
		(location location_deposito)
		
		(person person_1)
		(person person_2)
		(person person_3)

		(gripper-at gripper_1_left location_deposito)
		(gripper-at gripper_1_right location_deposito)

		(free gripper_1_left)
		(free gripper_1_right)

		(gripper-pair gripper_1_left gripper_1_right)
		(gripper-pair gripper_1_right gripper_1_left)

		(box-at box_1 location_deposito)
		(box-at box_2 location_deposito)
		(box-at box_3 location_deposito)
		(box-at box_4 location_deposito)


		(person-at person_1 location_4)
		(person-at person_2 location_5)
		(person-at person_3 location_6)

		(box-type box_1 food)
		(box-type box_2 food)
		(box-type box_3 medicine)
		(box-type box_4 medicine)

		(person-have person_1 food)
		(person-dont-have person_1 medicine)

		(person-have person_2 medicine)
		(person-dont-have person_2 food)

		(person-dont-have person_3 medicine)
		(person-dont-have person_3 food)
	)

	(:goal
		(and
		(person-have person_1 food)
		(person-have person_1 medicine)

		(person-have person_2 food)
		(person-have person_2 medicine)
		
		(person-have person_3 food)
		(person-have person_3 medicine)
		)
	)
)
