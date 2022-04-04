package cybersoft.javabackend.java16giracanglv.user.service;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.user.dto.GiraUserDTO;

public interface UserService {
    GiraUserDTO createUser(GiraUserDTO dto);
}
