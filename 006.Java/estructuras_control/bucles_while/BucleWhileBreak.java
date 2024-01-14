package com.certidevs.bucles_while;

public class BucleWhileBreak {

    public static void main(String[] args) {

        // array de nombres String
        String[] nombres =  {"pepito", "juanito", "Wally", "jaimito", "John"};

        // while comprobar si existe Wally, si existe rompe el bucle
        boolean found = false;
        int i = 0;

        while (i < nombres.length) {

            if (nombres[i].equals("Wally")) {
                found = true;
                break; // Sale del bucle porque ya se encontró
            }
            i++; // Incrementar contador

        }

        if (found)
            System.out.println("Wally ha sido encontrado");
        else
            System.out.println("No hubo suerte buscando a Wally");
    }
}
