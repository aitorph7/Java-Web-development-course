package com.certidevs.ifelse;

public class IfElse {


    public static void main(String[] args) {

        // Estructura de control condicional: if, else if, else

        double precio = 66.55;

        if (precio > 50) {
            System.out.println("Gastos de envío gratis.");
        }


        // Si solo hay una sentencia dentro de if entonces no hace falta llaves
        if (precio > 100) System.out.println("Gastos de envío gratis");


        // NO HACE FALTA LLAVES SI SOLO HAY UNA SENTENCIA
        if (precio < 30)
            System.out.println("Envío gratis");
        else
            System.out.println("Envío de pago");



        // Si hay más de una sentencia entonces es obligatorio poner llaves
        // ERROR
        /*
        if (precio < 30)
            System.out.println("Envío gratis");
            System.out.println("Envío gratis");
        else
            System.out.println("Envío de pago");

         */
        // SOLUCIÓN:
        if (precio < 30) {
            System.out.println("Envío gratis");
            System.out.println("Envío gratis");
        }
        else
            System.out.println("Envío de pago");


        if (precio < 30) {
            System.out.println("Envío gratis");
            System.out.println("Envío gratis");
        } else {
            System.out.println("Envío de pago");
            System.out.println("Envío de pago");
        }

    }
}
