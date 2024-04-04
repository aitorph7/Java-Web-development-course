import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  /*
  Esta clase se encargará, a través de un método, de guardar el token,
  al que le asignará un booleano con valor verdadero o falso en base al
  token.
  Eso permitirá que otros componentes, como la Navbar o el 
  'app.component', puedan saber si el usuario ha iniciado sesión.
  */
  constructor() { }

  saveToken(token: string){
    localStorage.setItem("jwt_token", token);
  }
}
