Algoritmo EstructuraControl_Switch
	Escribir "Introduce un d�a de la semana: (LUNES, MARTES, MI�RCOLES,...)"
	Leer dayName
	dayNumber <- 0
	
	Segun dayName Hacer
		"LUNES":
			dayNumber = 1
		"MARTES":
			dayNumber = 2
		"MI�RCOLES":
			dayNumber = 3
		"JUEVES":
			dayNumber = 4
		"VIERNES":
			dayNumber = 5
		"S�BADO":
			dayNumber = 6
		"DOMINGO":
			dayNumber = 7
		De Otro Modo:
			escribir "Dato incorrecto, por favor escriba de nuevo."
	Fin Segun
Escribir "El n�mero de d�a de la semana es: " , dayNumber
FinAlgoritmo
