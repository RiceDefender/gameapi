package ch.zli.gameapi;

import ch.zli.gameapi.account.Account;
import ch.zli.gameapi.account.AccountRepository;
import ch.zli.gameapi.character.Character;
import ch.zli.gameapi.character.CharacterClass;
import ch.zli.gameapi.character.CharacterRepository;
import ch.zli.gameapi.phone.Phone;
import ch.zli.gameapi.phone.PhoneOS;
import ch.zli.gameapi.phone.PhoneRepository;
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
								  CharacterRepository characterRepository, PhoneRepository phoneRepository) {
		return (args) -> {
			Profile p = new Profile("profile", "123");
			Account a = new Account("account0@acc.ac", "acc0");
			profileRepository.save(p);
			accountRepository.save(a);
			characterRepository.save(new Character("Mudrock", CharacterClass.DEFENDER));
			phoneRepository.save(new Phone("Gulugulu", PhoneOS.ANDROID, a ) );
		};
	}

}
