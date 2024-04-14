import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';

@Component({
  selector: 'app-avatar-form',
  standalone: true,
  imports: [],
  templateUrl: './avatar-form.component.html',
  styleUrl: './avatar-form.component.css'
})
export class AvatarFormComponent implements OnInit{

  photoFile: File | undefined;
  photoPreview: string | undefined;
  user: User | undefined;

  constructor(private httpClient: HttpClient){}

  ngOnInit(): void {
    this.httpClient.get<User>('http://localhost:8080/users/account')
    .subscribe((user : any) => this.user = user);
  }

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

  save(){
    if (!this.photoFile) return;

    let formData = new FormData();
    formData.append("photo", this.photoFile);
    
    const url = 'http://localhost:8080/users/account/avatar';
    this.httpClient.post<User>(url, formData)
    .subscribe((user: any) => this.user = user);
  }

}
