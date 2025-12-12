package com.example.springjpademo.dto;

import com.example.springjpademo.entites.type.BloodGroupType;
import com.example.springjpademo.validators.ValidateGender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PatientRequestDto {
  @NotBlank(message = "Patient name can't be blank")
  @Size(min = 3, max = 125, message = "Patient name must be between 3 and 125 characters")
  String name;

  @NotBlank
  @Email(message = "Email must be a valid email address")
  String email;

  @NotBlank
  @ValidateGender() // Custom validation
  String gender;

  @Past(message = "Birth date must be in the past")
  @NotNull(message = "Birth date is required")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JsonProperty("birth_date")
  LocalDate birthDate;

  @NotNull
  @JsonProperty("blood_group")
  BloodGroupType bloodGroup;
}
