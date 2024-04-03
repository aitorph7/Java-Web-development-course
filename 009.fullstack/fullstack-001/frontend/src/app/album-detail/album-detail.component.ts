import { Component, OnInit } from '@angular/core';
import { Album } from '../model/album.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Rating } from '../model/rating.model';
import { NgbRatingModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-album-detail',
  standalone: true,
  imports: [HttpClientModule, RouterLink, NgbRatingModule],
  templateUrl: './album-detail.component.html',
  styleUrl: './album-detail.component.css'
})
export class AlbumDetailComponent implements OnInit{

  album: Album | undefined; // importo un objeto de la clase Album.
  ratings: Rating[] = [];

  constructor(
    private activatedRoute: ActivatedRoute, // Porque lo necesito para acceder al param 'id' de la url.
    private httpClient: HttpClient // Para llamar al controlador del backend y traer el dato.
  ){}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: { [x: string]: any; }) => {
      const id = params['id']; // Así extraigo el 'id' de la url.
      if (!id) return;

      // Ahora, teniendo en cuenta que quiero traer el disco del backend, llamo al controlador:
      const url = 'http://localhost:8080/albums/' + id;
      this.httpClient.get<Album>(url).subscribe((alb: Album | undefined) => {
        this.album = alb;
        console.log(this.album);
      });

      /*
      Para crear una pantalla 'detail' de máximo nivel:

      - Podría llamar a otros controladores (si los tuviera) y traer más datos como
        /tracks/filter-by-album/id ...para traer todas las pistas de un album.*/

      // - Podría traer todos los ratings de un album... /ratings/filter-by-album/id
      this.httpClient.get<Rating[]>('http://localhost:8080/ratings/filter-by-album/' + id)
      .subscribe((ratings: any) => this.ratings = ratings);

      /*
      - Podría traer todos los géneros de un album... /genres/filter-by-album/id

      - Suponiendo que la conexión fuera LAZY y no lo trajese de manera automática, podría
        traer al artista de un album... /artist/filter-by-album/id
      */
    });
  }

}
