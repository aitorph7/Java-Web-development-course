Algoritmo sin_titulo
	Escribir "Introduce un n�mero compuesto (con decimales, please)"
	Leer number
	numeroSinDecimales <- trunc(number)
	sonIguales <- number = numeroSinDecimales
	Si sonIguales Entonces
		Escribir "el n�mero no tiene decimales"
	SiNo
		Escribir "el n�mero s� tiene decimales"
		//Escribir cuales son loes decimales
		//5.99 deber�a mostrar 0.99
		decimales <- number - numeroSinDecimales
		Escribir "Parte decimal ", decimales
	Fin Si
FinAlgoritmo
