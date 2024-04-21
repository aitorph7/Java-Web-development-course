package com.certidevs.controller;

import com.certidevs.exception.UnauthorizedException;
import com.certidevs.model.Rating;
import com.certidevs.model.Role;
import com.certidevs.model.User;
import com.certidevs.repository.RatingRepository;
import com.certidevs.security.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class RatingController {

    private RatingRepository ratingRepository;

    @PostMapping("ratings")
    public Rating create(@RequestBody() Rating rating) {

        // TODO: Si el usuario ya tiene un rating para un album, no puede volver a comentarlo:
        // boolean existsPreviousRatings = this.ratingRepository.existsByUserIdAndAlbumId();

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

    @DeleteMapping("ratings/{id}")
    public void deleteById(@PathVariable Long id){

        // Solo si eres ADMIN o has creado el comentario, puedes borrarlo.
        Rating rating = this.ratingRepository.findById(id).orElseThrow();
        User user = SecurityUtils.getAuthUser().orElseThrow();

        if (user.getRole().equals(Role.ADMIN) ||
                (rating.getUser() != null && rating.getUser().getId().equals(user.getId()))
        )
            this.ratingRepository.deleteById(id);
        else
            throw new UnauthorizedException("You're not allowed to delete this rating.");
    }
}
