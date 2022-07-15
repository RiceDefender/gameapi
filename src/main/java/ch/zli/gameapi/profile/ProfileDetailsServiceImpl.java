package ch.zli.gameapi.profile;

import static java.util.Collections.emptyList;

import ch.zli.gameapi.profile.Profile;
import ch.zli.gameapi.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProfileDetailsServiceImpl implements UserDetailsService {
    private final ProfileRepository applicationProfileRepository;

    @Autowired
    public ProfileDetailsServiceImpl(ProfileRepository applicationProfileRepository) {
        this.applicationProfileRepository = applicationProfileRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile applicationProfile = applicationProfileRepository.findByUsername(username);
        if (applicationProfile == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationProfile.getUsername(), applicationProfile.getPassword(), emptyList());
    }

    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
     */
}
