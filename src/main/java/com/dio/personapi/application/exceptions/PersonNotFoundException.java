package com.dio.personapi.application.exceptions;

public class PersonNotFoundException extends RuntimeException {
  public PersonNotFoundException(Long id) {
    super("Person with id " + id + " was not found");
  }
}