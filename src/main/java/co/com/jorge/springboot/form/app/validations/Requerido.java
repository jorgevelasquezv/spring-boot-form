package co.com.jorge.springboot.form.app.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = RequeridoValidador.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface Requerido {
    String message() default "El campo es requerido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
