	package fr.fms.Cinema;

	import fr.fms.Cinema.Entities.Cinema;
	import fr.fms.Cinema.Entities.Movie;
	import fr.fms.Cinema.Entities.ShowTime;
	import fr.fms.Cinema.dao.CinemaRepository;
	import fr.fms.Cinema.dao.MovieRepository;
	import fr.fms.Cinema.dao.ShowRepository;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;

	import java.time.LocalDateTime;

	@SpringBootApplication
	public class CinemaApplication implements CommandLineRunner {


		@Autowired
		CinemaRepository cinemaRepository;

		@Autowired
		MovieRepository movieRepository;

		@Autowired
		ShowRepository showRepository;

		public static void main(String[] args)  {
			SpringApplication.run(CinemaApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			//generateData();
		}

		private void generateData() {
			Cinema UGC = cinemaRepository.save(new Cinema(null, "UGC", "Toulouse",null));
			Cinema PATHE = cinemaRepository.save(new Cinema(null, "PATHE", "Toulouse",null));

			Movie Jurassic = movieRepository.save(new Movie(null, "Jurassic park", null, UGC));
			Movie harryPotter =	movieRepository.save(new Movie(null, "Harry Potter", null, PATHE));

			ShowTime JurassicPark = showRepository.save(new ShowTime(null, "vendredi 7 juin à 16h00",10, Jurassic));
			ShowTime harryP = showRepository.save(new ShowTime(null, "vendredi 14 juin à 16h00",10, harryPotter));




		}

	}
