package com.example.personapi.presentation.controllers.person.update.models.in;

import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.application.services.person.update.models.in.UpdatePersonRequest;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdatePersonInput {
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  private final List<UpdatePhoneInput> phones;

  public UpdatePersonRequest toRequestModel() {
    return UpdatePersonRequest.builder()
            .withFirstName(this.firstName)
            .withLastName(this.lastName)
            .withCpf(this.cpf)
            .withBirthDate(this.birthDate)
            .withPhones(this.phones.stream().map(phone -> phone.toRequestModel()).collect(Collectors.toList()))
            .build();
  }
}
