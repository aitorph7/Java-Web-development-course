import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Album } from '../model/album.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-booking-form',
  standalone: true,
  imports: [HttpClientModule, ReactiveFormsModule],
  templateUrl: './booking-form.component.html',
  styleUrl: './booking-form.component.css'
})
export class BookingFormComponent implements OnInit{

  album: Album | undefined;
  reservationForm = new FormGroup({
    startDate: new FormControl(new Date()),
    finishDate: new FormControl(new Date())
  });

  constructor(
    private httpClient: HttpClient,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: any) => {
      const id = params['id'];
      if(!id) return; // si no hay id, entonces no llamo al backend

      // traer el álbum
      this.httpClient.get<Album>('http://localhost:8080/albums/' + id)
      .subscribe((album: any) => this.album = album);

    });
  }

}
