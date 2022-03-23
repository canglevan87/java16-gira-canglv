package cybersoft.javabackend.java16giracanglv.role.mapper;

import cybersoft.javabackend.java16giracanglv.role.dto.GiraGroupRoleDTO;
import cybersoft.javabackend.java16giracanglv.role.model.GiraGroup;
import org.mapstruct.Mapper;

@Mapper
public interface GroupRoleMapper {
    GroupRoleMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(GroupRoleMapper.class);

    GiraGroupRoleDTO toDto(GiraGroup model);


}
