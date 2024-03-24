import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  /* lo creo con otra sintaxis distinta a la usada en 'login.component'.
  No necesita formBuilder porque voy creando a mano los objetos; lleva
  un poco más de trabajo.
  */
  registerForm = new FormGroup({
    id: new FormControl(''),
    phone: new FormControl(''),
    email: new FormControl('')
  });

  constructor(private httpClient: HttpClient){}
  /* Lo habitual es que en lugar de inyectarlo de forma directa, llame a un servicio
  que sea el encargado de llamar al httpClient.
  */
  
  save(){

  }
}
