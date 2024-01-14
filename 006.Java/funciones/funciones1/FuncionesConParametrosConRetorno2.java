package com.certidevs.funciones;

public class FuncionesConParametrosConRetorno2 {


    public static void main(String[] args) {

        // array de calificaciones double con 5 calificaciones
        double[] calificaciones = { 5.6, 7.5, 4.3, 8.5, 9.2 };


        // llamar a una función que calcule la nota media y la retorne
        double calificacionMedia1 = calcularCalificacionMedia(calificaciones);
        System.out.println(calificacionMedia1);

        // En la misma línea se crea el array y se pasa como parámetro
        double calificacionMedia2 = calcularCalificacionMedia(new double[]{ 7.6, 8.5, 9.3, 8.5, 9.6 });
        System.out.println(calificacionMedia2);



        // redondear:
        long notaFinal = Math.round(calificacionMedia2); // invocar round() de la clase Math sin crear un objeto porque es static
        System.out.println(notaFinal);

        String notaFinalFormateada = String.format("%.2f", calificacionMedia1);
        System.out.println(notaFinalFormateada);

        System.out.printf("Nota final: %.2f", calificacionMedia2);


    }

    private static double calcularCalificacionMedia(double[] calificaciones) {
        double sumatorio = 0;

        for (double calificacion : calificaciones) {
            sumatorio += calificacion;
        }

        return sumatorio / calificaciones.length;
    }


}
