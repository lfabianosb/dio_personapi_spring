package com.example.personapi.application.services.person.save.models.in;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.example.personapi.domain.entities.Person;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class SavePersonRequest {
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  @Builder.Default
  private final List<SavePhoneRequest> phones = new ArrayList<>();

  public Person toDomain() {
    return Person.builder()
            .withFirstName(this.firstName)
            .withLastName(this.lastName)
            .withCpf(this.cpf)
            .withBirthDate(LocalDate.parse(this.birthDate))
            .withPhones(phones.stream().map(phone -> phone.toDomain()).collect(Collectors.toList()))
            .build();
  }
}
