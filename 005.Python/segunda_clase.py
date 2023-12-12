password = input('Introduce contraseña: ')
password_correct = 'admin'
print(password == password_correct)

email = input('Introduce tu emai: ').lower()
email_correct = 'yosoytotu@gmail.com'
print(email == email_correct)

password = input('Introduce contraseña: ')
password_correct = 'admin'
if password != password_correct:
    print('credenciales erróneas')
    
respuesta_correcta = 'madrid'
capital = input('Introduce capital de Spain: ').lower().replace(' ', '')
if capital != respuesta_correcta:
    print('respuesta incorrecta')
else:
    print('has acertado, toma un pin.')
    
print(50 > 20)
print(50 > 50)
print(50 >= 50)
print(50 > 100)

print(50 < 20)
print(50 < 50)
print(50 <= 50)
print(50 < 100)

email_correcto = 'admin@gmail.com'
password_correcta = '1234'

email = input('Introduce tu email: ')
password = input('Introduce contraseña: ')

if email == email_correcto and password == password_correcta:
    print('credenciales correctas')
else:
    print('Credenciales incorrectas')
    
es_estudiante = input('¿Eres estudiante? si o no: ') == 'si'
precio = float(input('Introduce el importe de tu compra: '))

if es_estudiante or precio >= 100:
    print(f'Descuento del 20%, precio final: {precio * 0.80}')
else:
    print(f'Precio final: {precio}')

edad = int(input('Introduce tu edad: '))
if not edad >= 18:
    print('No tiene acceso')
else:
    print('acceso permitido')
    
email = None
email_user = input('INtroduce tu email: ')

if email_user.endswith('gmail.com'):
    email = email_user
    print('Registro completo')
if email is None:
    print('No se ha completado el registro.')
    
email_user = 'yosoytotu@gmail.com'
print('gmail.com' in email_user)