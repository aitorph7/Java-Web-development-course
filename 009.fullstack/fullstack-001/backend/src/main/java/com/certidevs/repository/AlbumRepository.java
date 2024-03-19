package com.certidevs.repository;

import com.certidevs.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findByCatalogNumber(String catalogNumber);

    List<Album> findAllByArtist_Id(Long id);
}