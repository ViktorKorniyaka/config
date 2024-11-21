package com.centiglobe.config.controller.dto;

import com.centiglobe.config.entity.Status;
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
public class UserConfigResponceDto {
  private Long id;
  private String memberName;
  private Integer maxConnections;
  private Status status;
}
