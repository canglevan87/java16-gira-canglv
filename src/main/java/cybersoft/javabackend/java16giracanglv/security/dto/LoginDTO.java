    package cybersoft.javabackend.java16giracanglv.security.dto;

import cybersoft.javabackend.java16giracanglv.security.Validation.ExistedUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
    public class LoginDTO {
    @NotBlank (message = "{login.username.notblank}")
    @Size (min = 3, max = 50, message = "{login.username.size}")
    @ExistedUser(message = "{login.username.existed}")
    private String username;
    @NotBlank (message = "{login.password.notblank}")
    private String password;
}
