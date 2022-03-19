package cybersoft.javabackend.java16giracanglv.role.mapper;

import cybersoft.javabackend.java16giracanglv.role.model.GiraRole;
import cybersoft.javabackend.java16giracanglv.role.service.GiraRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    GiraRole mapDtoEntity(GiraRoleDTO dto);
}
