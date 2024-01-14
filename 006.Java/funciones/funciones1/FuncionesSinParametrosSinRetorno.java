package com.certidevs.funciones;

/**
 * En python una función se declara utilizando la palabra def
 *
 * En java la sintaxis de una función es la siguiente: (modificadores)
 *
 * visibilidad: public, private, protected
 * static: indica que la función pertenece a la clase y no es necesario crear un objeto
 * tipoRetorno:
 *          void: significa que no devuelve nada, no hace falta poner return
 *          int: significa que devuelve un número int
 *          String: significa que devuelve una cadena String
 *          String[]: significa que devuelva un array de String
 *
 * identificador
 * (
 * param1,
 * param2
 * )
 *
 * visibilidad static tipoRetorno identificador ( param ) {
 *
 * }
 */
public class FuncionesSinParametrosSinRetorno {

    public static void holaMundo() {
        System.out.println("Hola mundo 1");
    }

    public static void main(String[] args) {

        holaMundo();
        holaMundo();
        holaMundo2();

    }

    public static void holaMundo2(){
        System.out.println("Hola 2");
    }

}
