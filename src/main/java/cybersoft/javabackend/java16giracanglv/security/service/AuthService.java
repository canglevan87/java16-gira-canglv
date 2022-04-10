package cybersoft.javabackend.java16giracanglv.security.service;

import cybersoft.javabackend.java16giracanglv.security.dto.LoginDTO;

public interface AuthService {
    String login(LoginDTO loginDTO);
}
