package com.certidevs;

import com.certidevs.model.Album;
import com.certidevs.model.Artist;
import com.certidevs.repository.AlbumRepository;
import com.certidevs.repository.ArtistRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BackendApplication.class, args);
		/*
		Insertar datos demo desde aquí.
		NO insertarlos directamente desde MySQL Workbench de forma manual, para evitar
		que Hibernate no los detecte.
		 */
		AlbumRepository albumRepository = context.getBean(AlbumRepository.class);
		ArtistRepository artistRepository = context.getBean(ArtistRepository.class);

		albumRepository.deleteAll();
		artistRepository.deleteAll();

		Artist artist1 = new Artist(null, "Mike Oldfield", "England", false, LocalDate.of(1967, 01, 01));
		Artist artist2 = new Artist(null, "Simple Minds", "Scotland", true, LocalDate.of(1977, 01,01));
		Artist artist3 = new Artist(null, "Roy Orbison", "USA", false, LocalDate.of(1953, 01, 01));
		Artist artist4 = new Artist(null, "Alice in Chains", "USA", true, LocalDate.of(1987, 01, 01));
		Artist artist5 = new Artist(null, "Depeche Mode", "England", true, LocalDate.of(1980, 01, 01));
		Artist artist6 = new Artist(null, "Manowar", "USA", true, LocalDate.of(1980, 01, 01));
		artistRepository.saveAll(List.of(artist1, artist2, artist3, artist4, artist5, artist6));

		// antes de asociar autores hay que guardarlos! ojo 👁

		albumRepository.save(new Album(null, "1111VG001", 19.95, artist1));
		albumRepository.save(new Album(null, "2222VG002", 23.45, artist2));
		albumRepository.save(new Album(null, "3333VG003", 16.99, artist3));

	}

}
