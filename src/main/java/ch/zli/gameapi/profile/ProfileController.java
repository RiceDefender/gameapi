package ch.zli.gameapi.profile;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
	private ProfileRepository profileRepository;




	public ProfileController(ProfileRepository profileRepository) {
		super();
		this.profileRepository = profileRepository;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody Profile profile) {
		profile.setPassword(profile.getPassword());
		profileRepository.save(profile);

	}
	@GetMapping
	public List<Profile> getUsers() {
		return profileRepository.findAll();
	}

}
