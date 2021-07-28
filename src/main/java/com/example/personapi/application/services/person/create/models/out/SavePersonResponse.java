package com.example.personapi.application.services.person.create.models.out;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.domain.entities.Person;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SavePersonResponse {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final LocalDate birthDate;
  private final List<SavePhoneResponse> phones;

  public static SavePersonResponse fromDomain(Person person) {
    return SavePersonResponse.builder()
            .id(person.getId())
            .firstName(person.getFirstName())
            .lastName( person.getLastName())
            .cpf(person.getCpf())
            .birthDate(person.getBirthDate())
            .phones(person.getPhones().stream().map(phone -> SavePhoneResponse.fromDomain(phone)).collect(Collectors.toList()))
            .build();
  }
}
