import { Component, OnInit, TemplateRef } from '@angular/core';
import { Album } from '../model/album.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterLink } from '@angular/router';
import { NgbAlertModule, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';
import { AuthenticationService } from '../authentication/authentication.service';

@Component({
  selector: 'app-album-list',
  standalone: true,
  imports: [RouterLink, NgbAlertModule, DatePipe],
  /*
  'RouterLink' permite navegar en este listado de albumes;
  lo siguiente es meter un enlace en el HTML de este listado de albumes.
  */
  templateUrl: './album-list.component.html',
  styleUrl: './album-list.component.css'
})
export class AlbumListComponent implements OnInit{
  albums: Album[] = [];
  isAdmin = false;
  
  constructor(
    private httpClient: HttpClient,
    private authService: AuthenticationService,
    private modalService: NgbModal // Modal: popup tipo "vas a borrar x datos. ¿Estás seguro?"
  ) {
      this.authService.isAdmin.subscribe((isAdmin: any) => this.isAdmin = isAdmin);  
    };

  ngOnInit(): void {
    this.loadAlbums();/* Trae una lista de usuarios del backend ejecutando 
    una petición HTTP contra controlador del backend.
    */
  }
  delete(album: Album){
    const url = 'http://localhost:8080/albums/' + album.id;
    this.httpClient.delete(url).subscribe((response: any) => {
      this.loadAlbums(); // Recarga los albumes depués de borrar alguno de ellos.
    })
  }

  // hideDeletedAlbumMessage(){
  //   this.showDeletedAlbumMessage = false;
  // }


  private loadAlbums() {
    const url = 'http://localhost:8080/albums';
    this.httpClient.get<Album[]>(url).subscribe((albums: Album[]) => {
      this.albums = albums;
    });
  }

  openModal(modal: TemplateRef<any>, album: Album){
    this.modalService.open(modal, {
      centered: true
    }).result.then((result: any) => {
      if(result === 'Accept'){
        this.delete(album);
      }
    });
  }
  
}
