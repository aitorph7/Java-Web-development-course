package com.certidevs;

import com.certidevs.model.*;
import com.certidevs.repository.*;
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

		EN PRODUCCIÓN NO SE INSERTARÍAN DATOS ASÍ NI SE BORRARÍAN LOS DATOS ACTUALES.
		En producción se suele utilizar un framework de control de versiones sobre la BD
		como 'Liquibase' o 'Flyway'.
		
		Todos estos datos en un futuro los reemplazaré con datos creados en un archivo
		DATA.SQL; algo bastante habitual en este tipo de aplicaciones, que sea un script
		de SQL quien inserte los datos.
		 */
		AlbumRepository albumRepository = context.getBean(AlbumRepository.class);
		ArtistRepository artistRepository = context.getBean(ArtistRepository.class);
		RecordCompanyRepository recordCompanyRepository = context.getBean(RecordCompanyRepository.class);
		RatingRepository ratingRepository = context.getBean(RatingRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		BookingRepository bookingRepository = context.getBean(BookingRepository.class);

		/*
		1º borro los álbumes porque tienen asociaciones hacia artistas y discográficas.
		Si borro 1º un artista o disquera dará error al haber álbumes apuntando a ellos.
		*/
		bookingRepository.deleteAll();
		ratingRepository.deleteAll();
		albumRepository.deleteAll(); // Borro los datos que haya para que se generen nuevos datos.
		recordCompanyRepository.deleteAll();
		artistRepository.deleteAll();
		userRepository.deleteAll();

		Artist artist1 = new Artist(null, "Mike Oldfield", "England", false, LocalDate.of(1967, 1, 1), "avatar.png", "Texto largo de leer");
		Artist artist2 = new Artist(null, "Simple Minds", "Scotland", true, LocalDate.of(1977, 1,1),"avatar.png", "Texto largo de leer");
		Artist artist3 = new Artist(null, "Roy Orbison", "USA", false, LocalDate.of(1953, 1, 1),"avatar.png", "Texto largo de leer");
		Artist artist4 = new Artist(null, "Alice in Chains", "USA", true, LocalDate.of(1987, 1, 1),"avatar.png", "Texto largo de leer");
		Artist artist5 = new Artist(null, "Depeche Mode", "England", true, LocalDate.of(1980, 1, 1),"avatar.png", "Texto largo de leer");
		Artist artist6 = new Artist(null, "Manowar", "USA", true, LocalDate.of(1980, 1, 1),"avatar.png", "Texto largo de leer");
		Artist artist7 = new Artist(null, "Metallica", "USA", true, LocalDate.of(1981, 1, 1),"avatar.png", "Texto largo de leer");
		Artist artist8 = new Artist(null, "Queen", "England", true, LocalDate.of(1970, 1, 1),"avatar.png", "Texto largo de leer");
		artistRepository.saveAll(List.of(artist1, artist2, artist3, artist4, artist5, artist6, artist7, artist8));

		RecordCompany company1 = new RecordCompany(null, "Virgin Records", "record_Co.png", 1972, "long description");
		RecordCompany company2 = new RecordCompany(null, "Elektra Records", "record_Co.png", 1950, "long description");
		RecordCompany company3 = new RecordCompany(null, "EMI", "record_Co.png", 1931, "long description");
		recordCompanyRepository.saveAll(List.of(company1, company2, company3));

		// antes de asociar artistas y discográficas a los álbumes, hay que guardarlos! ojo 👁

		Album a1 = new Album(null, "Tubular Bells", "1111VG001", 19.95, true, LocalDate.of(1973, 5, 25), AlbumType.VINYL, artist1, company1);
		albumRepository.save(a1);
		albumRepository.save(new Album(null, "Sons and Fascination", "2222VG002", 23.45, true, LocalDate.of(1981, 9, 15), AlbumType.CD, artist2, company1));
		albumRepository.save(new Album(null, "Mystery Girl", "3333VG003", 16.99, true, LocalDate.of(1989,1,31),AlbumType.VINYL, artist3, company1));
		albumRepository.save(new Album(null, "Master of Puppets", "4444EL004", 19.99, true, LocalDate.of(1986,3,3), AlbumType.CD, artist7, company2));
		albumRepository.save(new Album(null, "A Kind of Magic", "8888EM008", 15.50, true, LocalDate.of(1986,6,2), AlbumType.CD, artist8, company3));

		Rating r1 = new Rating(null, 5, "Great album", a1, null);
		Rating r2 = new Rating(null, 1, "Long and boring album", a1, null);
		Rating r3 = new Rating(null, 3, "Such an original album", a1, null);
		ratingRepository.saveAll(List.of(r1, r2, r3));

		// creo usuarios valiéndome del @Builder de Lombok inyectado solo en 'User.java':
		User u1 = User.builder().email("admin@gmail.com").name("admin1").password("admin1234").role(Role.ADMIN).build();
		User u2 = User.builder().email("user@gmail.com").name("user1").password("user1234").role(Role.USER).build();
		userRepository.saveAll(List.of(u1, u2));


	}
}
