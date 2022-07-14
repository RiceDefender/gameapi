package ch.zli.gameapi.profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	Profile findByUsername(String username);

}
