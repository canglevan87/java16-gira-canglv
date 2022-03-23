package cybersoft.javabackend.java16giracanglv.role.service;

import cybersoft.javabackend.java16giracanglv.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giracanglv.role.dto.GiraGroupRoleDTO;
import cybersoft.javabackend.java16giracanglv.role.mapper.GroupMapper;
import cybersoft.javabackend.java16giracanglv.role.mapper.GroupRoleMapper;
import cybersoft.javabackend.java16giracanglv.role.model.GiraGroup;
import cybersoft.javabackend.java16giracanglv.role.model.GiraRole;
import cybersoft.javabackend.java16giracanglv.role.repository.GiraGroupRepository;
import cybersoft.javabackend.java16giracanglv.role.repository.GiraRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GiraGroupServiceImpl implements GiraGroupService {

    @Autowired
    private GiraGroupRepository giraGroupRepository;
    @Autowired
    private GiraRoleRepository giraRoleRepository;
    @Override
    public List<GiraGroupDTO> findAll() {
        List<GiraGroup> giraGroups = giraGroupRepository.findAll();
        List<GiraGroupDTO> giraGroupDTOS = giraGroups.stream()
                .map(t->GroupMapper.INSTANCE.toDto(t)).collect(java.util.stream.Collectors.toList());
        return giraGroupDTOS;
    }

    @Override
    public GiraGroupDTO crateGroup(GiraGroupDTO giraGroupDTO) {
        GiraGroup giraGroup = GroupMapper.INSTANCE.toModel(giraGroupDTO);
        giraGroup = giraGroupRepository.save(giraGroup);
        return GroupMapper.INSTANCE.toDto(giraGroup);
    }

    @Override
    public GiraGroupRoleDTO addRole(String groupId, String roleId) {
        GiraGroup groups;
        GiraRole roles;
        try {
         groups = giraGroupRepository.getById(UUID.fromString(groupId));
         roles = giraRoleRepository.getById(UUID.fromString(roleId));
            } catch (Exception e) {
                        return null;
        }
        groups.addRole(roles);
        GiraGroup modifiedGroup = giraGroupRepository.save(groups);
        GiraGroupRoleDTO dto = GroupRoleMapper.INSTANCE.toDto(modifiedGroup);

        return dto;
    }

    @Override
    public GiraGroupRoleDTO removeRole(String groupId, String roleId) {
        GiraGroup groups;
        GiraRole roles;
        try {
            groups = giraGroupRepository.getById(UUID.fromString(groupId));
            roles = giraRoleRepository.getById(UUID.fromString(roleId));
        } catch (Exception e) {
            return null;
        }
        groups.removeRole(roles);
        GiraGroup modifiedGroup = giraGroupRepository.save(groups);
        GiraGroupRoleDTO dto = GroupRoleMapper.INSTANCE.toDto(modifiedGroup);

        return dto;


    }
}
