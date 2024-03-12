import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Album } from '../model/album.model';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-album-form',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule],
  templateUrl: './album-form.component.html',
  styleUrl: './album-form.component.css'
})
export class AlbumFormComponent implements OnInit{

  albumForm = this.fb.group({
    id: [0],
    catalogNumber: [''],
    price: [0.0]
  })

  constructor(
    private fb: FormBuilder,
    private httpClient: HttpClient,
    private router: Router,
    private activatedRoute: ActivatedRoute){}

    ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      const id = params['id'];
      if (!id) return;

      this.httpClient.get<Album>('http://localhost:8080/albums/' + id)
      .subscribe(albumFromBackend => {
        // cargar el album obtenido en el formulario albumForm
        this.albumForm.reset({
         id: albumFromBackend.id,
         catalogNumber: albumFromBackend.catalogNumber,
         price: albumFromBackend.price 
        });

      });
    });
  }

  save(){

    // OPCIÓN 1: extraer los valores del formulario manualmente uno a uno: (+ control)
    const album: Album = {
      id: this.albumForm.get('id')?.value ?? 0,
      catalogNumber: this.albumForm.get('catalogNumber')?.value ?? '',
      price: this.albumForm.get('price')?.value ?? 0.0
    }
    console.log(album);

    // OPCIÓN 2: equivalente a la anterior pero en una sola línea de código: (+ rapidez)
    const album2: Album = this.albumForm.value as Album;
    console.log(album2);

    const url = "http://localhost:8080/albums";

    // OPCIÓN 01.
    this.httpClient.post<Album>(url, album).subscribe(albumFromBackend => {
      console.log(albumFromBackend);
      // Elige uno de los siguientes métodos de navegación:
      // 01. Navegar hacia el listado:
      // this.router.navigate(['/albums']);

      // 02. Navegar hacia detail:
      this.router.navigate(['/albums', albumFromBackend.id, 'detail']);
    }, error => {
      console.log(error),
      window.alert("Invalid data")
    });

    /* OPCIÓN 02. Para resolver el tachado de 'subscribe' (deprecado)

    this.httpClient.post<Album>(url, album).subscribe({
      // si todo va bien se ejecuta next:
      next: (albumFromBackend) => this.router.navigate(['/albums', albumFromBackend.id, 'detail']),
      // si todo va mal se ejecuta error:
      error: (error) => window.alert("Invalid Data"),
    });
    */
    

  }
}
