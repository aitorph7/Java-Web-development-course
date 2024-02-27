import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Product } from '../models/product.model';
import { NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  // Agregar alerta de NgBootstrap
  imports: [NgbAlertModule],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent implements OnInit{

  // producto
  product: Product | undefined;

  // Angular inyecta este objeto en nuestro componente.
  constructor(private activatedRoute: ActivatedRoute){}
  /* Este método es ejecutado por Angular automáicamente cuando un
  usuario entra en este componente. Sirve para cargar datos, llamar
  al backend, inicializar, config...*/
  ngOnInit(): void {
    console.log("Hola mundo");
    // Capturar el id de la url para saber qué producto es el que hay que cargar
    this.activatedRoute.params.subscribe(params => {
      console.log(params);
      console.log(params['id']); // id es el nombre que asigné en app.routes.ts

      // Aquí obtendríamos un product de backend, voy a crear uno manualmente:
      this.product = {
        id: 1,
        name: "USS Enterprise",
        price: 200000,
        available: true,
        constructionDate: new Date()
      }
    });
  }

}
