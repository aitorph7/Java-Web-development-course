Algoritmo sin_titulo
	Escribir "Introduce un número compuesto (con decimales, please)"
	Leer number
	numeroSinDecimales <- trunc(number)
	sonIguales <- number = numeroSinDecimales
	Si sonIguales Entonces
		Escribir "el número no tiene decimales"
	SiNo
		Escribir "el número sí tiene decimales"
		//Escribir cuales son loes decimales
		//5.99 debería mostrar 0.99
		decimales <- number - numeroSinDecimales
		Escribir "Parte decimal ", decimales
	Fin Si
FinAlgoritmo
