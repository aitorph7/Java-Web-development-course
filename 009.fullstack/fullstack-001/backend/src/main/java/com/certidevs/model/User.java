package com.certidevs.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "a_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString // para que lo imprima por consola
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String street;
    private String photoUrl;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
