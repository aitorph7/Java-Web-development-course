import { Routes } from '@angular/router';
import { AlbumListComponent } from './album-list/album-list.component';
import { AlbumDetailComponent } from './album-detail/album-detail.component';
import { AlbumFormComponent } from './album-form/album-form.component';
import { ArtistDetailComponent } from './artist-detail/artist-detail.component';
import { BookingFormComponent } from './booking-form/booking-form.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ArtistListComponent } from './artist-list/artist-list.component';
import { ArtistFormComponent } from './artist-form/artist-form.component';
import { userRoleGuard } from './authentication/user-role.guard'; 
import { AccountFormComponent } from './account-form/account-form.component';
import { AvatarFormComponent } from './avatar-form/avatar-form.component';
import { userLoggedInGuard } from './authentication/user-logged-in.guard';
/*
'Guard' para proteger rutas.
comando: "ng generate guard authentication/user-role"
'/authentication/...' para que cree los archivos en esa carpeta que ya había creado.
*/

export const routes: Routes = [
  {
    path: '',
    component: AlbumListComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'albums',
    component: AlbumListComponent
  },
  {
    path: 'albums/:id/detail',
    component: AlbumDetailComponent,
    canActivate: [userLoggedInGuard]
  },
  {
    path: 'albums/create',
    component: AlbumFormComponent,
    canActivate: [userRoleGuard]
  },
  {
    path: 'albums/:id/update',
    component: AlbumFormComponent,
    canActivate: [userRoleGuard]
  },
  {
    path: 'albums/:id/reserve',
    component: BookingFormComponent,
    canActivate: [userLoggedInGuard]
  },
  {
    path: 'artists/:id/detail',
    component: ArtistDetailComponent
  },
  {
    path: 'artists',
    component: ArtistListComponent
  },
  {
    path: 'artists/create',
    component: ArtistFormComponent,
    canActivate: [userRoleGuard]
  },
  {
    path: 'artists/:id/update',
    component: ArtistFormComponent,
    canActivate: [userRoleGuard]
  },
  {
    path: 'users/account',
    component: AccountFormComponent
  },
  {
    path: 'users/account/avatar',
    component: AvatarFormComponent
  }
];
