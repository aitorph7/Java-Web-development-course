import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Artist } from '../model/artist.model';

@Component({
  selector: 'app-artist-list',
  standalone: true,
  imports: [HttpClientModule, RouterLink],
  templateUrl: './artist-list.component.html',
  styleUrl: './artist-list.component.css'
})
export class ArtistListComponent implements OnInit{

  artists: Artist[] = [];

  constructor(private httpClient: HttpClient){};

  ngOnInit(): void {
    this.httpClient.get<Artist[]>('http://localhost:8080/artists')
    .subscribe((artists: Artist[]) => this.artists = artists);
  }

}
