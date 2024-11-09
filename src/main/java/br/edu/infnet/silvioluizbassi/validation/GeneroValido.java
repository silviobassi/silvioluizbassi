package br.edu.infnet.silvioluizbassi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = GeneroValidoValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneroValido {
    String message() default "Gênero inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
