package com.certidevs.funciones3;

public class FuncionesNoStatic {

    public static void main(String[] args) {

        /*
        Las funciones que no son static requieren crear un
        objeto/variable y ejecutar la función
        sobre ese objeto/variable.

        Se crea un objeto de la clase que tiene las funciones
        que queremos ejecutar.

        NombreClase identificador = new NombreClase();
        identificador.nombreMetodo();

        IMPORTANTE: estos método no son static, no se pueden
        invocar directamente con el nombre de la clase.
         */
        String prueba = new String("Ejemplo prueba");

        // dependiendo de la variable prueba1, prueba2, prueba3 los métodos retornan valores distintos
        int longitud = prueba.length();
        boolean esVacio = prueba.isEmpty();
        String textoMinusculas = prueba.toLowerCase();
        String resultadoReemplazado = prueba.replace("texto", "contenido");

        /*
        Ejemplo con clase propia
         */


    }
}
