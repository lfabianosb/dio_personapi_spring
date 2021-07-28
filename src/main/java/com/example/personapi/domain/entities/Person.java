package com.example.personapi.domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Person {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final LocalDate birthDate;
  @Builder.Default
  private final List<Phone> phones = new ArrayList<>();
}
