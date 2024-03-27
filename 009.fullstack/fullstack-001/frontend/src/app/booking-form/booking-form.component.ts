import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Album } from '../model/album.model';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Booking } from '../model/booking.model';
import { CurrencyPipe } from '@angular/common';
import { NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-booking-form',
  standalone: true,
  imports: [HttpClientModule, ReactiveFormsModule, CurrencyPipe, NgbAlertModule, RouterLink],
  templateUrl: './booking-form.component.html',
  styleUrl: './booking-form.component.css'
})
export class BookingFormComponent implements OnInit{

  album: Album | undefined;
  booking: Booking | undefined;

  bookingForm = new FormGroup({
    startDate: new FormControl(new Date()),
    finishDate: new FormControl(new Date()),
    extraItems: new FormControl<string>('0'),
    isPremiumShip: new FormControl<boolean>(false)
    
  });

  bookedDayPrice = 0; // coste del día de reserva del álbum
  shippingPrice = 0;
  extraPrice = 0; // coste de los servicios extra
  totalPrice = 0;
  numDays = 0;
  showFinishMessage = false; // para mostrtar un mensaje de ocnfirmación (desactivado por defecto).

  constructor(
    private httpClient: HttpClient,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: any) => {
      const id = params['id'];
      if(!id) {
        return; // si no hay id, entonces no llamo al backend
      }
      // traer el álbum
      this.httpClient.get<Album>('http://localhost:8080/albums/' + id)
      .subscribe((album: any) => this.album = album);
    });

  }
  

  calculatePrice(){

   // 1º. Obtener fecha inicio y fecha fin
    let startDate = this.bookingForm.get('startDate')?.value;
    let finishDate = this.bookingForm.get('finishDate')?.value;

    if(!startDate || !finishDate || !this.album || !this.album.price){
      return; // si no hay fechas o album, no calculo nada y me marcho.
    }

   // 2º. Calcular la diferencia de días entre fechas
    startDate = new Date(startDate);
    finishDate = new Date(finishDate);

    const diffMilliseconds = finishDate.getTime() - startDate.getTime();
    if(diffMilliseconds <= 0) {
      this.bookedDayPrice = 0;
      this.numDays = 0;
      this.totalPrice = 0;
      return; // fechas incorrectas
    }
    // ahora debo pasar el resultado de miliseconds a días
    this.numDays = Math.round(diffMilliseconds / (1000 * 60 * 60 * 24));
    if(this.numDays <= 0) {
      this.bookedDayPrice = 0;
      this.numDays = 0;
      this.totalPrice = 0;
      return;
    }

   // 3º. Calcular precio reserva según el nº de días
    this.bookedDayPrice = this.numDays * this.album.price;
    this.totalPrice = this.bookedDayPrice;

    // 4º. Sumar el precio de los items extra
    const extra = this.bookingForm.get('extraItems')?.value || '0';
    console.log(extra);
    console.log(typeof extra); // string
    console.log(typeof Number(extra)); // number

    this.extraPrice = Number(extra);
    this.totalPrice += this.extraPrice;
    
    // 5º. Sumar (o no) al precio los gastos de envío
    if (this.bookingForm.get('isPremiumShip')?.value){
      this.shippingPrice = 4.99;
      this.totalPrice += this.shippingPrice;
    } else {
      this.shippingPrice = 0;
    }

  }

  save(){

    const startDate = this.bookingForm.get('startDate')?.value;
    const finishDate = this.bookingForm.get('finishDate')?.value;

    if(!startDate || !finishDate || !this.album){
      return; // si faltan fechas o libro, no lo guarda en BD
    }
    const booking: Booking = {
      id: 0,
      startDate: startDate,
      finishDate: finishDate,
      price: this.totalPrice,
      album: this.album
    }
    // enviar a backend con httpClient post
    this.httpClient.post<Booking>('http://localhost:8080/bookings', booking)
    .subscribe((booking: any) => {
      this.booking = booking;
      this.showFinishMessage = true;
    })
  }
}
