package ch.zli.gameapi.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for
 * @author RiceDefender
 * @date 15.07.2022
 *
 */
@RestController
@RequestMapping("/profiles")
public class ProfileController {


	private ProfileRepository profileRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	public ProfileController(ProfileRepository profileRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.profileRepository = profileRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody Profile profile) {
		profile.setPassword(bCryptPasswordEncoder.encode(profile.getPassword()));
		profileRepository.save(profile);

	}
	@GetMapping
	public List<Profile> getUsers() {
		return profileRepository.findAll();
	}

}
