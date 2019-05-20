package validator;

import constraint.UserNameAndPasswordAreDifferent;
import model.UserRegistrationRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameAndPasswordAreNotTheSameValidator
        implements ConstraintValidator<UserNameAndPasswordAreDifferent, UserRegistrationRequest> {


    public UsernameAndPasswordAreNotTheSameValidator() {
    }

    public void initialize(UserNameAndPasswordAreDifferent constraint) {
    }

    public boolean isValid(UserRegistrationRequest request, ConstraintValidatorContext context) {
        System.out.println(request.getUsername());
        System.out.println(request.getPassword());
        context.getDefaultConstraintMessageTemplate();
        return !request.getUsername().equals(request.getPassword());
    }

}