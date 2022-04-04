package cybersoft.javabackend.java16giracanglv.user.dto;

import cybersoft.javabackend.java16giracanglv.role.model.UserStatus;
import cybersoft.javabackend.java16giracanglv.user.Validation.annotation.UniqueEmail;
import cybersoft.javabackend.java16giracanglv.user.Validation.annotation.UniqueUsername;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
@Data
@NoArgsConstructor
public class GiraUserDTO {
    @Size(min = 5, max = 50,message = "{user.name.size}")
    @UniqueUsername(message = "{user.username.existed}")
    private String username;
    private String password;
    private String displayName;
//    @Size(min = 5, max = 150,message = "{user.email.size}")
    @UniqueEmail(message = "{user.email.existed}")
    private String email;
    private UserStatus status;

}
