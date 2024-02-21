import { Component } from '@angular/core';
import { Manufacturer } from './models/manufacturer.model';
import { Product } from './models/product.model';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [DatePipe], //importo el Pipe 'DatePipe' para poder cambiarle el formato al publishDate
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-003-directivas';

  // nombreVariable: tipoDato[] = valor
  manufacturers: Manufacturer[] = [];

  nombres: string[] = ['Noemi', 'Aitor', 'Judith'];

  products: Product[] = [
    {
      id: 1,
      title: 'producto 1',
      available: true,
      price: 49.49,
      publishDate: new Date(), //fecha actual
      manufacturer: {
        id: 1,
        name: 'Ford',
        startYear: 1960
      }
    },
    {
      id: 2,
      title: 'producto 2',
      available: false,
      price: 39.49,
      publishDate: new Date(), //fecha actual
      manufacturer: {
        id: 1,
        name: 'Ford',
        startYear: 1960
      }
    }
  ]
}
