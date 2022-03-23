package cybersoft.javabackend.java16giracanglv.role.mapper;

import cybersoft.javabackend.java16giracanglv.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giracanglv.role.model.GiraGroup;
import org.mapstruct.Mapper;

@Mapper
public interface GroupMapper  {
    GroupMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(GroupMapper.class);
    GiraGroupDTO toDto(GiraGroup model);
    GiraGroup toModel(GiraGroupDTO dto);
}
