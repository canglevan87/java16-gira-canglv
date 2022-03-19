package cybersoft.javabackend.java16giracanglv.role.service;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class GiraRoleDTO {
   @Size(min = 5, max = 5, message = "Rolecode must be 5 characters")

    private String code;

   @NotBlank(message = "Description is mandatory")


    private String description;
}
