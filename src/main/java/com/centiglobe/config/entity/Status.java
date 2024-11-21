package com.centiglobe.config.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Status {
  ACTIVE("ACTIVE"),
  SUSPENDED("SUSPENDED"),
  DECOMMISSIONED("DECOMMISSIONED");
  private final String value;

  Status(String value) {
    this.value = value;
  }

  //@JsonValue
  public String getValue() {
    return value;
  }

  //@JsonCreator
  public static Status forValue(String value) {

    return Stream.of(Status.values())
        .filter(enumValue -> enumValue.name().equals(value.toUpperCase()))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
