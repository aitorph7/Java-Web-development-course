import { Component, OnInit } from '@angular/core';
import { Album } from '../model/album.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterLink } from '@angular/router';

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
    const url = 'http://localhost:8080/albums';
    this.httpClient.get<Album[]>(url).subscribe((albums: Album[]) => {
      console.log(albums);
      this.albums = albums
    });
  }
  
}
