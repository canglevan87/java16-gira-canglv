package cybersoft.javabackend.java16giracanglv.user.service;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giracanglv.user.mapper.UserMapper;
import cybersoft.javabackend.java16giracanglv.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public GiraUserDTO createUser(GiraUserDTO dto) {
        GiraUser user = UserMapper.INSTANCE.toModel(dto);
        GiraUser newUser = userRepository.save(user);
        return UserMapper.INSTANCE.toDto(newUser);
    }
}
