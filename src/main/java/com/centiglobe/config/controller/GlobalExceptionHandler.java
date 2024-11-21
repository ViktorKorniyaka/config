package com.centiglobe.config.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Map<String, String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
    Map<String, String> errorsMap = new HashMap();
    ex.getBindingResult().getFieldErrors()
        .forEach(e -> errorsMap.put(e.getField(), e.getDefaultMessage()));
    return new ResponseEntity<>(getErrorsMap(errorsMap), new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleValidationErrors(IllegalArgumentException ex) {
    return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleValidationErrors(Exception ex) {
    return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private Map<String, Map<String, String>> getErrorsMap(Map<String, String> errors) {
    Map<String, Map<String, String>> errorResponse = new HashMap<>();
    errorResponse.put("errors", errors);
    return errorResponse;
  }

}

