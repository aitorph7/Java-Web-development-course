import { Component, OnInit } from '@angular/core';
import { Album } from '../model/album.model';
import { Artist } from '../model/artist.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-artist-detail',
  standalone: true,
  imports: [HttpClientModule, RouterLink, DatePipe],
  templateUrl: './artist-detail.component.html',
  styleUrl: './artist-detail.component.css'
})
export class ArtistDetailComponent implements OnInit{

  artist: Artist | undefined;
  albums: Album [] = [];

  constructor(
    private httpClient: HttpClient,
    private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: any) => {
      const id = params['id'];
      if(!id) return; // si no hay id, entonces no llamo al backend

      // traer el artista
      this.httpClient.get<Artist>('http://localhost:8080/artists/' + id)
      .subscribe((artist: any) => this.artist = artist);

      // traer los albumes del artista
      this.httpClient.get<Album>('http://localhost:8080/albums/filter-by-artist/' + id)
      .subscribe((albums: any) => this.albums = albums);

    });
  }

}
