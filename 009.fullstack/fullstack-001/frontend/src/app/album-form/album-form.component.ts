import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Album } from '../model/album.model';
import { ActivatedRoute, Router } from '@angular/router';
import { Artist } from '../model/artist.model';
import { RecordCompany } from '../model/recordCompany.model';

@Component({
  selector: 'app-album-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './album-form.component.html',
  styleUrl: './album-form.component.css'
})
export class AlbumFormComponent implements OnInit{

  /*
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
  */

  // Si hay asociaciones entre clases es mejor utilizar FormControl:
  albumForm = new FormGroup({
    id: new FormControl<number>(0),
    title: new FormControl<string>(''),
    catalogNumber: new FormControl<string>(''),
    price: new FormControl<number>(0.0),
    published: new FormControl<boolean>(true),
    releaseDate: new FormControl<Date>(new Date()),
    type: new FormControl(),
    artist: new FormControl(),
    recordCompany: new FormControl()
  });

  isUpdate: boolean = false; /* por defecto estoy en CREAR, no en ACTUALIZAR.
  Este boolean sirve para diferenciar si usar el método post, put... y para poder
  mostrar un título u otro en la pantalla.
  */
  artists: Artist[] = []; // array de artistas para asociar un artista al album.
  recordCompanies: RecordCompany[]=[];

  constructor(
    private fb: FormBuilder,
    private httpClient: HttpClient,
    private router: Router,
    private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    /* xa cargar en el array los datos de artistas y discográficas del backend para que salgan 
    en el selector del formulario.
    */
    this.httpClient.get<Artist[]>('http://localhost:8080/artists')
    .subscribe((artists: any) => this.artists = artists);

    this.httpClient.get<RecordCompany[]>('http://localhost:8080/recordCompanies')
    .subscribe((recordCompanies: any) => this.recordCompanies = recordCompanies);

    this.activatedRoute.params.subscribe((params: any) => {
      const id = params['id'];
      if (!id) return;

      this.httpClient.get<Album>('http://localhost:8080/albums/' + id)
      .subscribe((albumFromBackend: any) => {
        // cargar el album obtenido en el formulario albumForm
        this.albumForm.reset(albumFromBackend);
        
        // marcar boolean isUpdate true
        this.isUpdate = true;

      });
    });
  }

  save(){
    const album: Album = this.albumForm.value as Album;
    console.log(album); // para visualizar cómo el objeto album se envía al backend.

    if (this.isUpdate) { //establezco la url de update:
      const url = 'http://localhost:8080/albums/' + album.id;
      this.httpClient.put<Album>(url, album).subscribe((albumFromBackend: any) => {
        this.router.navigate(['/albums', albumFromBackend.id, 'detail']);
      });
    } else { // establezco la url de create:
      const url = 'http://localhost:8080/albums';
      this.httpClient.post<Album>(url, album).subscribe((albumFromBackend: any) => {
        this.router.navigate(['/albums', albumFromBackend.id, 'detail']);
      });
    }
  }
  /* Gracias al siguiente método, cuando haga clic en un album,  el artista aparecerá
  en el selector ya precargado; compara los autores por id y así puede saber cual tiene
  que cargar:
  */
  compareObjects(o1: any, o2: any): boolean{
    if(o1 && o2) {
      return o1.id === o2.id;
    }
    return o1 === o2;
  }
}
