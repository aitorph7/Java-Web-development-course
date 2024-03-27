package com.certidevs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    @Column(columnDefinition = "boolean") // así utilizará tinyint en lugar de bit.
    private Boolean active;
    private LocalDate estYear;
    private String photoUrl;
    @Column(length = 1000) // ampliar la longitud de 255 a 1000
    private String bio;
}
