import { HttpInterceptorFn } from '@angular/common/http';
/*
Interceptor de angular basado en función.

Sirve para interceptar las peticiones HTTP que se envian de Angular a backend.

Agrega el token JWT en una cabecera (header) de la petición HTTP.
*/
export const jwtInterceptor: HttpInterceptorFn = (req, next) => {
  
  const token = localStorage.getItem("jwt_token");

  if(token){
    req = req.clone({
      // agregar token JWT a la request
      headers: req.headers.set('Authorization', 'Bearer ${token}')
    });
  }
  return next(req);
};
