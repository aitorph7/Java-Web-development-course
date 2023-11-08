Algoritmo EstructurasControl_SiEntonces2
	Escribir "¿Qué edad tiene?: "
	Leer age
	Si age >= 18 Entonces
		Escribir "Puede pasar caballero"
	SiNo
		Escribir "¿Tiene tutor?: conteste verdadero o falso"
		Leer hasTutor
		Si hasTutor=Verdadero Entonces
			Escribir "Puede pasar, pimpollo"
		SiNo
			Escribir "Vuelva a su casa, mocoso"
		FinSi
	Fin Si
FinAlgoritmo
