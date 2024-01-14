package com.certidevs.datatypes;



public class ConversionesTipos {

    public static void main(String[] args) {

        // de tipo más pequeño a tipo más grande (implíticas, automático)

        int countryArea = 200_000;
        long countryArea2 = countryArea; // int a long automático
        System.out.println(countryArea);
        System.out.println(countryArea2);

        // float a double
        float altura = 180.55F;
        double altura2 = altura;

        // de tipo más grande a tipo más pequeño (explícita, casting)
        // CUIDADO: si el long no cabe en el int entonces habrá INCONSISTENCIAS
        long countryPopulation = 5004404044445454545L;
        int countryPopulation2 = (int) countryPopulation; // long a int
        System.out.println(countryPopulation);
        System.out.println(countryPopulation2);


        // instanceof es una palabra reservada en java para comprobar si un objeto es de una clase en específico

        // Entre tipos de datos distintos de double a int
        double precio = 45.99;
        int precio2 = (int) precio; // pierde el decimal
        int precio3 = (int) Math.round(precio); // redondea el decimal
        System.out.println(precio);
        System.out.println(precio2);
        System.out.println(precio3);

        // String a double
        String salario1 = "3562.32";
        double salario2 = Double.parseDouble(salario1);
        System.out.println(salario2);

        // double a String
        double precioLaptop = 899.99;
        String precioLaptop2 = precioLaptop + "";
        String precioLaptop3 = String.valueOf(precioLaptop);
        System.out.println(precioLaptop2);
        System.out.println(precioLaptop3);
        System.out.println(precioLaptop3 + 5);

    }
}
