package com.example.springjpademo;

import com.example.springjpademo.dto.InsuranceRequestDto;
import com.example.springjpademo.entites.Insurance;
import com.example.springjpademo.entites.Patient;
import com.example.springjpademo.repository.InsuranceRepository;
import com.example.springjpademo.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class InsuranceTests {

  @Autowired
  InsuranceRepository insuranceRepository;

  @Autowired
  PatientService patientService;

  @Test
  void createInsurance() {
    Insurance insurance = Insurance.builder()
        .policyNumber("ASD123ASD")
        .provider("Star")
        .validUntil(LocalDate.now().plusYears(1))
        .build();

    Insurance savedInsurance = insuranceRepository.save(insurance);

    System.out.println(savedInsurance);

  }

  @Test
  void createInsuranceAndTagToPatient() {
    InsuranceRequestDto insurance = InsuranceRequestDto.builder()
        .policyNumber("CSD123ASD")
        .provider("Star")
        .validUntil(LocalDate.now().plusYears(1))
        .patientId(2L)
        .build();

    Patient savedPatient = patientService.createInsuranceAndTagToPatient(insurance);

    System.out.println(savedPatient);

  }


}
