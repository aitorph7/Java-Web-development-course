package com.certidevs.funciones3;

import java.util.List;
import java.util.UUID;

public class FuncionesStatic {
    public static void main(String[] args) {

        /*
        El modificador static permite invocar métodos
        sin crear una variable/objeto de la clase.

        NombreClase.nombreMetodo();

        IMPORTANTE: La clase empieza por mayúscula.
         */

        String numeroPrueba = String.valueOf(500.41);
        int valorMin = Math.min(5, 10);
        UUID identificador = UUID.randomUUID();
        double valorMax = Double.max(40.4, 60.2);
        long tiempoActualMs = System.currentTimeMillis();
        boolean isDigit = Character.isDigit('A');
        boolean isLetter = Character.isLetter('5');
        List<String> personas = List.of("Persona1", "Persona2");


    }
}
