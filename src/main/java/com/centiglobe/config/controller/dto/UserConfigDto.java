package com.centiglobe.config.controller.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class UserConfigDto {

  @NotBlank(message = "Member name is mandatory field")
  @Pattern(regexp = "^[a-z0-9]+([-\\.][a-z0-9]+)*$",
      message = "Member name must be follow pattern ( ^[a-z0-9]+([-\\.][a-z0-9]+)*$ )")
  private String memberName;

  @Column(nullable = false)
  @Min(0) @Max(32)
  private Integer maxConnections;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  @Pattern(regexp = "(ACTIVE|SUSPENDED|DECOMMISSIONED)",
      message = "Status should be ACTIVE, SUSPENDED, DECOMMISSIONED")
  private String status;
}
