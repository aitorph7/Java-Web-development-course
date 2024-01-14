package com.certidevs.funciones6;

import java.util.Arrays;
import java.util.List;

public class FuncionesVarArgs2 {

    // Ver ejemplos de uso de sintaxis var args en funciones ya existentes en Java JDK
    public static void main(String[] args) {

        // Creación de Listas

        // lista inmutable, no se pueden agregar elementos
        // los elementos de la lista sí se pueden cambiar
        List<String> personas = Arrays.asList("Persona1", "Persona2", "Persona3", "Persona4", "persona5");

        // lista inmutable: no se puede modificar, ni agregar ni borrar
        // los elementos de la lista tampoco se pueden cambiar
        List<String> students = List.of("Carlos", "Eliane", "Fran", "Aitor", "Jawad", "s1", "s2", "s3", "s4", "s5", "s6");

        // imprimir textos String.format(texto, param1, param2, param3......)
        /*
        %s - string
        %d - dígito entero
        %f - es un dígito decimal
        %b - es un boolean
        %c - caracter
        %n - salto línea
         */
        String frase = String.format(
                "FirstName %s LastName %s Age %d Registrado %b Salario %.2f \nHola%nAdios",
                "Ambrosio", "Developer", 30, true, 30000.50
        );
        System.out.println(frase);
    }
}
