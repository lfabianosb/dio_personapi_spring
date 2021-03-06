package com.example.personapi.application.services.person.update.models.in;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.domain.entities.Person;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class UpdatePersonRequest {
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  private final List<UpdatePhoneRequest> phones;

  public Person toDomain(Long id) {
    return Person.builder()
            .withId(id)
            .withFirstName(this.firstName)
            .withLastName(this.lastName)
            .withCpf(this.cpf)
            .withBirthDate(LocalDate.parse(this.birthDate))
            .withPhones(phones.stream().map(phone -> phone.toDomain()).collect(Collectors.toList()))
            .build();
  }
}
