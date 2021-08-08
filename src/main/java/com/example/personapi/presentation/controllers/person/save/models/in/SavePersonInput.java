package com.example.personapi.presentation.controllers.person.save.models.in;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.application.services.person.save.models.in.SavePersonRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SavePersonInput {
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  private final List<SavePhoneInput> phones = new ArrayList<>();

  public SavePersonRequest toRequestModel() {
    return SavePersonRequest
            .builder()
            .withFirstName(this.firstName)
            .withLastName(this.lastName)
            .withCpf(this.cpf)
            .withBirthDate(this.birthDate)
            .withPhones(this.phones.stream().map(phone -> phone.toRequestModel()).collect(Collectors.toList()))
            .build();
  }
}
