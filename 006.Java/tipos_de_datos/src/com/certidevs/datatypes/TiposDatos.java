package com.certidevs.datatypes;

public class TiposDatos {

    public static void main(String[] args) {

        // números enteros: habituales int y long
        byte numero1 = 10;
        short numero2 = 500;
        int numero3 = 1000000000;
        int edad = 40;
        long numero4 = 10000000000000000L; // La L indica que es un long
        long productId = 1;

        // números decimales: float y double
        float numeroDecimal1 = 39.99F; // La F indica que es un float
        float numeroDecimal2 = (float) 41.11;
        double precio1 = 567899.50;
        double precio2 = 567_899.50;
        double salario = 3000.43;

        // boolean verdadero o falso. true y false empiezan por minúsculas
        boolean isActive = true;
        boolean isStudent = false;

        // char Carácter. No es tan común para el día el día
        // Ocuba 2 bytes, es más óptimo que String cuando se trabaja con un caracteres
        char letraA = 'A';
        char otroSimbolo = '$';
        //char otroChar = 'ALAN'; // Solo admite máximo 1 caracter

        // Textos: String, es una clase. Es un un tipo de dato de referencia y tiene métodos
        String firstName = "Alan";
        String email = "alan@certidevs.com";
        boolean isEmpty = email.isEmpty();

        // tipos primitivos (int,double,boolean) vs. Tipos de referencia (String)
        String lastName = null; // equivale a None de python
        // double salary = null;
        // double salary = 0;

        System.out.println(numero1);
        System.out.println(numero2);

        String textoLargo = """
                Descripción larga
                con varias líneas
                una detrás de otra
                adios
                """;

        String descripcionLarga = "Hola que tal estamos en el curso de " +
                "Java explicando los Strings" +
                "y nadie se entera";

    }
}
