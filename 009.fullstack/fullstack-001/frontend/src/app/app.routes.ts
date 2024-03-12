import { Routes } from '@angular/router';
import { AlbumListComponent } from './album-list/album-list.component';
import { AlbumDetailComponent } from './album-detail/album-detail.component';

export const routes: Routes = [
  {
    path: '',
    component: AlbumListComponent
  },
  {
    path: 'albums/:id/detail',
    component: AlbumDetailComponent
  }
];
