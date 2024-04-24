import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Login } from '../authentication/login.dto';
import { Token } from '../authentication/token.dto';
import { AuthenticationService } from '../authentication/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm = this.fb.group({
    email: [''],
    password: ['']
  });
  errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private httpClient: HttpClient,
    private authService: AuthenticationService,
    private router: Router
    ){}

  save() {
    const login: Login = {
      email: this.loginForm.get('email')?.value ?? '',
      password: this.loginForm.get('password')?.value ?? '',
    }
    
    const url = 'http://localhost:8080/users/login';
    // método que envía los datos del login al backend, donde entra un
    // 'login' y sale un 'token':
    this.httpClient.post<Token>(url, login).subscribe({
      next: (response: any) => {
        this.authService.saveToken(response.token);
        this.router.navigate(['/albums']);
      },
      error: (response: any) => {
        this.errorMessage = response.error;
       }
    });
  }
}
