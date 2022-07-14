package ch.zli.gameapi;

import ch.zli.gameapi.user.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.zli.gameapi.user.ProfileRepository;
import ch.zli.gameapi.user.Profile;
import ch.zli.gameapi.user.ProfileController;

@SpringBootApplication
public class GameapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameapiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProfileRepository profileRepository) {
		return (args) -> {

			profileRepository.save(new Profile("user", "123"));
		};
	}

}
