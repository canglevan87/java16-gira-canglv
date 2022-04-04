package cybersoft.javabackend.java16giracanglv.user.Validation.validator;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.user.Validation.annotation.UniqueEmail;
import cybersoft.javabackend.java16giracanglv.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    String message;
    @Autowired
    UserRepository userRepository;
    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

        message =  constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Optional<GiraUser> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation().disableDefaultConstraintViolation();

        return false;
    }
}
