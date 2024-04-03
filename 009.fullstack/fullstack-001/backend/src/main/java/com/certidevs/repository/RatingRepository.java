package com.certidevs.repository;

import com.certidevs.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByAlbum_Id(Long id);

}