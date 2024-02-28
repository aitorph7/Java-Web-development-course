import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Product } from '../models/product.model';
import { NgbAccordionModule, NgbAlertModule, NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  // Agregar alerta de NgBootstrap
  imports: [NgbAlertModule, NgbAccordionModule, NgbCarouselModule],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent implements OnInit{

  // producto
  product: Product | undefined;

  // Array de imágenes para el acordeón que estarían en alguna carpeta del backend
  images: string[] = [
    "https://i.pinimg.com/736x/7c/3f/ac/7c3facd953581ae6a50a25df5b3a4bf8.jpg",
    "https://silverspock.files.wordpress.com/2011/04/star_trek__enterprise_a__blue_planet.jpg",
    "https://cdn.mos.cms.futurecdn.net/iTTvRuBGN9fbUQ6c3MKSAJ-1200-80.jpg",
  ];

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
        constructionDate: new Date(),
        imageUrl: 'https://i.blogs.es/2b84cc/star_trek_enterprise_ncc_1701_0001.jpgdfb123ef-b830-4db6-9b7c-8f7fd89403f4original/1366_2000.jpg'
      }
    });
  }

}
