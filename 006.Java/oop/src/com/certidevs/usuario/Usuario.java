package com.certidevs.usuario;

public class Usuario {

    // atributos
    long id;
    String fullName;
    String email;
    int age = 20; // por defecto es 20
    boolean active; // por defecto es false

    // metodos constructores
    public Usuario() {}

    public Usuario(long id, String fullName, String email, int age, boolean active) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.active = active;
    }

    public Usuario(long id, String fullName, String email, int age) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.active = true; // Lo marcamos a true por defecto
    }

    // resto de método


    @Override
    public String toString() {
        return "Usuario {" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}
