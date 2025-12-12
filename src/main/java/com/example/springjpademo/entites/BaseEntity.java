package com.example.springjpademo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@MappedSuperclass // <--- 1. Base class fields are mapped to subclasses
@EntityListeners(AuditingEntityListener.class) // <--- 2. Tells JPA to use the auditing listener
@Getter
public abstract class BaseEntity {

  // Automatically set when the entity is first persisted
  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  private ZonedDateTime createdAt;

  // Automatically set on save/update
  @LastModifiedDate
  @Column(name = "updated_at", nullable = false)
  private ZonedDateTime updatedAt;

}
