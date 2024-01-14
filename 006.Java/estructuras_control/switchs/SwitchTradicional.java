package com.certidevs.switchs;

public class SwitchTradicional {

    public static void main(String[] args) {

        // Imprimir el día de la semana en texto en función del número

        int weekDay = 2;

        /*
        Si no se pone break se hace una caída en la que se ejecutan
        varios casos hasta encontrar un break o return
         */
        switch (weekDay) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Valor incorrecto.");
        }
    }
}
