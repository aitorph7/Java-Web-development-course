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

  constructor(
    private authService: AuthenticationService, 
    private router: Router
    ) {
    this.authService.isLoggedIn.subscribe((isLoggedIn: any) => this.isLoggedIn = isLoggedIn);
  }

  logout(){
    this.authService.removeToken();
    this.router.navigate(['/login']);
  }
}
