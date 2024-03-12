package com.certidevs.controller;

import com.certidevs.model.Album;
import com.certidevs.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*") //Para permitir acceso desde cualquier dominio desde el exterior.
@RestController
@AllArgsConstructor
@Slf4j // Proporciona el objeto log en la consola del backend.
public class AlbumController {

    private final AlbumRepository albumRepository;

    @GetMapping("albums")
    public List<Album> findAll(){
        log.info("REST request to findAll albums");
        return this.albumRepository.findAll();
    }
    @GetMapping("albums/{id}")
    public ResponseEntity<Album> findById(@PathVariable Long id){
        Optional<Album> albumOptional = albumRepository.findById(id);
        if (albumOptional.isPresent())
            return ResponseEntity.ok(albumOptional.get());
        else
            return ResponseEntity.notFound().build();
    }
//    @GetMapping("albums/{id}")
//    public Album finsById(@PathVariable Long id){
//        return this.albumRepository.findById(id).orElseThrow();
//    }
}
