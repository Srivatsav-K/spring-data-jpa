package com.example.springjpademo;

import com.example.springjpademo.entites.Patient;
import com.example.springjpademo.entites.type.BloodGroupType;
import com.example.springjpademo.repository.PatientRepository;
import com.example.springjpademo.service.PatientService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PatientTests {
  @Autowired
  PatientRepository patientRepository;

  @Autowired
  PatientService patientService;


  @Test
  void testFetchAllPatients() {
    List<Patient> patients = patientRepository.findAll();

    System.out.println(patients);
  }

  @Test
  void testCreatePatient() {
    Patient p1 = new Patient();
    p1.setName("Peter");
    p1.setEmail("peter@gmail.com");
    p1.setBirthDate(LocalDate.parse("1995-02-12"));
    p1.setGender("male");

    Patient savedPatient = patientRepository.save(p1);

    System.out.println(savedPatient);
  }


  @Test
  void testTransactionMethods() {
    Patient patient = patientService.getPatientById(1L); // 2 db calls will be made if the method is not @Transactional

    System.out.println(patient);
  }

  @Test
  void testFindByName() {
    Optional<Patient> patient = patientRepository.findByName("Alice Johnson");

    System.out.println(patient.orElseThrow());
  }

  @Test
  void testFindByBirthDate() {
    Patient patient = patientRepository.findByBirthDate(LocalDate.of(1993, 4, 12));

    System.out.println(patient);
  }

  @Test
  void testFindByBirthDateOrEmail() {
    List<Patient> patients = patientRepository.findByBirthDateOrEmail(
        LocalDate.of(1993, 4, 12),
        "christopher.hernandez@example.com"
    );

    for (Patient patient : patients) {
      System.out.println(patient);
    }
  }

  @Test
  void testFindByNameContaining() {
    List<Patient> patients = patientRepository.findByNameContainingOrderByCreatedAtDesc("Je");

    for (Patient patient : patients) {
      System.out.println(patient);
    }
  }

  @Test
  void testFindByBloodGroup() {
    List<Patient> patients = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

    for (Patient patient : patients) {
      System.out.println(patient);
    }
  }

  @Test
  void testFindByBornAfterDate() {
    List<Patient> patients = patientRepository.findByBornAfterDate(LocalDate.of(2000, 1, 1));

    for (Patient patient : patients) {
      System.out.println(patient);
    }
  }

  @Test
  void testFetchAllBloodGroupTypeCount() {
    List<Object[]> patients = patientRepository.fetchAllBloodGroupTypeCount();

    System.out.println(patients);

    for (Object[] patient : patients) {
      System.out.println(patient);
      System.out.println(patient[0] + " " + patient[1]);
    }
  }

  @Test
  void testFetchAllpatientsRawQuery() {
    List<Patient> patients = patientRepository.findAllPatients();

    for (Patient patient : patients) {
      System.out.println(patient);
    }
  }

  @Test
  void testUpdatePatientNameById() {
    int affectedRows = patientRepository.updatePatientNameById("Krish", 12L);

    System.out.println("Affected rows : " + affectedRows);
  }
}
