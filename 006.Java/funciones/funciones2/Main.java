package com.certidevs.funciones2;

public class Main {

    public static void main(String[] args) {

        /*
        Invocar una función de otra clase.
        El nombre de la clase empieza en MAYÚSCULA
         */
        int resultado1 = CalculadoraBasica.sumar(10, 20);
        int resultado2 = CalculadoraBasica.restar(20, 30);
        double resultado3 = CalculadoraBasica.multiplicar(30.1, 22.33);

        double media = CalculadoraAvanzada.calcularMedia(new double[] {10.40, 20.99, 32.11});
    }
}
