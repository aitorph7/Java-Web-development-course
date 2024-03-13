package com.certidevs;

import com.certidevs.model.Album;
import com.certidevs.repository.AlbumRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

		albumRepository.deleteAll();
		albumRepository.save(new Album(null, "1111VG001", 19.95));
		albumRepository.save(new Album(null, "2222VG002", 23.45));
		albumRepository.save(new Album(null, "3333VG003", 16.99));
	}

}
