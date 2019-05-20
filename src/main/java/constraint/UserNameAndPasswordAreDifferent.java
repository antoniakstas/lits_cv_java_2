package constraint;

import validator.UsernameAndPasswordAreNotTheSameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameAndPasswordAreNotTheSameValidator.class)
public @interface UserNameAndPasswordAreDifferent {
    String message() default "{autoparts.validation.messsage.example}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}