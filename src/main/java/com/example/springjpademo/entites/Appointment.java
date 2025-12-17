package com.example.springjpademo.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "appointments")
public class Appointment extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime appointmentTime;

  @Column(length = 500)
  private String reason;

  @ManyToOne
  @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
  private Patient patient;
}
