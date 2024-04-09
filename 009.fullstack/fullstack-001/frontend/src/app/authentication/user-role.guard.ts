import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';


/*
Guard funcional (basado en función): que sirve para cmprobar si el usuario tiene el rol de ADMIN.
Sirve para proteger las rutas; se añade sonre la ruta que quiero proteger en app.routes.ts

Si es ADMIN devuelve true y puede pasar; en caso contrario hacemos router.navvigate a /login.
*/
export const userRoleGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthenticationService);
  const router = inject(Router);

  if(authService.getIsAdmin()){
    return true;
  } else {
    return router.navigate(['/login']);
  }
  
};
