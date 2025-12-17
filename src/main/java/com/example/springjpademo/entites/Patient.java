package com.example.springjpademo.entites;

import com.example.springjpademo.dto.Appointment;
import com.example.springjpademo.entites.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "patients",

    // uniqueConstraints is an array
    uniqueConstraints = {
        @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
        @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthDate"}) // composite unique key
    },

    // Makes querying faster by converting O(n) to O(log n)
    indexes = {
        @Index(name = "idx_patient_birth_date", columnList = "birthDate")
        // @Index(name = "idx_patient_birth_date", columnList = "birthDate, email") if we want to specify 2 columns
    }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Patient extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column(name = "patient_name", nullable = false, length = 125) // custom column name, required, varchar(125)
  private String name;

  @ToString.Exclude // will be excluded in .toString(). Wont be printed to console
  private LocalDate birthDate;

  // @Column(unique = true) // If we specify unique constraint here, we can't give custom unique key name or use
  // composite unique key
  private String email;

  private String gender;

  @Enumerated(EnumType.STRING) // By default, it will be EnumType.ORDINAL : instead of string enum 0, 1, 2 will be used
  // to represent the string values
  private BloodGroupType bloodGroup;

  @OneToOne(cascade = CascadeType.ALL) // creates a foreign_key & unique constraint as this is one to one mapping.
  // If this is only present here then it is uni directional mapping.
  // In bidirectional mapping, this becomes owning side and the other side is the inverse side
  // Don't use bidirectional mapping use (mappedBy = "insurance") on the inverse side
  @JoinColumn(name = "insurance_id", referencedColumnName = "id")
  private Insurance insurance;

  @OneToMany(mappedBy = "patient")
  private List<Appointment> appointments = new ArrayList<>();
}
