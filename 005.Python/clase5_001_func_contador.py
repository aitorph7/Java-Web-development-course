# FUNCIÓN CONTAR VOCALES:

def contar_vocales(texto):
    num_vocales = 0

    for letra in texto:
        if letra in 'aeiouAEIOUáéíóúÁÉÍÓÚ':
            num_vocales += 1
    return num_vocales


resultado3 = contar_vocales('Alan')
print(f'resultado3 {resultado3}')

resultado4 = contar_vocales('Hola mundo')
print(f'resultado4 {resultado4}')