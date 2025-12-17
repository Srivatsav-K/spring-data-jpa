package com.example.springjpademo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InsuranceRequestDto {
  @JsonProperty("policy_number")
  @NotBlank
  @Size(min = 3, max = 50)
  private String policyNumber;

  @NotBlank
  @Size(min = 3, max = 100)
  private String provider;

  @JsonProperty("valid_until")
  @NotBlank
  @FutureOrPresent
  private LocalDate validUntil;

  @JsonProperty("patient_id")
  @NotBlank
  private Long patientId;
}
