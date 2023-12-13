# COMO CREAR LISTAS
students = ['Aitor', 'Ángel Sanz', 'Ángel Sigueros', 'Carlos']
print(students[0])
print(students[1])
print(students[2])
print(students[3])


precios = [5.99, 12.32, 10.00, 48.57]

print(precios[0])
print(precios[1])
print(precios[2])
print(precios[3])

# MODIFICAR UN ELEMENTO DE LA LISTA:
# precios[2] = precios[2] * 0.80
precios[2] = precios[2] * 0.80

print(precios[2])

# AGREGAR ELEMENTOS A UNA LISTA:

clothes = ['Camisa', 'Pantalón', 'Abrigo', 'Zapatos']
print(clothes)

# método append() agrega un elemento al final de la lista

clothes.append('Bufanda')
clothes.append('Cinturón')
print(clothes)

# método insert() permite agregar un elemento en una posición concreta
clothes.insert(2, 'Reloj Rolex flamante')
print(clothes)
clothes.insert(0, 'gallumbos de Superman')
print(clothes)

# BORRAR ELEMENTOS DE UNA LISTA EXISTENTE

phones = ['629373459', '686114583', '666098456','567456123']

# método remove() borra un elemento que pasemos por parámetro
phones.remove('666098456')
print(phones)

# método pop() elimina y devuelve el último elemento de la lista o por su índice
pendientes_calificacion = ['Aitor', 'Ángel Sanz', 'Ángel Sigueros', 'Carlos']
print(pendientes_calificacion)
alumno_a_calificar = pendientes_calificacion.pop()
print(f'alumno_a_calificar {alumno_a_calificar}')

alumno_a_calificar = pendientes_calificacion.pop()
print(f'alumno_a_calificar {alumno_a_calificar}')

  # ahora le añades un índice al comando pop(0); imaginando la cola de
  # una pescadería, en la que hay que atender al primero en llegar.
fila_pescaderia = ['cliente1', 'cliente2', 'cliente3', 'cliente4', 'Aitor']
cliente_a_atender = fila_pescaderia.pop(0)
print(f'cliente_a_atender {cliente_a_atender}')

cliente_a_atender = fila_pescaderia.pop(0)
print(f'cliente_a_atender {cliente_a_atender}')

# método del() permite borrar un elemento concreto sin devolverlo, por posición
# Ejemplo: productos de un ecommerce, en el checkout antes de finalizar
# la compra
precios = [5.99, 12.32, 10.00, 48.57]
print(precios)
del precios[2]
print(precios)

# CALCULAR LONGITUD LISTAS con el método len()

print(len(students))
print(len(precios))

# ORDENAR ELEMENTOS DE UNA LISTA:

coches = ['Mercedes', 'BMW', 'Skoda', 'Alfa Romeo', 'Maserati']
  # sort() ordena de forma ASCENDENTE, de menos a más A - Z
  # y modifica la lista original
coches.sort()
print(coches)

  # sort(reverse=True) ordena de forma DESCENDENTE, de más a menos
  # Z - A y también modifica la lista original
coches.sort(reverse=True)
print(coches)

  # reverse() invierte el orden de los elementos en torno al centro
coches = ['Mercedes', 'BMW', 'Skoda', 'Alfa Romeo', 'Maserati']
coches.reverse()
print(coches)

  # sorted() la diferencia con sort() es que este no modifica la
  # original, sino que devuelve una nueva lista con los elementos
  # ordenados.
values = [1.11, 2.22, 3.33, 7.77, 6.66, 5.55, 4.44]
values_asc = sorted(values)
print(values)
print(values_asc)

  # sorted(reverse=True)
calificaciones = [1.11, 2.22, 4.44, 3.33, 5.55]
calificaciones_desc = sorted(calificaciones, reverse=True)
print(calificaciones_desc)

calificacion_maxima = calificaciones_desc[0] # el primero
calificacion_minima = calificaciones_desc [-1] # el último

# ESTRUCTURAS DE CONTROL CONDICIONAL

  # IF ELSE - IF ELIF ELSE:

precio = float(input('Introduce un precio: '))

if precio >= 100:
  print('El producto es caro') 
elif precio >= 50:
  print('El producto está chévere.')
else:
  print('Está regalado!')
  
  # estructura algo más complicada usando una rutina diaria
  # de 24 horas
hora = int(input('¿Quieres saber dónde está Juanito? pues dime qué hora es: '))
if 0 <= hora < 8:
  print('Está en la cama (sin entrar en detalles) 😴🥳')
elif 8 <= hora < 15:
  print('Está en clase de Frontend 💻')
elif 15 <= hora < 16:
  print('Está comiendo manguito maracatón 🥭')
elif 16 <= hora < 21:
  print('Está en clase de Backend con el líder ❤️')
elif 21 <= hora < 24:
  print('Está cenando sano en plan fit 🐟💪')
else:
  print('Igual está en el baño 🚽💩')
  
  # IF ELSE ANIDADOS:

nivel = 4
puntos = 75

if nivel < 1:
    print('Nivel incorrecto')
    
elif nivel == 1:
    
    if puntos < 20:
        print('Mal comienzo')
    else:
        print('¡Buen comienzo!')    
        
elif nivel == 2:
    
    if puntos < 30 :
        print('Podría hacerse mejor para un nivel 2')
    else:
        print('Gran avance de nivel')
        
elif nivel == 3:

    if puntos < 40 :
        print('Mejorable')
    else:
        print('Está perfecto')
        
else:
    print('Máquina')