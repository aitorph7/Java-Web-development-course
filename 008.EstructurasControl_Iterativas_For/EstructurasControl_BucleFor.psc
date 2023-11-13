Algoritmo EstructurasControl_BucleFor
	
	//Bucle determinado porque ya desde el principio se
	//determina cuantas veces va a iterar con los valores
	//incial (start), final (stop) y paso (step).
	
	Para indice <-0 Hasta 15 Con Paso 1 Hacer
		Escribir "Iteración número " , indice
	Fin Para
	
	Para indice <- 15 Hasta 1 Con Paso -1 Hacer
		Escribir "Cuenta atrás " , indice
	Fin Para
	
	Repetir
		secuencia_de_acciones
	Hasta Que expresion_logica
FinAlgoritmo
//un array puede ser como una variable que puede albergar
//en su interior otras variables.
//La variable numerica puede ser un nombre que nos inventamos
//nosotros.