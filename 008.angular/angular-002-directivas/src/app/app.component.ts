import { Component } from '@angular/core';
import { ProductListComponent } from "./product-list/product-list.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [ProductListComponent]
})
export class AppComponent {
  title = 'angular-002-directivas';
}
