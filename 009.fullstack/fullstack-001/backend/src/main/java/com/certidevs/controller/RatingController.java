package com.certidevs.controller;

import com.certidevs.model.Rating;
import com.certidevs.repository.RatingRepository;
import com.certidevs.security.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class RatingController {

    private RatingRepository ratingRepository;

    @PostMapping("ratings")
    public Rating create(@RequestBody() Rating rating) {
        // asignar al usuario autenticado antes de guardar el rating:
        SecurityUtils.getAuthUser().ifPresent(user -> rating.setUser(user));

        return this.ratingRepository.save(rating);
    }

    /* No quiero mostrar un listado de ratings, sino que quiero mostrar
     ratings filtrando por álbum; esa pantalla solo la quiero mostrar
     en 'album-detail'. */
    @GetMapping("ratings/filter-by-album/{id}")
    public List<Rating> findAllByAlbumId(@PathVariable Long id){
        return this.ratingRepository.findByAlbum_IdOrderByIdDesc(id);
    }
}
