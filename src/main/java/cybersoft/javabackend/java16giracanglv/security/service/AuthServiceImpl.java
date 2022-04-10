package cybersoft.javabackend.java16giracanglv.security.service;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.security.dto.LoginDTO;
import cybersoft.javabackend.java16giracanglv.security.jwt.JwtHelper;
import cybersoft.javabackend.java16giracanglv.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configurers.UrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public String login(LoginDTO loginDTO) {
        //get user from database
        Optional<GiraUser> user = userRepository.findByUsername(loginDTO.getUsername());
        //check password
        String encodedPassword = user.get().getPassword();
        if (passwordEncoder.matches(loginDTO.getPassword(), encodedPassword)) {
        return jwtHelper.generateJwtToken(loginDTO.getUsername());
        }

        return null;
    }
}
