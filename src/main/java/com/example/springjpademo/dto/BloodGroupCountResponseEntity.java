package com.example.springjpademo.dto;

import com.example.springjpademo.entites.type.BloodGroupType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BloodGroupCountResponseEntity {
  private BloodGroupType bloodGroupType;

  private Long count;
}
