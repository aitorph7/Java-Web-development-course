package com.certidevs;

import com.certidevs.model.Album;
import com.certidevs.model.Artist;
import com.certidevs.model.RecordCompany;
import com.certidevs.repository.AlbumRepository;
import com.certidevs.repository.ArtistRepository;
import com.certidevs.repository.RecordCompanyRepository;
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

		/*
		1º borro los libros porque tienen asociaciones hacia artistas y discográficas.
		Si borro 1º un artista o disquera dará error al haber álbumes apuntando a ellos.
		*/
		albumRepository.deleteAll();
		recordCompanyRepository.deleteAll(); // Borro los datos que haya para que se generen nuevos datos.
		artistRepository.deleteAll();

		Artist artist1 = new Artist(null, "Mike Oldfield", "England", false, LocalDate.of(1967, 1, 1), "http://placehold.co/400", "Texto largo de leer");
		Artist artist2 = new Artist(null, "Simple Minds", "Scotland", true, LocalDate.of(1977, 1,1),"http://placehold.co/400", "Texto largo de leer");
		Artist artist3 = new Artist(null, "Roy Orbison", "USA", false, LocalDate.of(1953, 1, 1),"http://placehold.co/400", "Texto largo de leer");
		Artist artist4 = new Artist(null, "Alice in Chains", "USA", true, LocalDate.of(1987, 1, 1),"http://placehold.co/400", "Texto largo de leer");
		Artist artist5 = new Artist(null, "Depeche Mode", "England", true, LocalDate.of(1980, 1, 1),"http://placehold.co/400", "Texto largo de leer");
		Artist artist6 = new Artist(null, "Manowar", "USA", true, LocalDate.of(1980, 1, 1),"http://placehold.co/400", "Texto largo de leer");
		Artist artist7 = new Artist(null, "Metallica", "USA", true, LocalDate.of(1981, 1, 1),"http://placehold.co/400", "Texto largo de leer");
		Artist artist8 = new Artist(null, "Queen", "England", true, LocalDate.of(1970, 1, 1),"http://placehold.co/400", "Texto largo de leer");
		artistRepository.saveAll(List.of(artist1, artist2, artist3, artist4, artist5, artist6, artist7, artist8));

		RecordCompany company1 = new RecordCompany(null, "Virgin Records", "https://www.efeeme.com/wp-content/uploads/virgin-23-0-13.jpg", 1972, "long description");
		RecordCompany company2 = new RecordCompany(null, "Elektra Records", "https://www.efeeme.com/wp-content/uploads/Elektra-06-09.jpg", 1950, "long description");
		RecordCompany company3 = new RecordCompany(null, "EMI", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/EMI_logo.svg/1200px-EMI_logo.svg.png", 1931, "long description");
		recordCompanyRepository.saveAll(List.of(company1, company2, company3));

		// antes de asociar autores y discográficas hay que guardarlos! ojo 👁

		albumRepository.save(new Album(null, "Tubular Bells", "1111VG001", 19.95, true, LocalDate.of(1973, 5, 25), artist1, company1));
		albumRepository.save(new Album(null, "Sons and Fascination", "2222VG002", 23.45, true, LocalDate.of(1981, 9, 15), artist2, company1));
		albumRepository.save(new Album(null, "Mystery Girl", "3333VG003", 16.99, true, LocalDate.of(1989,1,31), artist3, company1));
		albumRepository.save(new Album(null, "Master of Puppets", "4444EL004", 19.99, true, LocalDate.of(1986,3,3), artist7, company2));
		albumRepository.save(new Album(null, "A Kind of Magic", "8888EM008", 15.50, true, LocalDate.of(1986,6,2), artist8, company3));

	}

}
