package br.edu.infnet.silvioluizbassi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NivelBootcampValidoValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NivelBootcampValido {
    String message() default "Invalid bootcamp level";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
