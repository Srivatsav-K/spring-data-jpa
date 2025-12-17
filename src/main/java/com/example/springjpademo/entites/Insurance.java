package com.example.springjpademo.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@ToString
@Table(name = "insurances")
public class Insurance extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 50)
  private String policyNumber;

  @Column(nullable = false, length = 100)
  private String provider;

  @Column(nullable = false)
  private LocalDate validUntil;

  /**
   * Inverse side.
   * Use mappedBy when bidirectional query is needed without creating 2 diff foreign keys in 2 tables.
   * It solves the problem of redundant data and database conflicts.
   * Without it, JPA/Hibernate wouldn't know which side is responsible for updating the foreign key, and it might try
   * to create two foreign key columns (one in each table for a one-to-one relationship), which is incorrect for this type of mapping.
   * In short, mappedBy ensures the database schema is correct by designating one entity as the foreign key manager (the owner) and the other as a mere reference (the inverse).
   */
  @ToString.Exclude // When we are printing Patient. It also prints this Insurance since for OneToOne mapping Fetch
  // type is eager. When Insurance is printed it will also try to print Patient again since it is referenced here
  // causing StackOverflow error. Hence, we can ignore this while printing
  @OneToOne(mappedBy = "insurance")
  private Patient patient;
}
