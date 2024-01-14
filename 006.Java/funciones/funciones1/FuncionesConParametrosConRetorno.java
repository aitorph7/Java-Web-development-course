package com.certidevs.funciones;

public class FuncionesConParametrosConRetorno {

    public static final double IVA_TIPO_GENERAL = 1.21; // constante global

    public static void main(String[] args) {
        // IVA_TIPO_GENERAL = 1.15; // No se puede modificar una constante

        double precioSinIVA = 100;
        double precioConIVA = calcularIVA(precioSinIVA);
        System.out.println(precioConIVA);

        precioConIVA = calcularIVA(500);
        System.out.println(precioConIVA);
    }

    private static double calcularIVA(double precioSinIVA) {
        // double ivaTotal = precioSinIVA * 0.21;
        // return precioSinIVA + ivaTotal;
        return precioSinIVA * IVA_TIPO_GENERAL;
    }
}
