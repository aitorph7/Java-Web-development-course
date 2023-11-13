Algoritmo sin_titulo
	
	// Pedir leer un numero
	Escribir "Introduce un numero "
	Leer precio
	
	// 50 = trunc(50) Verdadero
	// 50.55 = trunc(50.55) Falso
	// precio = trunc(precio)
	precioSinDecimales <- trunc(precio) // truncar
	sonIguales <- precio = precioSinDecimales // Comparar
	Si sonIguales Entonces // Evaluar
		Escribir "El numero no tiene decimales"
	SiNo
		Escribir "El numero si tiene decimales"
		// Escribir cuales son los decimales
		// 5.99 deberia mostrar 0.99
		decimales <- precio - trunc(precio)
		Escribir "Parte decimal ", decimales
	Fin Si
	
	// Si Entonces comprobar si el numero tiene decimales
	// Pista: usar la funcion trunc()
	
	// Si tiene decimales Escribir Tiene decimales
	// SiNO tiene decimales Escribir no tiene decimales
	
	
FinAlgoritmo
