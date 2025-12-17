package com.example.springjpademo.repository;

import com.example.springjpademo.entites.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}