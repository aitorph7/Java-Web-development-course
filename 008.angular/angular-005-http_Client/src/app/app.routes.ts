import { Routes } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';

export const routes: Routes = [
  {
    path: '',
    component: ProductListComponent
  },
  {
    path: 'products/:id/detail',
    component: ProductDetailComponent
  }
];
