package com.certidevs.repository;

import com.certidevs.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findByCatalogNumber(String catalogNumber);

}