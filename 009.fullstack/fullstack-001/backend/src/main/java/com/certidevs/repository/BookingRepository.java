package com.certidevs.repository;

import com.certidevs.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Transactional // Genera un contexto transaccional que permite la eliminación (además de insert & update).
    void deleteByAlbumId(Long albumId);
}