package com.certidevs.ifelse;

public class IfElseIf {

    public static void main(String[] args) {

        int hora = 19;

        //if (0 < hora <= 8) {

        if (hora > 0 && hora <= 8)
            System.out.println("Durmiendo");

        else if (hora > 8 && hora <= 15)
            System.out.println("Curso Angular");

        else if (hora > 15 && hora < 21)
            System.out.println("Curso Java");

        else
            System.out.println("Valor incorrecto");


    }
}
