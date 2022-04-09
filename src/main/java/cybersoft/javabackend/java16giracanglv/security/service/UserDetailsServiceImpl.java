package cybersoft.javabackend.java16giracanglv.security.service;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giracanglv.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<GiraUser> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            return null;
        }

        GiraUser currUser = user.get();




        return new User(currUser.getUsername(), currUser.getPassword(), getAuthorities(currUser));
    }
    public List<GrantedAuthority> getAuthorities(GiraUser user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        user.getGroups().forEach(group -> new SimpleGrantedAuthority(group.getCode()));

        return authorities;
    }
}
