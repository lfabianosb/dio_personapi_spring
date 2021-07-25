package com.example.personapi.application.services.person.create.models.in;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.example.personapi.domain.entities.Person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SavePersonRequest {
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  @Builder.Default
  private final List<SavePhoneRequest> phones = new ArrayList<>();

  public Person toDomain() {
    return Person.builder()
            .firstName(this.firstName)
            .lastName(this.lastName)
            .cpf(this.cpf)
            .birthDate(LocalDate.parse(this.birthDate))
            .phones(phones.stream().map(phone -> phone.toDomain()).collect(Collectors.toList()))
            .build();
  }
}
