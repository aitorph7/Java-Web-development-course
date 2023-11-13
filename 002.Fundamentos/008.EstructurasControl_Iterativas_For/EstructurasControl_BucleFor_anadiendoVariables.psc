Algoritmo EstructurasControl_bucleFor_anadiendoVariables
	contador <- 0
	acumulador <- 0
	//Pedir al usuario cuantos examenes ha realizado (numero)
	Escribir "¿Cuantos examenes has realizado?: "
	Leer numberOfExamsDone
	Para i <- 1 Hasta numberOfExamsDone Con Paso 1 Hacer
		Escribir "¿que calificacion obtuviste en el examen ", i, "?: "
		Leer notaExamen
		Escribir "Ok, sacaste un ", notaExamen, " en el examen ", i, "."
		acumulador <- acumulador + notaExamen
	Fin Para
	Escribir "Tu nota media es: ", acumulador / numberOfExamsDone
	notaMedia <- acumulador / numberOfExamsDone
	Escribir "tu Nota media redondeada es: ", redon(notaMedia)

FinAlgoritmo
