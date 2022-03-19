package cybersoft.javabackend.java16giracanglv.role.service;

import cybersoft.javabackend.java16giracanglv.role.model.GiraRole;

import java.util.List;

public interface GiraRoleService {

    List<GiraRole> FindAll();
    GiraRoleDTO save(GiraRoleDTO giraRoleDTO);

}
