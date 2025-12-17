package com.example.springjpademo.repository;

import com.example.springjpademo.entites.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}