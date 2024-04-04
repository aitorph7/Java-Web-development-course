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

		Todos estos datos en un futuro los reemplazaré con datos creados en un archivo
		DATA.SQL; algo bastante habitual en este tipo de aplicaciones, que sea un script
		de SQL quien inserte los datos.
		 */
		AlbumRepository albumRepository = context.getBean(AlbumRepository.class);
		ArtistRepository artistRepository = context.getBean(ArtistRepository.class);
		RecordCompanyRepository recordCompanyRepository = context.getBean(RecordCompanyRepository.class);
		RatingRepository ratingRepository = context.getBean(RatingRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);

		/*
		1º borro los álbumes porque tienen asociaciones hacia artistas y discográficas.
		Si borro 1º un artista o disquera dará error al haber álbumes apuntando a ellos.
		*/
		ratingRepository.deleteAll();
		albumRepository.deleteAll(); // Borro los datos que haya para que se generen nuevos datos.
		recordCompanyRepository.deleteAll();
		artistRepository.deleteAll();
		userRepository.deleteAll();

		Artist artist1 = new Artist(null, "Mike Oldfield", "England", false, LocalDate.of(1967, 1, 1), "https://cdn.galleries.smcloud.net/t/galleries/gf-7DRQ-y1Y3-nHpu_mike-oldfield-swietuje-50-lecie-tubular-bells-994x828.jpg", "Texto largo de leer");
		Artist artist2 = new Artist(null, "Simple Minds", "Scotland", true, LocalDate.of(1977, 1,1),"https://i.guim.co.uk/img/media/b37b81eafad5508816f3a6fcf9acd8594a4d411a/0_496_7543_4526/master/7543.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=1f2460f92ab0d54f51c91fe79a45e899", "Texto largo de leer");
		Artist artist3 = new Artist(null, "Roy Orbison", "USA", false, LocalDate.of(1953, 1, 1),"https://placehold.co/400", "Texto largo de leer");
		Artist artist4 = new Artist(null, "Alice in Chains", "USA", true, LocalDate.of(1987, 1, 1),"https://www.musicmaniarecords.be/media/artist-photo/139572-alice-in-chains-band-pic.jpg", "Texto largo de leer");
		Artist artist5 = new Artist(null, "Depeche Mode", "England", true, LocalDate.of(1980, 1, 1),"https://www.bremeneins.de/bilder/imago-6390~_v-1600x1600_c-1675325322983.jpg", "Texto largo de leer");
		Artist artist6 = new Artist(null, "Manowar", "USA", true, LocalDate.of(1980, 1, 1),"https://c02.purpledshub.com/uploads/sites/16/2022/09/1950808_65310b9aab.jpg", "Texto largo de leer");
		Artist artist7 = new Artist(null, "Metallica", "USA", true, LocalDate.of(1981, 1, 1),"https://i.pinimg.com/736x/62/cd/4f/62cd4fce70c7a84b0574cadc7965a3a5.jpg", "Texto largo de leer");
		Artist artist8 = new Artist(null, "Queen", "England", true, LocalDate.of(1970, 1, 1),"https://www.queenonline.com/global/uploads/24.jpg", "Texto largo de leer");
		artistRepository.saveAll(List.of(artist1, artist2, artist3, artist4, artist5, artist6, artist7, artist8));

		RecordCompany company1 = new RecordCompany(null, "Virgin Records", "https://www.efeeme.com/wp-content/uploads/virgin-23-0-13.jpg", 1972, "long description");
		RecordCompany company2 = new RecordCompany(null, "Elektra Records", "https://www.efeeme.com/wp-content/uploads/Elektra-06-09.jpg", 1950, "long description");
		RecordCompany company3 = new RecordCompany(null, "EMI", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/EMI_logo.svg/1200px-EMI_logo.svg.png", 1931, "long description");
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
