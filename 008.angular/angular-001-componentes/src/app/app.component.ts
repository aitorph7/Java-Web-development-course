import { Component } from '@angular/core';
import { HolamundoComponent } from "./holamundo/holamundo.component";
import { AdiosMundoComponent } from "./adios-mundo/adios-mundo.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [HolamundoComponent, AdiosMundoComponent]
})
export class AppComponent {
  title = 'Hola soy Aitor';
}
