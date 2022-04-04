package cybersoft.javabackend.java16giracanglv.user.mapper;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.user.dto.GiraUserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(UserMapper.class);
    GiraUser toModel (GiraUserDTO dto);
    GiraUserDTO toDto (GiraUser model);
}
