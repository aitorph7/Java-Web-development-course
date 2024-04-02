package com.certidevs.controller;

import com.certidevs.model.Artist;
import com.certidevs.repository.ArtistRepository;
import com.certidevs.service.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    // EXTRA OPCIONAL: además del CRUD permito subir archivos
    // TODO: crear un método POST que reciba el artista y la imagen, llame a un servicio inyectado (fileService) que
    //  guarde el archivo con un método 'store' y me devuelva la ruta a él; guardaré esa ruta en el atributo
    //  'artist.setPhotoUrl'.
    //  Nuevo controlador para servir los archivos.
    @PostMapping("artists")
    public Artist create(
            @RequestParam(value = "photo", required = false) MultipartFile file,
            Artist artist){

        if (file != null && !file.isEmpty()){
            String filename = fileService.store(file);
            artist.setPhotoUrl(filename);
        } else { // si el artista llega sin foto, le asigno el avatar por defecto (guardado en 'uploads').
            artist.setPhotoUrl("avatar.png");
        }
        return this.artistRepository.save(artist);
    }
    @PutMapping("artists/{id}")
    public ResponseEntity<Artist> update(
            @PathVariable Long id,
            Artist artist,
            @RequestParam(value = "photo", required = false) MultipartFile file
    ){
        if (!this.artistRepository.existsById(id))
            return ResponseEntity.notFound().build();
        if (file != null && !file.isEmpty()) {
            String fileName = fileService.store(file);
            artist.setPhotoUrl(fileName);
        }
        return ResponseEntity.ok(this.artistRepository.save(artist));
    }
}
