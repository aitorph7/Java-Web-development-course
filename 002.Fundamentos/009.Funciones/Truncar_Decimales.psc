Algoritmo sin_titulo
	Escribir "Introduce un numero compuesto (con decimales, please)"
	Leer number
	numeroSinDecimales <- trunc(number)
	sonIguales <- number = numeroSinDecimales
	Si sonIguales Entonces
		Escribir "el numero no tiene decimales"
	SiNo
		Escribir "el numero si tiene decimales"
		//Escribir cuales son loes decimales
		//5.99 deberia mostrar 0.99
		decimales <- number - numeroSinDecimales
		Escribir "Parte decimal ", decimales
	Fin Si
FinAlgoritmo
