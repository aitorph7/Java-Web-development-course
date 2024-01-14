package com.certidevs.usuario;

public class Main {

    public static void main(String[] args) {

        // Crear usuario con const vacío
        Usuario user1 = new Usuario();
        // Modificar los valores de los atributos de un objeto existente
        user1.id = 1L;
        user1.fullName = "Mike developer";
        user1.email = "mike@gmail.com";
        user1.age = 30;
        user1.active = true;
        System.out.println(user1);

        // Crear usuario con const con todos los parámetros
        Usuario user2 = new Usuario(
                2L,
                "Ambrosio developer",
                "ambro.dev@gmail.com",
                40,
                false
        );
        System.out.println(user2);

        // Crear usuario con el constructor sin active
        Usuario user3 = new Usuario(
                3L,
                "Bob developer",
                "bob@gmail.com",
                26
        );
        System.out.println(user3);
    }
}
