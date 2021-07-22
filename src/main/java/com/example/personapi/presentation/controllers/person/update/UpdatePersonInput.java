package com.example.personapi.presentation.controllers.person.update;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.application.services.person.update.UpdatePersonRequest;

import lombok.Data;

@Data
public class UpdatePersonInput {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  private final List<UpdatePhoneInput> phones = new ArrayList<>();

  public UpdatePersonRequest toRequestModel() {
    return UpdatePersonRequest
            .builder()
            .id(this.id)
            .firstName(this.firstName)
            .lastName(this.lastName)
            .cpf(this.cpf)
            .birthDate(this.birthDate)
            .phones(this.phones.stream().map(phone -> phone.toRequestModel()).collect(Collectors.toList()))
            .build();
  }
}
