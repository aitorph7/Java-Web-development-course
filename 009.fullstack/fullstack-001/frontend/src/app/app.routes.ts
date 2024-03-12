import { Routes } from '@angular/router';
import { AlbumListComponent } from './album-list/album-list.component';
import { AlbumDetailComponent } from './album-detail/album-detail.component';
import { AlbumFormComponent } from './album-form/album-form.component';

export const routes: Routes = [
  {
    path: '',
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
  }
];
