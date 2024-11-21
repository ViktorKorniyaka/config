package com.centiglobe.config.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UsersConfig {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String memberName;

  @Column(nullable = false)
  private Integer maxConnections;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status;

}
