package ch.zli.gameapi;

import ch.zli.gameapi.account.Account;
import ch.zli.gameapi.account.AccountRepository;
import ch.zli.gameapi.character.Character;
import ch.zli.gameapi.character.CharacterClass;
import ch.zli.gameapi.character.CharacterRepository;
import ch.zli.gameapi.profile.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.zli.gameapi.profile.Profile;

@SpringBootApplication
public class GameapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameapiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProfileRepository profileRepository, AccountRepository accountRepository,
								  CharacterRepository characterRepository) {
		return (args) -> {

			profileRepository.save(new Profile("profile", "123"));
			accountRepository.save(new Account("account0@acc.ac", "acc0"));
			characterRepository.save(new Character("Mudrock", CharacterClass.DEFENDER));
		};
	}

}
