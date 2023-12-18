# LISTA DE PRECIOS FILTRAR PRECIOS POR RANGO:
"""La función debe comprobar uno a uno los precios y comprobar
si están comprendidos entre precio min y precio max, en cuyo
caso los añade a una lista de resultados y la devuelve.
"""

def filtrar_precios(precios, precio_min, precio_max):
    resultados = []

    for valor in precios:
        if precio_min <= valor <= precio_max:
          resultados.append(valor)
    return resultados 




precios = [20.99, 42.33, 55.50, 90.77, 36.77, 47.89]
# parametros: lista precios, precio minimo, precio maximo
# precios_filtrados es una lista de resultados, de precios filtrados
precios_filtrados = filtrar_precios(precios, 30, 50)
print(precios_filtrados)

