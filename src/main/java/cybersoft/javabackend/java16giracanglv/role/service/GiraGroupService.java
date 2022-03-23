package cybersoft.javabackend.java16giracanglv.role.service;

import cybersoft.javabackend.java16giracanglv.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giracanglv.role.dto.GiraGroupRoleDTO;
import cybersoft.javabackend.java16giracanglv.role.model.GiraGroup;

import java.util.List;
import java.util.UUID;

public interface GiraGroupService {
    List<GiraGroupDTO> findAll();
    GiraGroupDTO crateGroup(GiraGroupDTO giraGroupDTO);

    GiraGroupRoleDTO addRole(String groupId, String roleId);

    GiraGroupRoleDTO removeRole(String groupId, String roleId);
}
