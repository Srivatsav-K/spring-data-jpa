package com.example.springjpademo.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
// Tell java where to implement this either class level, field level or
// method level
@Retention(RetentionPolicy.RUNTIME) // Should implement at runtime level
@Constraint(validatedBy = GenderValidator.class)
public @interface ValidateGender {

  public String message() default "Gender must be Male or Female";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
