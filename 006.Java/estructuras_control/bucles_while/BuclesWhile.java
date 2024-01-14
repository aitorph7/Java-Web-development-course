package com.certidevs.bucles_while;


import java.util.Scanner;

public class BuclesWhile {

    public static void main(String[] args) {

        // EJEMPLO 1: while
        // Bucle while con contador
        int contador = 0;
        while (contador < 10) {
            System.out.println(contador);
            contador++;
        }

        // EJEMPLO 2: do while
        // do while itera al menos una vez, pedir la contraseña hasta que sea correcta
        String password = "admin";
        Scanner scanner = new Scanner(System.in);
        String userPassword;
        do {
            System.out.println("Introduce tu password: ");
            userPassword = scanner.nextLine();

        } while (! userPassword.equals(password)); // equals más recomendable que != porque compara el contenido y tiene en cuenta null
        // "prueba".equals("admin") --> false --> true sigue iterando
        // "admin1234".equals("admin") --> false --> true sigue iterando
        // "admin".equals("admin") --> true --> false no itera más
    }
}
