

"""Crear una lista de precios (float)

En un bucle infinito imprimmir un menu de opciones:
1- ver todos los precios
2- ver un precio por posición
3- crear un nuevo precio
4- actualizar un precio existente
5- borrar un `precio existente
6- Borrar todos los precios
7- Salir

Para ello utilizar los métodos que están en input_utils:
read_int, read_float, read_bool
"""

from input_utils import read_int, read_float, read_bool

precios = [45.99, 67.89, 99.45]

def ver_precios(precios):
    print(precios)

def ver_precio_concreto(precios):
    print('Has elegido ver un precio en concreto')
    posicion = read_int('Selecciona el precio que te interesa: ')
    if 0 <= posicion <= len(precios):
        print(precios[posicion - 1])
    else:
        print('Posición no reconnocida')

def ver_precio_por_posicion(precios):
    print('Has elegido crear un nuevo precio')
    nuevo_precio = read_float('Introduce el precio del nuevo artículo: ')
    precios.append(nuevo_precio)
    print(f'de acuerdo, has elegido crear un nuevo producto con precio: {nuevo_precio} €.')
    print(f'La lista de precios ha quedado así: {precios}')

def actualizar_precio(precios):
    print('Has elegido actualizar un precio existente')
    print(f'Esta es la lista actual de precios: {precios}')
    posicion = read_int('Selecciona la posición del precio que quieres actualizar: ')
    if 1 <= posicion <= len(precios):
        nuevo_precio = read_float('¿Qué nuevo precio debe mostrar ése artículo?: ')
        precios[posicion - 1] = nuevo_precio
        print(f'La lista de precios ha quedado así: {precios}')
    else:
        print('Lo siento, no he encontrado esa posición.')

def borrar_precio_existente(precios):
    print('Has elegido borrar un precio existente')
    print(f'Esta es la lista actual de precios: {precios}')
    posicion = read_int('Introduce la posición del precio a eliminar: ')
    if 1 <= posicion <= len(precios):
        precio_borrado = precios.pop(posicion - 1)
        print(f'De acuerdo, hemos eliminado este precio: {precio_borrado} de la lista.')
        print(f'La lista de precios ha quedado así: {precios}')
    else:
        print('Lo siento, no he encontrado esa posición.')

def borrar_todos_precios():
    print('Ey! has elegido borrar todos los precios de la lista')
    confirmacion_borrado_total = read_bool('¿EStás seguro de querer vaciar la lista?: ')
    if confirmacion_borrado_total == True:
        precios = []
        print('De acuerdo, la lista de precios ha quedado vacía.')
    else:
        print(f'Muy bien, conservamos la lsta como está: {precios}')
    return precios

def borrar_sobre_precio_tope(precios):
    precio_tope = read_float('Muy bien, introduce un precio a partir del cual borrar: ')
        # IMPORTANTE: BORRAR MIENTRAS SE ITERA SOBRE LA LISTA ORIGINAL ES PROBLEMÁTICO
        # GENERA INCONSISTENCIAS. PROBAR DEPURANDO EL CÓDIGO.
            # for precio in precios:
            #    if precio > precio_tope:
            #        precios.remove(precio)
        
        # Opción 1:
            # creamos una lista provisional de elementos a borrar sobre la cual iterar
    elementos_a_borrar = []
    for precio in precios:
        if precio > precio_tope:
            elementos_a_borrar.append(precio)

    for precio in elementos_a_borrar:
        precios.remove(precio)
        print(f'La nueva lista de precios ha quedado así: {precios}.')
    return precio_tope

def salir():
    print('Has elegido salir de la aplicación. Nos vemos pronto!👋')



while True:
    print('''
          Elige una opción:
1- ver todos los precios
2- ver un precio por posición
3- crear un nuevo precio
4- actualizar un precio existente
5- borrar un precio existente
6- Borrar todos los precios
7- Eliminar los precios superiores a un precio introducido por ussuario          
8- Salir
          ''')
    
    opcion = read_int('Selecciona la opción (1 a 7): ')
    if opcion == 1:
        ver_precios(precios)
    elif opcion == 2:
        ver_precio_concreto(precios)
    elif opcion == 3:
        ver_precio_por_posicion(precios)
    elif opcion == 4:
        actualizar_precio(precios)
    elif opcion == 5:
        borrar_precio_existente(precios)
    elif opcion == 6:
        precios = borrar_todos_precios()
    elif opcion == 7:
        precio_tope = borrar_sobre_precio_tope(precios)

        # Opción 2: denomiada 'Listas por Comprensión'
        # Bucle for en una sola linea de código; hay que introducir la variable antes
        # del bucle. Te quedas con todos los precios en 'precios' cuyo valor sea menor
        # que el del precio tope.
        precios = [precio for precio in precios if precio <= precio_tope]
        

    elif opcion == 8:
        salir()
        break
    else:
        print('Opción incorrecta. Introduce un valor en el rango de 1 a 7.')