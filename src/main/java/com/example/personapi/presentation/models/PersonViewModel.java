package com.example.personapi.presentation.models;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.domain.entities.Person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonViewModel {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  @Builder.Default
  private final List<PhoneViewModel> phones = new ArrayList<>();

  public static PersonViewModel fromDomain(Person person) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return PersonViewModel.builder()
            .id(person.getId())
            .firstName(person.getFirstName())
            .lastName(person.getLastName())
            .cpf(person.getCpf())
            .birthDate(person.getBirthDate().format(formatter))
            .phones(person.getPhones().stream().map(phone -> PhoneViewModel.fromDomain(phone)).collect(Collectors.toList()))
            .build();
  }
}
