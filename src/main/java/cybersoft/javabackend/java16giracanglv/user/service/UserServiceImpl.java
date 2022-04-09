package cybersoft.javabackend.java16giracanglv.user.service;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giracanglv.user.mapper.UserMapper;
import cybersoft.javabackend.java16giracanglv.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public GiraUserDTO createUser(GiraUserDTO dto) {
        GiraUser user = UserMapper.INSTANCE.toModel(dto);
        //encode password
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        GiraUser newUser = userRepository.save(user);
        newUser.setPassword(null);
        return UserMapper.INSTANCE.toDto(newUser);
    }
}
