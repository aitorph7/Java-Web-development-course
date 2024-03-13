import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Album } from '../model/album.model';
import { ActivatedRoute, Router } from '@angular/router';
import { Artist } from '../model/artist.model';

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
    price: [0.0],
    artist: this.fb.group({
      id: [0],
      name: [''],
      country: [''],
      active: [false]
    })
  });

  isUpdate: boolean = false; /* por defecto estoy en CREAR, no en ACTUALIZAR.
  Este boolean sirve para diferenciar si usar el método post, put... y para poder
  mostrar un título u otro en la pantalla.
  */
  artists: Artist[] = []; // array de artistas para asociar un artista al album.

  constructor(
    private fb: FormBuilder,
    private httpClient: HttpClient,
    private router: Router,
    private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    // cargar artistas de backend para el selector de artistas en el formulario
    this.httpClient.get<Artist[]>('http://localhost:8080/artists')
    .subscribe((artists: any) => this.artists = artists);

    this.activatedRoute.params.subscribe((params: { [x: string]: any; }) => {
      const id = params['id'];
      if (!id) return;

      this.httpClient.get<Album>('http://localhost:8080/albums/' + id)
      .subscribe((albumFromBackend: { id: any; catalogNumber: any; price: any; }) => {
        // cargar el album obtenido en el formulario albumForm
        this.albumForm.reset({
          id: albumFromBackend.id,
          catalogNumber: albumFromBackend.catalogNumber,
          price: albumFromBackend.price 
        });
        // marcar boolean isUpdate true
        this.isUpdate = true;

      });
    });
  }

  save(){
    const album: Album = this.albumForm.value as Album;
    if (this.isUpdate) { //establezco la url de update:
      const url = 'http://localhost:8080/albums/' + album.id;
      this.httpClient.put<Album>(url, album).subscribe((albumFromBackend: { id: any; }) => {
        this.router.navigate(['/albums', albumFromBackend.id, 'detail']);
      });
    } else { // establezco la url de create:
      const url = 'http://localhost:8080/albums';
      this.httpClient.post<Album>(url, album).subscribe((albumFromBackend: { id: any; }) => {
        this.router.navigate(['/albums', albumFromBackend.id, 'detail']);
      });
    }
  }
}
