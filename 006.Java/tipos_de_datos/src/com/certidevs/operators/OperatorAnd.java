package com.certidevs.operators;

public class OperatorAnd {

    public static void main(String[] args) {

        double price = 556.44;

        boolean isFreeShipping = price > 50;
        boolean isFreeShipping2 = price > 50 && price < 100;
        System.out.println(isFreeShipping);
        System.out.println(isFreeShipping2);

        double weight = 20;

        // Opción 1: combinando 4 condiciones en una misma sentencia
        boolean isFreeShipping3 = price > 50 && price < 100 && weight > 0 && weight < 30;

        // Opción 2: desglosar condiciones
        boolean isCorrectPrice = price > 50 && price < 100;
        boolean isCorrectWeight = weight > 0 && weight < 30;
        boolean result = isCorrectPrice && isCorrectWeight;


    }
}
