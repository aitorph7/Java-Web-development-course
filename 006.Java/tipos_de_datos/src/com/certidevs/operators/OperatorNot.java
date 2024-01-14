package com.certidevs.operators;

public class OperatorNot {

    public static void main(String[] args) {

        // ! not, invierte el valor de un boolean
        // Es decir, si tienes verdadero lo cambia a falso
        // Si tienes falso lo cambia a verdadero
        boolean isAdult = true;
        System.out.println(isAdult);

        // OPCIÓN 1: Utilizar directamente el resultado de la negación en una operación
        System.out.println(!isAdult);
        // OPCIÓN 2: Se puede guardar el resultado de la negación en una variable
        boolean isNotAdult = !isAdult;

        System.out.println(isNotAdult);
    }
}
