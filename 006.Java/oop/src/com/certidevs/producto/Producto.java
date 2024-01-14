package com.certidevs.producto;

public class Producto {

    // constantes

    // atributos: definen el estado de un objeto
    long id;
    String title;
    double price;
    int quantity;
    // ... más atributos ...

    // métodos constructores
    // si no se especifica ninguno entonces
    // lo interpreta como que existe el constructor
    // vacío por defecto


    public Producto() {
    }

    // aplicamos sobrecarga al crear más constructores
    public Producto(long id, String title, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public Producto(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
