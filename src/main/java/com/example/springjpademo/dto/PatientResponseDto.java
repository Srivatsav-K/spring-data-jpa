package com.example.springjpademo.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import com.example.springjpademo.entites.type.BloodGroupType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PatientResponseDto {
  @Builder.Default
  private final String object = "patient";

  Long id;

  String name;

  String email;

  String gender;

  @JsonProperty("birth_date")
  LocalDate birthDate;

  @JsonProperty("created_at")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
  OffsetDateTime createdAt;

  @JsonProperty("updated_at")
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
  OffsetDateTime updatedAt;

  @JsonProperty("blood_group")
  BloodGroupType bloodGroup;
}
