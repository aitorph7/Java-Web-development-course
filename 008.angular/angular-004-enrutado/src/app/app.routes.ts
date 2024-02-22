import { Routes } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';
import { ManufacturerListComponent } from './manufacturer-list/manufacturer-list.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';

// rutas mapeadas contra componentes:
export const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'products',
    component: ProductListComponent
  },
  {
    path: 'manufacturers',
    component: ManufacturerListComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  // Dejar el siguiente enrutado al final del código:
  {
    path: '**', // Ruta comodín: atrapa cualquier URL no capturada anterioremente.
    component: NotFoundComponent
  }
];
