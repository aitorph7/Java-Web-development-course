import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Register } from '../model/register.model';

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
    email: new FormControl('', [Validators.required, Validators.email]),
    phone: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{9}$')]),
    password: new FormControl('')
  });

  constructor(private httpClient: HttpClient){}
  /* Lo habitual es que en lugar de inyectarlo de forma directa, llame a un servicio
  que sea el encargado de llamar al httpClient.
  */
  
  save(){
    const register: Register = {
      email: this.registerForm.get('email')?.value ?? '',
      phone: this.registerForm.get('phone')?.value ?? '',
      password: this.registerForm.get('password')?.value ?? '',
    }
    console.log(register);
    // Limpiar el formulario (o redirigir al login/home) tras enviar el registro al backend.
    this.registerForm.reset();
    
  }
}
