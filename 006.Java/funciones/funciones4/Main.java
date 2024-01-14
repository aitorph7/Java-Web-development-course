package com.certidevs.funciones4;

public class Main {

    public static void main(String[] args) {

        /*
        static
        NombreClase.nombreMetodo();
         */
        int resultado1 = Calculadora.sumar(5, 10);


        /*
        no static
        NombreClase identificador = new NombreClase();
        identificador.nombreMetodo();
         */

        Calculadora calculadoraCasio = new Calculadora();
        int resultado2 = calculadoraCasio.multiplicar(10, 5);
    }
}
