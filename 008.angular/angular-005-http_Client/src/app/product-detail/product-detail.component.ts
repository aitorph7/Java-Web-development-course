import { Component, OnInit } from '@angular/core';
import { Product } from '../models/product.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent implements OnInit{

  product: Product | undefined;
  constructor(private activatedRoute: ActivatedRoute, private http: HttpClient){};
  ngOnInit(): void {
    // extraer el id de la url y traer el producto del backend usando petición HTTP GET
    this.activatedRoute.params.subscribe(params => {
      const id = params['id'];
      const backend = 'https://fakestoreapi.com/products/' + id;
      this.http.get<Product>(backend).subscribe(product => {
        console.log(product);
        this.product = product;
      }); // ya tengo todo conectado para las Operaciones GET <- ojo 👁
    });
  }

}
