package com.certidevs;

import com.certidevs.model.Album;
import com.certidevs.model.Artist;
import com.certidevs.repository.AlbumRepository;
import com.certidevs.repository.ArtistRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

		Artist artist1 = new Artist(null, "Mike Oldfield", "England", false);
		Artist artist2 = new Artist(null, "Simple Minds", "England", false);
		Artist artist3 = new Artist(null, "Roy Orbison", "USA", false);
		artistRepository.saveAll(List.of(artist1, artist2, artist3));

		albumRepository.save(new Album(null, "1111VG001", 19.95, artist1));
		albumRepository.save(new Album(null, "2222VG002", 23.45, artist2));
		albumRepository.save(new Album(null, "3333VG003", 16.99, artist3));

	}

}
