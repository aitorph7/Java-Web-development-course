package com.certidevs.switchs;

public class SwitchMejorado {

    public static void main(String[] args) {

        /*
        No es necesario el break en este tipo de switch
        Enhanced switch
         */
        int weekDay = 3;

        switch (weekDay) {
            case 1 -> System.out.println("Lunes");
            case 2 -> {
                // Si un caso tiene más de una sentencia necesita llaves
                System.out.println("Martes");
                System.out.println("Martes");
                // ...
            }
            case 3 -> System.out.println("Miércoles");
            case 4 -> System.out.println("Jueves");
            case 5 -> System.out.println("Viernes");
            case 6 -> System.out.println("Sábado");
            case 7 -> System.out.println("Domingo");
            default -> System.out.println("Valor incorrecto");
        }
    }
}
