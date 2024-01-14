package com.certidevs.producto;

public class Main {

    public static void main(String[] args) {

        // NombreClase identificador = new NombreClase();
        // Alt + Enter sobre el error te saca las sugerencias
        // Hacer clic sobre el código en rojo y esperar a que aparezca la bombilla roja

        Producto prod1 = new Producto();
        prod1.title = "iPhone 15";
        prod1.price = 29.99;
        prod1.quantity = 5;
        prod1.id = 1L; // L indica que es long
        System.out.println(prod1);
        System.out.println(prod1.title);

        Producto prod2 = new Producto(2L, "TV", 500.0, 3);
        Producto prod3 = new Producto(3L, "Micro", 100, 3);
        Producto prod4 = new Producto("Disco duro");


        String prueba = new String();
        String nombre = new String("mi string");

        // Para poder imprimir un objeto Producto
        // y mostrar una representación textual de cada atributo
        // es necesario implementar el método toString()


    }
}
