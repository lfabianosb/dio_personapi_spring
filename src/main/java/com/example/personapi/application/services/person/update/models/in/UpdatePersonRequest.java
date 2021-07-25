package com.example.personapi.application.services.person.update.models.in;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.example.personapi.domain.entities.Person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePersonRequest {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  @Builder.Default
  private final List<UpdatePhoneRequest> phones = new ArrayList<>();

  public Person toDomain() {
    return Person.builder()
            .id(this.id)
            .firstName(this.firstName)
            .lastName(this.lastName)
            .cpf(this.cpf)
            .birthDate(LocalDate.parse(this.birthDate))
            .phones(phones.stream().map(phone -> phone.toDomain()).collect(Collectors.toList()))
            .build();
  }
}
