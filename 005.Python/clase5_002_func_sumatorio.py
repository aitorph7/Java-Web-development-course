# FUNCIONES SUMATORIO:

def sumatorio(numeros):
    """funcion sumatorio, suma todos los elementos de la lista números
    Args: numeros (list): lista de números int o float

    Returns: float: suma total de los elementos de la lista
    """
    suma = 0
    for numero in numeros:
        suma += numero
    return suma



    # Sin necesidad de crear un bucle For, la siguiente instrucción
    # también funciona:
    # return sum(numeros)
    
resultado1 = sumatorio([2, 5, 10, 10])
print(f'resultado1: {resultado1}')

resultado2 = sumatorio([100, 200, 300, 400, 500, 600])
print(f'resultado2: {resultado2}')