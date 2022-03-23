package cybersoft.javabackend.java16giracanglv.role.dto;

import cybersoft.javabackend.java16giracanglv.role.service.GiraRoleDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;
@Data
@NoArgsConstructor
public class GiraGroupRoleDTO {
    private UUID id;
    private String code;
    private String description;
    Set<GiraRoleDTO> roles;
}
