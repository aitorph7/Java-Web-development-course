package com.certidevs.funciones6;

public class FuncionesVarArgs {

    public static void main(String[] args) {
        // varargs - variable arguments permite aceptar un número variable de
        // argumentos a una función

        System.out.println(sumatorio(10, 20));
        System.out.println(sumatorio(10, 20, 30));
        System.out.println(sumatorio(10, 20, 30, 40));
        System.out.println(sumatorio(10, 20, 30, 40, 50));
        System.out.println(sumatorio(10, 20, 30, 40, 50, 50, 50, 50));

    }

    // acepta cualquier número de parámetros
    private static int sumatorio(int... numeros) { // los parámetros se juntan a un array int[]
        int suma = 0;
        for (int numero : numeros) { // array int[] numeros
            suma += numero;
        }
        return suma ;
    }

    // en python def sumatorio(*numbers):
}
