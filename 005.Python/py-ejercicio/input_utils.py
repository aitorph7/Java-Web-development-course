# ARCHIVO CON FUNCIONES DE UTILIDAD PARA LEER DATOS
# POR CONSOLA UTILIZANDO INPUT, WHILE, TRY EXCEPT.

# La siguiente función lee por consola un número entero y lo devuelve:

def read_int(prompt):
    while True:
        try:
            numero = int(input(prompt))
            return numero
        except Exception:
            print('No se ha podido leer el número int')



edad = read_int('Introduce tu edad :')
peso = read_int('Introduce tu peso: ')
altura = read_int('Introduce tu altura: ')



# La siguiente función lee por consola un número decimal y lo devuelve:

def read_float(prompt):
    while True:
        try:
            numero2 = float(input(prompt))
            return numero2
        except Exception:
            print('No introdujo su peso de forma correcta')


peso_exacto = read_float('Introduce tu peso exacto: ')


# La siguiente función lee por consola un valor y devuelve True or False:

def read_boolean(prompt):
    respuesta = input(prompt)
    booleano = respuesta.lower() in ['si', 'yes', 'sí', 'oui', 'ja', 'bai']
    return booleano

atencion_pregunta = read_boolean('¿Era blanco el caballo blanco de Santiago?: ')
print(f'atención_pregunta {atencion_pregunta}')