package com.example.springjpademo.controllers;

import com.example.springjpademo.dto.PatientRequestDto;
import com.example.springjpademo.dto.PatientResponseDto;
import com.example.springjpademo.entites.Patient;
import com.example.springjpademo.mapper.PatientMapper;
import com.example.springjpademo.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
  private final PatientService patientService;


  @GetMapping("/{id}")
  public ResponseEntity<PatientResponseDto> fetchPatientById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(PatientMapper.toPatientResponseDto(patientService.getPatientById(id)), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<PatientResponseDto> createPatient(@RequestBody @Valid PatientRequestDto patientRequestDto) {
    Patient patient = patientService.createPatient(PatientMapper.toPatient(patientRequestDto));
    return ResponseEntity.ok(PatientMapper.toPatientResponseDto(patient));
  }
}