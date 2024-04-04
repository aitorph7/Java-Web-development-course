import { Token } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';
import { BehaviorSubject } from 'rxjs';
import { DecodedToken } from './decoded-token.dto';

// ng generate service authentication/authentication
// npm install jwt-decode
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
  userEmail = new BehaviorSubject<string>(this.getUserEmail());

  constructor() { }

  existsToken(){
    return localStorage.getItem("jwt_token") !== null; // true or false.
    // TODO: revisar si el token no ha expirado.
  };

  saveToken(token: string){
    localStorage.setItem("jwt_token", token);
    this.isLoggedIn.next(true);
    this.userEmail.next(this.getUserEmail());
  }

  // Para lograr un logout debo borrar el token:
  removeToken(){
    localStorage.removeItem("jwt_token");
    this.isLoggedIn.next(false);
    this.userEmail.next('');
  }

  getUserEmail(){
    const token = localStorage.getItem("jwt_token");
    if(!token) return '';
    // si existe token lo decodificará y extraerá su email:
    const decodedToken =  jwtDecode(token) as DecodedToken;
    return decodedToken.email;
  }
}
