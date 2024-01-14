package com.certidevs.operators;

public class OperatorOr {

    public static void main(String[] args) {

        // disyunción, or, ||
        // altgr + 1
        // Con una de las condiciones sea true el resultado es true

        boolean isStudent = false; // crea una variable nueva, por eso pone el tipo de dato
        int age = 60;

        boolean isEligible = isStudent || age < 65;
        System.out.println(isEligible);


        // Combinación de && con ||
        isEligible = age > 20 && age < 65 || isStudent; // Sobrescribe una variable existente, no hace falta poner tipo de datos
        System.out.println(isEligible);
    }
}
