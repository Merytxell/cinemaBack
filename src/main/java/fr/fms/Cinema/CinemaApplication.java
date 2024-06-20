	package fr.fms.Cinema;

	import fr.fms.Cinema.Entities.*;
	import fr.fms.Cinema.dao.CinemaRepository;
	import fr.fms.Cinema.dao.MovieRepository;
	import fr.fms.Cinema.dao.ShowRepository;
	import fr.fms.Cinema.service.AccountService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;

	import java.util.ArrayList;

	@SpringBootApplication
	public class CinemaApplication implements CommandLineRunner {


		@Autowired
		CinemaRepository cinemaRepository;

		@Autowired
		MovieRepository movieRepository;

		@Autowired
		ShowRepository showRepository;

		@Autowired
		AccountService accountService;

		public static void main(String[] args)  {
			SpringApplication.run(CinemaApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			generateData();
			generateUsersRoles();
		}

		private void generateData() {
			Cinema UGC = cinemaRepository.save(new Cinema(null, "UGC", "Toulouse",null));
			Cinema PATHE = cinemaRepository.save(new Cinema(null, "PATHE", "Toulouse",null));

			Movie Jurassic = movieRepository.save(new Movie(null, "Jurassic park", "jurassic.png", null, UGC ));
			Movie JurassicPathe = movieRepository.save(new Movie(null, "Jurassic park", "jurassic.png", null, PATHE));
			Movie harryPotter =	movieRepository.save(new Movie(null, "Harry Potter", "harry.png", null, PATHE));
			Movie harryPotterUgc =	movieRepository.save(new Movie(null, "Harry Potter", "harry.png", null, UGC));


			ShowTime JurassicPark = showRepository.save(new ShowTime(null, "vendredi 21 juin à 16h00",10, Jurassic));
			ShowTime JurassicPark2 = showRepository.save(new ShowTime(null, "Mardi 18 juin à 16h00",10, Jurassic));
			ShowTime JurassicParkPathe = showRepository.save(new ShowTime(null, "Mercredi 19 juin à 16h00",10, JurassicPathe));

			ShowTime harryP = showRepository.save(new ShowTime(null, "jeudi 20 juin à 16h00",10, harryPotter));
			ShowTime harryPO = showRepository.save(new ShowTime(null, "samedi 22 juin à 16h00",10, harryPotter));
			ShowTime harryPotter2 = showRepository.save(new ShowTime(null, "samedi 22 juin à 16h00",10, harryPotterUgc));


		}

		private void generateUsersRoles(){
			accountService.saveUser(new AppUser(null,"Josette","1234",new ArrayList<>()));
			accountService.saveUser(new AppUser(null,"Patoche","1234",new ArrayList<>()));
			accountService.saveUser(new AppUser(null,"Gege","1234",new ArrayList<>()));
			accountService.saveRole(new AppRole(null,"ADMIN"));
			accountService.saveRole(new AppRole(null,"USER"));
			accountService.addRoleToUser("Josette", "ADMIN");
			accountService.addRoleToUser("Patoche", "USER");
			accountService.addRoleToUser("Gege", "USER");
		}

	}
