package com.example.springjpademo.mapper;

import com.example.springjpademo.dto.PatientRequestDto;
import com.example.springjpademo.dto.PatientResponseDto;
import com.example.springjpademo.entites.Patient;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PatientMapper {
  public static PatientResponseDto toPatientResponseDto(Patient patient) {
    return PatientResponseDto.builder()
        .id(patient.getId())
        .name(patient.getName())
        .email(patient.getEmail())
        .gender(patient.getGender())
        .birthDate(patient.getBirthDate())
        .bloodGroup(patient.getBloodGroup())
        .createdAt(toOffsetDateTime(patient.getCreatedAt()))
        .updatedAt(toOffsetDateTime(patient.getUpdatedAt()))
        .build();
  }

  public static Patient toPatient(PatientRequestDto patientRequestDto) {
    Patient patient = new Patient();
    patient.setName(patientRequestDto.getName());
    patient.setEmail(patientRequestDto.getEmail());
    patient.setGender(patientRequestDto.getGender());
    patient.setBloodGroup(patientRequestDto.getBloodGroup());
    patient.setBirthDate(patientRequestDto.getBirthDate());

    return patient;
  }

  public static OffsetDateTime toOffsetDateTime(ZonedDateTime time) {
    // Convert to system default timezone to get proper offset format
    return time.withZoneSameInstant(ZoneId.systemDefault()).toOffsetDateTime();
  }
}
