package co.com.jorge.springboot.form.app.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.matches("[0-9]{2}[.,][0-9]{3}[.,][0-9]{3}-[A-Z]");
    }
}
