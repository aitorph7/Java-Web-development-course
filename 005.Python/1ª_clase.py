texto1 = 'kitten lorem ipsum'
texto2 = 'Lorem Ipsum dolor'
print(texto1, texto2)
print(texto2)

edad = 30
peso = 80.34
print(edad + 2)
print(peso - 5)

edad2 = "89"

edad2_num = int(edad2)
print(edad2_num - 2)
print(edad2_num)
texto3 = bool("hola mundo")
texto4 = bool("")
print(texto3)
print(texto4)

texto5 = "Hola Curso Java"
print(len(texto5))

palabras = texto5.split()
print(palabras)
print(palabras[2])

texto6 = "El curso de Java es de lo más; amarás el curso de Java"
print(texto6.replace('Java', 'Python'))

texto7 = "Hola curso {} la nota mínima es de {} puntos."
print(texto7.format('Java', 5))
print(texto7.format('Python', 6))
print(texto7.format('Spring', 7))