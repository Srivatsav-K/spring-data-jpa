package com.example.springjpademo.repository;

import com.example.springjpademo.entites.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}