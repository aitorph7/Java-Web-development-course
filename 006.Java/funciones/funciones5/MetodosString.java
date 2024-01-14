package com.certidevs.funciones5;

public class MetodosString {

    public static void main(String[] args) {

        String fullName = "Ambrosio Developer";


        // OBTENER LA PRIMERA PALABRA DE LA FRASE fullName

        /*
        usando split
         */
        String[] palabras = fullName.split(" ");
        String firstName = palabras[0]; // firstname
        System.out.println(firstName);

        /*
        usando indexOf y substring
         */
        int beginIndex = 0;
        // int endIndex = 8;
        int endIndex = fullName.indexOf(" "); // Calcula la posición del caracter espacio: 8
        String firstName2 = fullName.substring(beginIndex, endIndex);
        System.out.println(firstName2);

        /*
        extraer lastName (apellido) de fullName
        Ambrosio Developer
         */

        // OPCIÓN 1 - split
        String lastName = palabras[1]; // lastname
        System.out.println(lastName);

        // OPCIÓN 2 - substring de 1 parámetro
        beginIndex = fullName.indexOf(" ") + 1; // la posición de la primera letra de la segunda palabra
        String lastName2 = fullName.substring(beginIndex);
        System.out.println(lastName2);

        // OPCIÓN 3 - substring de 2 parámetros
        endIndex = fullName.length(); // Ambrosio Developer: 18, como la última es excluyente ya calcula hasta la 17
        String lastName3 = fullName.substring(beginIndex, endIndex);
        System.out.println(lastName3);
    }
}
