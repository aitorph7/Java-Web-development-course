import { Routes } from '@angular/router';
import { AlbumListComponent } from './album-list/album-list.component';
import { AlbumDetailComponent } from './album-detail/album-detail.component';
import { AlbumFormComponent } from './album-form/album-form.component';
import { ArtistDetailComponent } from './artist-detail/artist-detail.component';
import { BookingFormComponent } from './booking-form/booking-form.component';

export const routes: Routes = [
  {
    path: '',
    component: AlbumListComponent
  },
  {
    path: 'albums',
    component: AlbumListComponent
  },
  {
    path: 'albums/:id/detail',
    component: AlbumDetailComponent
  },
  {
    path: 'albums/create',
    component: AlbumFormComponent
  },
  {
    path: 'albums/:id/update',
    component: AlbumFormComponent
  },
  {
    path: 'albums/:id/reserve',
    component: BookingFormComponent
  },
  {
    path: 'artists/:id/detail',
    component: ArtistDetailComponent
  }  
];
