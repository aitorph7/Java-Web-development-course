## OPCIONES PARA EL MÉTODO SAVE() EN ALBUM-FORM.COMPONENT.TS - CLASE DEL MARTES 12 MARZO 2024 ##

    // OPCIÓN 1: extraer los valores del formulario manualmente uno a uno: (+ control)
    const album: Album = {
      id: this.albumForm.get('id')?.value ?? 0,
      catalogNumber: this.albumForm.get('catalogNumber')?.value ?? '',
      price: this.albumForm.get('price')?.value ?? 0.0
    }
    console.log(album);

    // OPCIÓN 2: equivalente a la anterior pero en una sola línea de código: (+ rapidez)
    const album2: Album = this.albumForm.value as Album;
    // console.log(album2);

    const url = "http://localhost:8080/albums";

    // OPCIÓN 01.
    /*
    this.httpClient.post<Album>(url, album).subscribe(albumFromBackend => {
      console.log(albumFromBackend);
      Elige uno de los siguientes métodos de navegación:
        01. Navegar hacia el listado:
      this.router.navigate(['/albums']);

        02. Navegar hacia detail:
      this.router.navigate(['/albums', albumFromBackend.id, 'detail']);
    }, error => {
      console.log(error),
      window.alert("Invalid data");
    });
    */

    // OPCIÓN 02. Para resolver el tachado de 'subscribe' (deprecado)
    this.httpClient.post<Album>(url, album).subscribe({
      next: (albumFromBackend: { id: any; }) => this.router.navigate(['/albums', albumFromBackend.id, 'detail']),
      error: (error: any) => window.alert("Invalid Data"),
    });

      /*
      A continuación el método de arriba como PLANTILLA:

      this.httpClient.post<Album>(url, album).subscribe({
        // si todo va bien se ejecuta next
        next: () => {},
        // si todo va mal se ejecuta error
        error: () => {},
      });
      */
    
