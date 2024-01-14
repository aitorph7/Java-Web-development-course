package com.certidevs.funciones;

public class FuncionesConParametrosConRetorno3 {


    public static void main(String[] args) {

        // Crear un array de precios sin IVA double
        double[] preciosSinIVA = {10, 20, 30, 40, 50, 60};

        // invocar una función que recibe como parámetro los precios sin IVA
        // y que retorne un nuevo array con los precios con IVA
        double[] preciosConIVA = calcularIVAs(preciosSinIVA);

    }

    private static double[] calcularIVAs(double[] preciosSinIVA) {
        // sin crear un nuevo array: se modifica el array existente, PROBLEMA: se pierden los datos originales
        /*
        for (int i = 0; i < preciosSinIVA.length; i++) {

            preciosSinIVA[i] = preciosSinIVA[i] * 1.21;
        }
        return preciosSinIVA;
        */

        // opción 2: crear un nuevo array independiente del original para no perder los datos originales
        double[] preciosConIVA = new double[preciosSinIVA.length];
        for (int i = 0; i < preciosSinIVA.length; i++) {
            preciosConIVA[i] = preciosSinIVA[i] * 1.21;
        }
        return preciosConIVA;
    }


}
