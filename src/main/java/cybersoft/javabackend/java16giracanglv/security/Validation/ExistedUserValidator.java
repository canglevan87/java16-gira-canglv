package cybersoft.javabackend.java16giracanglv.security.Validation;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.security.dto.LoginDTO;
import cybersoft.javabackend.java16giracanglv.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import java.util.Optional;

public class ExistedUserValidator implements ConstraintValidator<ExistedUser, String> {
    String message;
    @Autowired
    UserRepository userRepository;
    @Override
    public void initialize(ExistedUser existedUser) {
         message = existedUser.message();

    }
    @Override
    public boolean isValid(String username, javax.validation.ConstraintValidatorContext constraintValidatorContext) {
        Optional<GiraUser> user = userRepository.findByUsername(username);
        if (user.isPresent())
            return true;
        constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation().disableDefaultConstraintViolation();
        return false;
    }

}
