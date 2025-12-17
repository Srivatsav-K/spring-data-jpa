package com.example.springjpademo.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "doctors")
public class Doctor extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, length = 100)
  private String specialisation;

  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @OneToMany(mappedBy = "doctor") // inverse side
  private List<Appointment> appointments = new ArrayList<>();

  @ManyToMany(mappedBy = "doctors") // inverse side
  private Set<Department> departments = new HashSet<>();
}
