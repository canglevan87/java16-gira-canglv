package cybersoft.javabackend.java16giracanglv.common;

import cybersoft.javabackend.java16giracanglv.role.model.GiraRole;
import cybersoft.javabackend.java16giracanglv.role.service.GiraRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaseMapper {
    BaseMapper INSTANCE = Mappers.getMapper(BaseMapper.class);
    GiraRole maptoEntity(GiraRoleDTO dto);
}
