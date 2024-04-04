import { Component } from '@angular/core';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { AuthenticationService } from './authentication/authentication.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
  isLoggedIn = false; // Me suscribo a isLoggedIn porque aquí es donde tengo...
  // alojada la Navbar ahora mismo.
  userEmail = '';
  isAdmin = false;

  constructor(
    private authService: AuthenticationService, 
    private router: Router
    ) {
    this.authService.isLoggedIn.subscribe((isLoggedIn: any) => this.isLoggedIn = isLoggedIn);
    this.authService.userEmail.subscribe((userEmail: any) => this.userEmail = userEmail);
    this.authService.isAdmin.subscribe((isAdmin: any) => this.isAdmin = isAdmin);
  }

  logout(){
    this.authService.removeToken();
    this.router.navigate(['/login']);
  }
}
