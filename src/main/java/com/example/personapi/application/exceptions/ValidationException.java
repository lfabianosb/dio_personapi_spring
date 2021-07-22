package com.example.personapi.application.exceptions;

public class ValidationException extends RuntimeException {
  public ValidationException(String field) {
    super(field);
  }
}
