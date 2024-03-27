package com.certidevs.controller;

import com.certidevs.model.Album;
import com.certidevs.model.Artist;
import com.certidevs.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class ArtistController {
    private ArtistRepository artistRepository;

    @GetMapping("artists")
    public List<Artist> findAll(){
        log.info("REST request to findAll artists");
        return this.artistRepository.findAll();
    }
    @GetMapping("artists/{id}")
    public Artist findById(@PathVariable Long id){
        return this.artistRepository.findById(id).orElseThrow();
    }
    // TODO: crear el método POST con la funcionalidad de poder cargar una imagen del artista
}
