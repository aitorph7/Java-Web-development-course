package com.certidevs.funciones;

/*
Cuando se genera con el IDE la función aparece encerrada en unos cuadros para que el desarrollador pueda escribir/cambiar
el tipo de dato o el nombre. Pulsar Enter.
 */
public class FuncionesConParametrosSinRetorno {

    public static void main(String[] args) {

        // Funciones con 1 parámetro
        String nombre = "Alan";
        saludarPorNombre(nombre);
        String apellido = "Sastre";
        saludarPorApellido(apellido);

        // Función con 2 parámetros:
        saludarPorNombreApellido(nombre, apellido);
    }
    private static void saludarPorApellido(String apellido) {
        System.out.println("Hola, Sr./Sra " + apellido);
    }

    // Hay que especificar el tipo de dato de cada parámetro
    private static void saludarPorNombre(String nombre) {
        System.out.println("Hola " + nombre);
        System.out.println("Hola, " + nombre);
    }

    private static void saludarPorNombreApellido(String nombre, String apellido) {
        System.out.println("Hola " + nombre + " " + apellido);
    }

}
