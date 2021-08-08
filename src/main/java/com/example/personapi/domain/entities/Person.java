package com.example.personapi.domain.entities;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
@AllArgsConstructor
@EqualsAndHashCode
public class Person {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final LocalDate birthDate;
  private final List<Phone> phones;
}
