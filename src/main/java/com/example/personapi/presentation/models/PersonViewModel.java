package com.example.personapi.presentation.models;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.domain.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class PersonViewModel {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  private final List<PhoneViewModel> phones;

  public static PersonViewModel fromDomain(Person person) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return PersonViewModel.builder()
            .withId(person.getId())
            .withFirstName(person.getFirstName())
            .withLastName(person.getLastName())
            .withCpf(person.getCpf())
            .withBirthDate(person.getBirthDate().format(formatter))
            .withPhones(person.getPhones().stream().map(phone -> PhoneViewModel.fromDomain(phone)).collect(Collectors.toList()))
            .build();
  }

  public static List<PersonViewModel> fromDomain(List<Person> poeple) {
    return poeple.stream().map(person -> PersonViewModel.fromDomain(person)).collect(Collectors.toList());
  }
}
