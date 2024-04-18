package com.certidevs.repository;

import com.certidevs.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByAlbum_IdOrderByIdDesc(Long id);

    @Transactional // Genera un contexto transaccional que permite la eliminación (además de insert & update).
    void deleteByAlbumId(Long albumId);


}