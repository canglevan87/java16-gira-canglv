package cybersoft.javabackend.java16giracanglv.role.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;
@Data
public class GiraGroupDTO {
    private UUID id;
    @Size(min = 5, max = 30, message = "Groupcode must be 5 characters")

    private String code;

    @NotBlank(message = "Description is mandatory")


    private String description;
}
