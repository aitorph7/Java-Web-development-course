package com.certidevs.controller;

import com.certidevs.exception.ConflictDeleteException;
import com.certidevs.model.Album;
import com.certidevs.model.Role;
import com.certidevs.model.User;
import com.certidevs.repository.AlbumRepository;
import com.certidevs.repository.BookingRepository;
import com.certidevs.repository.RatingRepository;
import com.certidevs.security.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final RatingRepository ratingRepository; // lo necesito para eliminar los ratings asociados al album.
    private final BookingRepository bookingRepository;

    @GetMapping("albums")
    public List<Album> findAll(){
        log.info("REST request to findAll albums");
        User user = SecurityUtils.getAuthUser().orElseThrow();

        if(user.getRole().equals(Role.ADMIN))
            return this.albumRepository.findAll();
        else
            return this.albumRepository.findByPublishedTrue();

//      SecurityUtils.getAuthUser().ifPresent(System.out::println); Imprime por consola el usuario con un método...
        // ... referenciado de Java; PROGRAMACIÓN FUNCIONAL: es como un 'if()' de 4 líneas de código:
        // Optional<User> userOptional = SecurityUtils.getAuthUser();
        // if (userOptional.isPresent()){
        // |     User user = userOptional.get();
        // |     System.out.println(user);
        // }
        // ... pero en 1 sola línea.
        // Cada vez que vaya a trabajar con un 'Optional' en su lugar puedo usar un '.ifPresent'
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

    // obtener álbumes filtrando por artista:
    @GetMapping("albums/filter-by-artist/{id}")
    public List<Album> findAllByArtistId (@PathVariable Long id){
        return this.albumRepository.findAllByArtist_Id(id);
    }

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
        // Opción 1: borar el libro, pero antes desasociar o borrar aquellos objetos que apunten al album.
//        try{
//            this.ratingRepository.deleteByAlbumId(id);
//            this.bookingRepository.deleteByAlbumId(id);
//            this.albumRepository.deleteById(id);
//        } catch (Exception e) {
//            log.error("Error deleting album", e);
//            throw new ConflictDeleteException("Unable to delete album");
//        }


//      opción 2: desactivar/ archivar el album
        Album album = this.albumRepository.findById(id).orElseThrow();
        album.setPublished(false);
        albumRepository.save(album);
    }
}
