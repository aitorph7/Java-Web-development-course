Algoritmo estructuraControlWhile_con_estructuraSwitch_anidada
	// Menu de opciones
	// Leer opci?n 
	
	// CRUD: Create Retrieve Update Delete 
	option <- 0
	Mientras option <> 6 Hacer
		// Imprimir un menú de opciones y pedir al usuario que
		// introduzca una 
		Escribir "Elige una opción: "
		Escribir "1 - Imprimir productos"
		Escribir "2 - Imprimir un producto"
		Escribir "3 - Crear un nuevo producto"
		Escribir "4 - Actualizar un producto existente"
		Escribir "5 - Borrar un producto"
		Escribir "6 - Salir"
		Leer option
		Escribir "Has elegido la opción: ", option
		
		//introducir un Switch / segun para hacer una cosa distinta para cada opción
		Segun option Hacer
			1:	//Muestra productos ficticios, habría que obtenerlos de un array o 
				//base de datos
				Escribir "Has elegido ver TODOS los productos"
				Escribir "...searching all products on database..."
				Escribir "Ordenador ASUS, Ratón Logitech, Monitor LG, WebCam Logitech"
			2:	//muestra un producto ficticio
				Escribir "Introduce el identificador (id) del producto que desea consultar"
				Leer idProduct
				Escribir "...searching product on database..."
				Escribir "Product: id " , idProduct, ", title: PC Gaming, RAM: 32 GB, CPU: i7"
			3:	//create a new product, request some data
				Escribir "Has elegido CREAR un NUEVO producto"
				Escribir "¿A qué categoría pertenece el nuevo producto?"
				Leer categoria
				Escribir "¿Quién es el fabricante?"
				Leer manufacturer
				Escribir "¿Cual es el nombre del producto?"
				Leer productName
				Escribir "...creating new product on database..."
				Escribir "Perfecto, incluiremos ", productName, " producido por ", manufacturer, " dentro de la categoría ", categoria, " en nuestro inventario."
			4:	//actualizar el precio de un producto ficticio ya existente
				Escribir "Has elegido ACTUALIZAR un producto ya existente en nuestro inventario"
				Escribir "¿Cual es el id del producto?"
				Leer idProduct
				Escribir "...searching product on database..."
				Escribir "Product: id " , idProduct, ", es: PC Gaming, RAM: 32 GB, CPU: i7"
				Escribir "Actualice el precio vigente (579.89?) de este producto: "
				Leer newProductPrice
				Escribir "De acuerdo! el nuevo precio del producto con id: ", idProduct, " ha cambiado a: ", newProductPrice, "?."
			5:
				Escribir "Has elegido BORRAR un producto existente en el inventario"
				Escribir "¿Cual es el id del producto?"
				Leer idProduct
				Escribir "...searching product to delete on database..."
				Escribir "¿Estás seguro de que deseas eliminar el producto del inventario?"
				Escribir "Indica S / N: "
				leer result
				
				Si result = "S" Entonces
					Escribir "...buscando el producto a eliminar..."
					Escribir "De acuerdo! el producto con id: ", idProduct, " se ha eliminado de nuestro inventario."
				SiNo
					Escribir "...Cancelling remove operation..."
				Fin Si
			6:
				Escribir "Cerrando el programa..."
			De Otro Modo:
				Escribir "Opción incorrecta"
		Fin Segun
	Fin Mientras
	Escribir "Fin del programa"
FinAlgoritmo
