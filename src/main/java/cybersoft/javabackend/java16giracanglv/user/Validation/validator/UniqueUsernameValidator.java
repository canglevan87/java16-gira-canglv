package cybersoft.javabackend.java16giracanglv.user.Validation.validator;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.user.Validation.annotation.UniqueUsername;
import cybersoft.javabackend.java16giracanglv.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private String message;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        Optional<GiraUser> usernameOpt = userRepository.findByUsername(username);
        if (usernameOpt.isEmpty()) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation().disableDefaultConstraintViolation();

        return false;
    }
}