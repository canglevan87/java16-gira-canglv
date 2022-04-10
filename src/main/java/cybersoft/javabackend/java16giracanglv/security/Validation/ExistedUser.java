package cybersoft.javabackend.java16giracanglv.security.Validation;

import cybersoft.javabackend.java16giracanglv.user.Validation.validator.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistedUserValidator.class)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ExistedUser {
    String message() default "User with this name already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
