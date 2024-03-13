import { Component, OnInit } from '@angular/core';
import { Album } from '../model/album.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterLink } from '@angular/router';
import { NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-album-list',
  standalone: true,
  imports: [HttpClientModule, RouterLink], /*'RouterLink' permite navegar en este listado de albumes;
  lo siguiente es meter un enlace en el HTML de este listado de albumes.
  */
  templateUrl: './album-list.component.html',
  styleUrl: './album-list.component.css'
})
export class AlbumListComponent implements OnInit{
  albums: Album[] = [];
  
  constructor(private httpClient: HttpClient) {};

  ngOnInit(): void {
    this.loadAlbums();/* método implementado haciendo clic dcho. tras
    seleccionar el contenido del método 'delete' + "Refactor..." +
    "Extract to method in class album-list.component"
    */
  }
  delete(album: Album){
    const url = 'http://localhost:8080/albums/' + album.id;
    this.httpClient.delete(url).subscribe((response: any) => {
      this.loadAlbums(); // Recarga los albumes depués de borrar alguno de ellos.
    })
  }
  private loadAlbums() {
    const url = 'http://localhost:8080/albums';
    this.httpClient.get<Album[]>(url).subscribe((albums: Album[]) => {
      this.albums = albums;
    });
  }
  
}
