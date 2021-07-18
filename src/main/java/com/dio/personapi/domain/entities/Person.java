package com.dio.personapi.domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Person {
  private Long id;
  private String firstName;
  private String lastName;
  private String cpf;
  private LocalDate birthDate;
  @Builder.Default
  private List<Phone> phones = new ArrayList<>();
}
