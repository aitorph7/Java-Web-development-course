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
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(unique = true, nullable = false)
    private String catalogNumber;
    private Double price;
    @Column
    private Boolean published;
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    private AlbumType type;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private RecordCompany recordCompany;

}
