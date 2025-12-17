package com.example.springjpademo.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "departments")
public class Department extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100, unique = true)
  private String name;

  @OneToOne
  @JoinColumn(name = "head_doctor_id", referencedColumnName = "id")
  private Doctor headDoctor;

  /**
   * This would create a join column. Which is essential for many-to-many relationships
   * <p>
   * create table department_doctors (
   * department_id bigint not null,
   * doctor_id bigint not null,
   * primary key (department_id, doctor_id)
   * )
   * <p>
   * alter table if exists department_doctors
   * add constraint FKh5eqea4wr07hp5yibcnii3xyt
   * foreign key (doctor_id)
   * references doctors
   * <p>
   * alter table if exists department_doctors
   * add constraint FK90pi8xgonvqpp1dub6ojehpri
   * foreign key (department_id)
   * references departments
   */
  @ManyToMany // Department Entity is the owning side as it is defined here. Any changes to department doctors should
  // be done via this Entity only
  @JoinTable(
      name = "department_doctors",
      joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id")
  )
  private HashSet<Doctor> doctors = new HashSet<>(); // When hibernate tries to fill doctors, it should not find a
  // null value
}
