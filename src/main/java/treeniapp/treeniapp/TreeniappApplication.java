package treeniapp.treeniapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import treeniapp.treeniapp.model.AppUser;
import treeniapp.treeniapp.model.AppUserRepository;
import treeniapp.treeniapp.model.Treeni;
import treeniapp.treeniapp.model.TreeniRepository;
import treeniapp.treeniapp.model.Treenityyppi;
import treeniapp.treeniapp.model.TreenityyppiRepository;

@SpringBootApplication
public class TreeniappApplication {

	private static final Logger log = LoggerFactory.getLogger(TreeniappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TreeniappApplication.class, args);
	}

	@Bean
	public CommandLineRunner treenitCLR(TreeniRepository repository, TreenityyppiRepository trepository, AppUserRepository urepository) {
		return (args) -> {
			log.info("Tallennetaan muutama esimerkkitreeni ja treenityyppejä");

			Treenityyppi tt1 = new Treenityyppi("Kuntosali");
			Treenityyppi tt2 = new Treenityyppi("Pyöräily");
			Treenityyppi tt3 = new Treenityyppi("Juoksu");
			Treenityyppi tt4 = new Treenityyppi("Kävely");

			trepository.save(tt1);
			trepository.save(tt2);
			trepository.save(tt3);
			trepository.save(tt4);

			repository.save(new Treeni(tt1, "45 min", "2024-04-20", "Kyykky 5x5 80kg"));
			repository.save(new Treeni(tt2, "50 min", "2024-04-21", "Seurasaari"));
			repository.save(new Treeni(tt3, "55 min", "2024-04-22", "Töölönlahti"));
			repository.save(new Treeni(tt4, "60 min", "2024-04-23", "Munkkiniemi"));

			AppUser user1 = new AppUser("user", "$2a$10$/9cTAHpoedkTQzDHRSXxOu0e6qyf/OoFeuTwj14nXHup2v.XnNNUq", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$kRPO5iAA.ufmQAmOx7vDsOVP/lASS7ulalP1dhw5pq739QfA1tYza", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("Haetaan kaikki treenit");
			for (Treeni treeni : repository.findAll()) {
				log.info(treeni.toString());
			}

		};

	}
}
