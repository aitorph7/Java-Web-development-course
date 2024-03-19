package com.certidevs.controller;

import com.certidevs.model.Booking;
import com.certidevs.repository.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class BookingController {

    private final BookingRepository bookingRepository;

    @PostMapping("bookings")
    public Booking create(@RequestBody Booking booking){
        // TODO: cuando haya SecurityContext extraer el usuario autenticado y asociarlo a esta reserva.
        return this.bookingRepository.save(booking);
    }

}
