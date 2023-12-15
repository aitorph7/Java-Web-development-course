# BUCLE WHILE CON INPUT (...SIGUIENDO CON LAS ESTRUCTURAS DE CONTROL)

# Pedir datos al usuario en bucle hasta que los escriba bien

password = "admin"
password_user = ""

while password_user != password:
    password_user = input("Introduce tu contraseña: ")
print("fin")

# Ejemplo 2: lo mismo pero con número máximo de intentos, utilizando BREAK
# palabra reservada en los lenguajes de programacón para romper un
# flujo de acciones
password = "admin"
password_user = ""
intento = 1  # contador para el número de intentos
max_intentos = 3

while intento <= 3:
    password_user = input("Introduce tu contraseña: ")
    if password_user == password:
        print("contraseña correcta.")
        # ...invocar una función que realice la acción deseada...
        break  # sale del bucle
    intento += 1
if intento > max_intentos:
    print("Superado el número máximo de intentos")

print("fin")

# BUCLE WHILE CON INPUT Y TRY EXCEPT:
# Leer una edad hasta que el usuario escriba una edad correcta de 18 a 100

while True:
    
    # ValueError: invalid literal for int() with base 10: 'hola' - el usuario introduce un texto
    # así harás tu código resistente a que el usuario introduzca
    # los datos de manera incorrecta.
    try:
        edad = int(input("Introduce tu edad (18 - 100); "))
        if 18 <= edad <= 100:
            print("De acuerdo, correcto.")
            break
    except ValueError:
        print('Formato de datos incorrecto')

# BUCLE WHILE CON INPUT Y TRY EXCEPT EXCEPT:

vehiculos=['mercedes','Lambo','Tractor John Deere','Bici Orbea', 'Patinete']
while True:
    
    try:
        indice = int(input(f'Introduzca qué vehículo desea utilizar hoy (0 a {len(vehiculos) -1}): '))
        vehiculo=vehiculos[indice]
        print(f'Excelente elección, disfrute de su {indice}: {vehiculo}')
        break

    # IndexError: list index out of range - el usuario introduce un nº superior al de elementos
    # ValueError: invalid literal for int() with base 10: 'hola' - el usuario introduce un texto
    except IndexError as e:
        print(f'Se ha producido un error de acceso por índice incorrecto: {e}')
    except ValueError as e:
        print(f'Se ha producido un error de formato de dato incorrecto: {e}')
        
    # Una opción más sencilla a nivel de código porque captura todas las excepciones sería:
    
vehiculos=['mercedes','Lambo','Tractor John Deere','Bici Orbea', 'Patinete']
while True:
    
    try:
        indice = int(input(f'Introduzca qué vehículo desea utilizar hoy (0 a {len(vehiculos) -1}): '))
        vehiculo=vehiculos[indice]
        print(f'Excelente elección, disfrute de su {indice}: {vehiculo}')
        break

    except Exception: # Captura cualquier error que se produzca
        print('Se ha producido un error, inténtalo de nuevo')
        

# BUCLES FOR:

vehiculos=['mercedes','Lambo','Tractor John Deere','Bici Orbea', 'Patinete'] #5

    # Iterar SOBRE ELEMENTOS:
for vehiculo in vehiculos:
    print(vehiculo)
    
    # Iterar SOBRE ÍNDICES utilizando la función range() que devuelve una lista de
    # números;
    # Las siguientes son 3 maneras de utilizar range()
for index in range(0, 5, 1): # definiendo comienzo, fin y step (start, stop, step)
    print(vehiculos[index])
    
for index in range(5): # definiendo el nº final/stop (está excluído)
    print(vehiculos[index])
    
for index in range(len(vehiculos)): # obteniendo de forma automática la longitud con len()
    print(vehiculos[index])
    
        # Iterar con bucle for y si el vehículo contiene la palabra 'Tractor'
        # entonces imprimir y salir del bucle:
    
vehiculos=['mercedes','Lambo','Tractor John Deere','Bici Orbea', 'Patinete']
for vehiculo in vehiculos:
    if 'tractor' in vehiculo.lower():
        print(f'Tractor encontrado: {vehiculo}')
        break
    
    
# BUCLE FOR CON la declaración reservada CONTINUE:
    # a diferencia de break, que rompe el bucle, continue se mantiene
    # dentro pero salta a la siguiente iteración.
        # break lo puedes usar para buscar algun valor en concreto, y una vez
        # lo tengas, ok, lo encontré y me marcho.
            # continue lo puedes usar por ejemplo para buscar alumnos que hayan aprobado
            # dentro de una lista.

vehiculos = ['mercedes rojo', 'bmw gris', 'tractor azul', 'tractor rosa', 'patinete azul']
    # hacer un bucle for que itere imprimiendo cada vehículo y si es
    # de color azul salta a la siguiente iteración.

for vehiculo in vehiculos:
    if 'azul' in vehiculo:
        continue
    print(vehiculo) # solo imprime si el vehiculo no es azul.
    
    # Lista de estudiantes con sus respectivas notas

    # porcentaje de aprobado
    
calificaciones = [
    'Alan 5',
    'Carolina 9',
    'Antonio 6',
    'Mike 3',
    'Patricia 4',
    'Bob 7',
    'Leyla 8'
]
numero_aprobados = 0
numero_suspensos = 0
    
for calificacion in calificaciones:
    nota = int(calificacion.split()[1])
    
    if nota >= 5:
        numero_aprobados += 1
    else:
        numero_suspensos += 1
        
    # imprimir numero_aprobados y numero_suspensos y porcentaje
    # de aprobados redondeado a 2 decimales usando f string
numero_total = len(calificaciones)
porcentaje_aprobados = round((numero_aprobados / numero_total) * 100, 2)

print(f'Número aprobados: {numero_aprobados}')
print(f'Número suspensos: {numero_suspensos}')
print(f'% de aprobados: {porcentaje_aprobados} %')

# 'f' viene de Format, y lo utilizas acompañado de llaves {} para indicar
# que dentro de esas llaves estás incrustando una variable dentro del string.


#_________________________________________________________________________
#_________________________________________________________________________

# FUNCIONES:
    # bloques de código reutilizables a los que se asigna un nombre y pueden ser 
    # invocadas varias veces a lo largo de un archvo de código.
    # Objetivos: evitar repetir código, tener un código limpio y legible, modularizarlo.

# para crear funciones se utiliza la declaración def

    # FUNCIÓN SIN PARÁMETROS Y SIN RETORNO:
    # esta funcion no recibe ninguna entrada ni devuelve ninguna salida

def saludar():
    print('Hola mundo')
    print('Hola inframundo')
    if True:
        print('Bloque dentro de una función')

saludar()
saludar()
saludar()
# depurar y ver la difrenecia entre Step Over y Step Into

    # FUNCIÓN CON PARÁMETROS Y SIN RETORNO:
    
def saludar(nombre):
    print(f'Welcome user {nombre}')

nombre_usuario = 'Pepe'
saludar(nombre_usuario)
saludar('Johnny')