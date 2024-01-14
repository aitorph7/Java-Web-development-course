package com.certidevs.input;

import java.util.Locale;
import java.util.Scanner;

public class ReadConsole {


    public static void main(String[] args) {

        // Crear un objeto de la clase Scanner
        // new operador para crear objetos
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);

        // Leer String
        System.out.println("Introduce tu nombre");
        String nombre = scanner.nextLine();
        System.out.println("Tu nombre es: " + nombre);

        // Leer int
        System.out.println("Introduce tu edad");
        int edad = scanner.nextInt(); // nextInt lee un número entero
        System.out.println("Tu edad es: " + edad);

        // Leer float
        System.out.println("Introduce salario");
        float salario = scanner.nextFloat(); // 3000,45 // Depende de la configuración regional de teclado
        System.out.println("Tu salario es: " + salario);

        // Leer double
        System.out.println("Introduce altura");
        double altura = scanner.nextDouble();
        System.out.println("Tu altura es: " + altura);

        // Leer boolean
        System.out.println("¿Estudias o trabajas? true/false ");
        boolean estasTrabajando = scanner.nextBoolean();
        System.out.println("Laburando: " + estasTrabajando);

    }


}
