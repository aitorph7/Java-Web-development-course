import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Artist } from '../model/artist.model';

@Component({
  selector: 'app-artist-form',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule, RouterLink],
  templateUrl: './artist-form.component.html',
  styleUrl: './artist-form.component.css'
})
export class ArtistFormComponent implements OnInit{

  artistForm = new FormGroup({
    name: new FormControl('')
  });
  photoFile: File | undefined;
  photoPreview: string | undefined;

  constructor(private httpClient: HttpClient) {} //para enviar el artista que se cree al backend.

  ngOnInit(): void {}

  onFileChange(event: Event){
    let target = event.target as HTMLInputElement; // este target es el imput de tipo file donde se carga el archivo.

    if(target.files === null || target.files.length == 0){
      return; // no se procesa ningún archivo.
    }
    this.photoFile = target.files[0]; /* guardo en 'photoFile' el archivo que esté en la posición 0.
      para que cuando + adelante llamemos al método save(), podamos enviar el archivo al backend para
      guardarlo en una carpeta, subirlo a un almacenamiento en la nube, etc.
    */

    // OPCIONAL: PREVISUALIZAR LA IMAGEN POR PANTALLA
    let reader = new FileReader(); /* la clase 'reader' ayudará a leer el contenido del archivo con el
        siguiente par de funciones:
      1. cuando se cargue el reader va a recibir un evento, y el resultado de la lectura lo guarda en una
          nueva variable ('photoPreview').
      2. le ordeno leer el evento.
      */
    reader.onload = event => this.photoPreview = reader.result as string;
    reader.readAsDataURL(this.photoFile);
  }
  save(){ //crear FormData
    let formData = new FormData();
    if(this.photoFile){
      formData.append("photo", this.photoFile); // introducir el photoFile.
    }
    formData.append('name', this.artistForm.get('name')?.value ?? ''); // introducir los datos del artista.
    // httpClient post para enviar el formData al backend:
    this.httpClient.post<Artist>('http://localhost:8080/artists', formData)
    .subscribe((artist: any) => {
      this.photoFile = undefined;
      this.photoPreview = undefined;
      console.log(artist)
    });
  }
}
