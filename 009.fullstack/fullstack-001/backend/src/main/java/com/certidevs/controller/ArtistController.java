package com.certidevs.controller;

import com.certidevs.model.Album;
import com.certidevs.model.Artist;
import com.certidevs.repository.ArtistRepository;
import com.certidevs.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class ArtistController {
    private ArtistRepository artistRepository;
    private FileService fileService;

    @GetMapping("artists")
    public List<Artist> findAll(){
        log.info("REST request to findAll artists");
        return this.artistRepository.findAll();
    }
    @GetMapping("artists/{id}")
    public Artist findById(@PathVariable Long id){
        return this.artistRepository.findById(id).orElseThrow();
    }
    // TODO: crear un método POST que reciba el artista y la imagen, llame a un servicio inyectado (fileService) que
    //  guarde el archivo con un método 'store' y me devuelva la ruta a él; guardaré esa ruta en el atributo
    //  'artist.setPhotoUrl'.
    //  Nuevo controlador para servir los archivos.
    @PostMapping("artists")
    public Artist create(@RequestParam("photo") MultipartFile file, Artist artist){

        artist.setPhotoUrl(fileService.store(file));

        return this.artistRepository.save(artist);
    }
}
