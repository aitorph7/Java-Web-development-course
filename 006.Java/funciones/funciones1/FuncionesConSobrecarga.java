package com.certidevs.funciones;

public class FuncionesConSobrecarga {

    /*
   Se puede duplicar funciones siempre y cuando sea diferente:
    * el número de parámetros
    * Tipos de datos de los parámetros

     */
    public static void main(String[] args) {
        // EJEMPLO 1: sumar(int num1, int num2)
        int resultado1 = sumar(10, 20);
        // EJEMPLO 2: sumar(double num1, double num2)
        double resultado2 = sumar(20.11, 30.44);
        // EJEMPLO 3: sumar(int num1, int num2, boolean allowNegative)
        double resultado3 = sumar(10, 20, true);
        // EJEMPLO 4: sumar(int num1, int num2, int num3)
        int resultado4 = sumar(5, 5, 5);
    }
    private static double sumar(int num1, int num2, boolean allowNegative) {
        return num1 + num2;
    }
    private static int sumar(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }
    private static double sumar(double num1, String num2){
        return 0;
    }
    private static double sumar(double num1, double num2) {
        return num1 + num2;
    }
    private static int sumar(int numero1, int numero2) {
        return numero1 + numero2;
    }

}
