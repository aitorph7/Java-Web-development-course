package com.certidevs.repository;

import com.certidevs.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(String name);
}