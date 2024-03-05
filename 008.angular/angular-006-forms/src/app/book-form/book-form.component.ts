import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Book } from '../model/book.model';

@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css'
})
export class BookFormComponent {



  // antes de crear en HTML un formulario, creo en TS los campos que tendrá ese formulario.
  bookForm = this.fb.group({
    id: [0],
    title: [''],
    price: [0.0],
    available: [true],
    publishDate: [new Date()],
    category: [],
    topics: [[]] // array vacío
  });
  
  constructor(private fb: FormBuilder, private httpClient: HttpClient) {}

  save() {
    console.log("Guardando Book");

    // Extraer los valores de cada Input escritos por el usuario
    const id = this.bookForm.get('id')?.value ?? 0;
    const title = this.bookForm.get('title')?.value ?? 'titulo pot defecto';
    const price = this.bookForm.get('price')?.value ?? 0.0;
    const available = this.bookForm.get('avalable')?.value ?? false;
    const publishDate = this.bookForm.get('publishDate')?.value ?? new Date();
    const category = this.bookForm.get('category')?.value ?? 'category1';
    const topics = this.bookForm.get('topics')?.value ?? [];

    // Crear un objeto utilizando los valores exrtraídos2
    const bookToSave: Book = {
      id: id,
      title: title,
      price: price,
      available: available,
      publishDate: publishDate,
      category: category,
      topics: topics
    }
    console.log(bookToSave);

    // Enviar el objeto a backend usando HttpClient
    // De momento comento el siguiente código porque al no haber un backend escuchando,
    // va a provocar un error.
    //const url = 'http;//localhost:8080/books';
    //this.httpClient.post<Book>(url, bookToSave).subscribe(book => console.log(book));
  }
}
