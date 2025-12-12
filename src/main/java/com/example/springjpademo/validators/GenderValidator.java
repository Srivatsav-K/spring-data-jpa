package com.example.springjpademo.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

// First generic arg : Which annotation will use this class
// Second generic arg : Type of the field that we are going to implement the validation for
public class GenderValidator implements ConstraintValidator<ValidateGender, String> {
  private final List<String> allowedGenders = List.of("Male", "Female");

  @Override
  public boolean isValid(String gender, ConstraintValidatorContext context) {
    // If false throws error
    // 1. Handle null or empty string: If it's optional, return true here.
    //    If it's required, you should use @NotBlank alongside @ValidGender.
    if (gender == null || gender.isBlank()) {
      // isEmpty() -> .length() == 0
      // isBlank() -> trim().isEmpty()
      return true;
    }

    return allowedGenders.contains(gender);
  }
}
