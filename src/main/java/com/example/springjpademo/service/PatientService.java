package com.example.springjpademo.service;

import com.example.springjpademo.entites.Patient;
import com.example.springjpademo.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
  private final PatientRepository patientRepository; // needs to be marked with final for RequiredArgsConstructor to
  // inject

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
}
