import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  /*
  Esta clase se encargará, a través de un método, de guardar el token,
  al que le asignará un booleano con valor verdadero o falso en base al
  token.
  Eso permitirá que otros componentes, como la Navbar o el 
  'app.component.ts', puedan saber si el usuario ha iniciado sesión.
  */

 // 'BehaviourSubject' permite suscribirse y estar informado cuando el valor cambie,
 // para que los componentes lo 'escuchen'.
  isLoggedIn = new BehaviorSubject<boolean>(this.existsToken()); 

  constructor() { }

  existsToken(){
    return localStorage.getItem("jwt_token") !== null; // true or false.
    // TODO: revisar si el token no ha expirado.
  };

  saveToken(token: string){
    localStorage.setItem("jwt_token", token);
    this.isLoggedIn.next(true);
  }
}
