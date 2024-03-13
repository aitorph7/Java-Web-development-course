package com.certidevs.controller;

import com.certidevs.model.Album;
import com.certidevs.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
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
//    public Album findById(@PathVariable Long id){
//        return this.albumRepository.findById(id).orElseThrow();
//    }
    @PostMapping("albums")
    public Album create(@RequestBody() Album album){
        return this.albumRepository.save(album);
    }
    @PutMapping("albums/{id}")
    public Album update(@PathVariable Long id, @RequestBody Album album){
        if (this.albumRepository.existsById(id))
            return this.albumRepository.save(album);
        throw new NoSuchElementException();
    }
    @DeleteMapping("albums/{id}")
    public void deleteById(@PathVariable Long id){
        this.albumRepository.deleteById(id);
    }
}
