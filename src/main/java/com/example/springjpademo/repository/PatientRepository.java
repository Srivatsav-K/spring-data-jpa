package com.example.springjpademo.repository;

import com.example.springjpademo.entites.Patient;
import com.example.springjpademo.entites.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {


  // JPA query method : if we provide Optional as return type. Optional will be returned
  // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
  Optional<Patient> findByName(String name);

  // If we give String for birthDate it will throw error on startup as the types don't match
  Patient findByBirthDate(LocalDate birthDate);

  // Checks by executing WHERE p.birth_data=? OR p.email=?. So multiple results might come if birthDate of one person
  // and email of another person is passed. Therefore instead of returning Patient type we should return
  // List<Patient>. Else we get this error : Query did not return a unique result: 2 results were returned
  List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

  List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

  List<Patient> findByNameContainingOrderByCreatedAtDesc(String query);

  // JPQL : Jakarta persistence query language
  // Here we need to use JPA Entity name and not DB table name as in case of raw SQL query
  // Use aliases such as p instead of *
  @Query("SELECT p FROM Patient p WHERE p.bloodGroup = ?1")
  List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

  @Query("SELECT p FROM Patient p WHERE p.birthDate > :birthDate")
  List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

  @Query("SELECT p.bloodGroup, Count(p) from Patient p GROUP BY p.bloodGroup ORDER BY Count(p) DESC")
  List<Object[]> fetchAllBloodGroupTypeCount();

  @Modifying // We need to set this explicitly as this informs JPL that it is supposed to update the db as some
  // transactions need to applied internally. The method where this will be used should be marked as @Transactional
  // else we will get InvalidDataAccessApiUsageException
  @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
  @Transactional
    // NOTE : Do not apply here. Apply in service layer but since we are using this in test and
    // Transaction will get rolled back there this is a temp fix
  int updatePatientNameById(@Param("name") String name, @Param("id") Long id);

  // RAW SQL
  @Query(value = "SELECT * FROM patients ORDER BY created_at DESC", nativeQuery = true)
  List<Patient> findAllPatients();
}
