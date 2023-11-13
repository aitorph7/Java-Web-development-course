Algoritmo EstructuraControl_Switch
	Escribir "Introduce un día de la semana: (LUNES, MARTES, MIÉRCOLES,...)"
	Leer dayName
	dayNumber <- 0
	
	Segun dayName Hacer
		"LUNES":
			dayNumber = 1
		"MARTES":
			dayNumber = 2
		"MIÉRCOLES":
			dayNumber = 3
		"JUEVES":
			dayNumber = 4
		"VIERNES":
			dayNumber = 5
		"SÁBADO":
			dayNumber = 6
		"DOMINGO":
			dayNumber = 7
		De Otro Modo:
			escribir "Dato incorrecto, por favor escriba de nuevo."
	Fin Segun
Escribir "El número de día de la semana es: " , dayNumber
FinAlgoritmo
