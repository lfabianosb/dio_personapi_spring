package com.example.personapi.presentation.controllers.person.save;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.application.services.person.save.SavePersonRequest;

import lombok.Data;

@Data
public class SavePersonInput {
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  private final List<SavePhoneInput> phones = new ArrayList<>();

  public SavePersonRequest toRequestModel() {
    return SavePersonRequest
            .builder()
            .firstName(this.firstName)
            .lastName(this.lastName)
            .cpf(this.cpf)
            .birthDate(this.birthDate)
            .phones(this.phones.stream().map(phone -> phone.toRequestModel()).collect(Collectors.toList()))
            .build();
  }
}
