
"""Las funciones lambda en Python son una forma de crear pequeñas funciones
anónimas. Estas funciones se llaman "anónimas" porque no se declaran de la
forma estándar utilizando la palabra clave def. Puede usarse la palabra
clave lambda para crear pequeñas funciones anónimas.

La sintaxis de las funciones lambda es más sencilla que la sintaxis
tradicional de las funciones en Python definidas con def.
La sintaxis general es la siguiente:
  lambda argumentos: expresion

Aquí hay un ejemplo de una función lambda simple que toma un argumento
y devuelve ese argumento incrementado en 1:

  f = lambda x: x + 1
  print(f(1))  # Devuelve: 2

Las funciones lambda son muy útiles cuando se necesita una pequeña
función que se va a utilizar una sola vez. Algunas características son:

- Pueden tomar cualquier número de argumentos, pero sólo pueden 
  tener una expresión.
- No se les puede asignar un nombre directamente.
- Se pueden usar en cualquier lugar donde se requieran objetos de función.
- Tienen su propio espacio de nombres y no pueden acceder a otras
  variables fuera de su lista de argumentos.

"""


f = lambda x: x ** 2
print(f(2))

f = lambda x: x + 1
print(f(5))

# La función filter(función, secuencia) ofrece
# una forma elegante de filtrar todos los elementos de una lista.

lista = [1, 2, 3, 4, 5, 6, 7]
pares = filter(lambda x: x % 2 == 0, lista)
print(list(pares))


# La función map(función, secuencia) trabaja de manera similar a
# filter(), pero en lugar de aplicar una condición a los elementos
# de secuencia, aplica función a todos los elementos de la secuencia.

lista = [2, 4, 6, 8, 10, 12]
cuadrados = map(lambda x: x ** 2, lista)
print(list(cuadrados))


# La función reduce(función, secuencia) es un poco diferente a
# filter() y map() porque no devuelve una lista, sino un solo valor
# calculado a partir de los elementos de la secuencia.
# Para usar reduce() es necesario importar el módulo functools.

from functools import reduce

lista = [2, 3, 5, 7, 9, 23, 67]
producto = reduce(lambda x, y: x * y, lista)
print(producto)