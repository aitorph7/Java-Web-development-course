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

  artist: Artist | undefined;

  artistForm = new FormGroup({
    name: new FormControl('')
  });
  
  constructor(private httpClient: HttpClient) {} //para enviar el artista que se cree al backend.


  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

}
