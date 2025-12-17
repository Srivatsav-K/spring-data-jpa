package com.example.springjpademo.service;

import com.example.springjpademo.dto.InsuranceRequestDto;
import com.example.springjpademo.entites.Insurance;
import com.example.springjpademo.entites.Patient;
import com.example.springjpademo.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
  private final PatientRepository patientRepository; // needs to be marked with final for RequiredArgsConstructor to
  // inject

  private final ModelMapper modelMapper;

  @Transactional // only 1 db call will be made as the second fetch call fetches data from PersistenceContext
  public Patient getPatientById(Long id) {
    Patient p1 = patientRepository.findById(id).orElseThrow(); // if not present : NoSuchElementException: No value
    // present

    Patient p2 = patientRepository.findById(id).orElseThrow();

    System.out.println("is same object by reference : " + p1.equals(p2)); // will be true if @Transactional is applied

    // p1.setName("John poe");// If you change some properties when it is in a @Transactional method then since it is in
    // PersistenceContext, it will be dirty checked during the commit phase and runs an update query on db if
    // anything is modified without us updating or saving explicitly

    return p1;
  }

  public Patient createPatient(Patient patient) {
    return patientRepository.save(patient);
  }

  @Transactional
  public Patient createInsuranceAndTagToPatient(InsuranceRequestDto insuranceRequestDto) {
    Patient patient = patientRepository.findById(insuranceRequestDto.getPatientId()).orElseThrow(() -> new RuntimeException("patient not found"));

    Insurance insurance = modelMapper.map(insuranceRequestDto, Insurance.class);

    // CRITICAL: Prevent ModelMapper's accidental ID mapping (insuranceId -> Insurance.id)
    insurance.setId(null);

    patient.setInsurance(insurance); // patient is dirtied. So insurance will be created automatically at the end of
    // this transaction

    // Set the patient on the insurance (updates the object only in memory not db)
    insurance.setPatient(patient);


    // If we have CascadeType.ALL or PERSIST on Patient.insurance,
    // saving the patient will automatically save the insurance.
    return patientRepository.save(patient);
  }
}
