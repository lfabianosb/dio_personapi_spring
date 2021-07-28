package com.example.personapi.presentation.controllers.person.create.models.in;

import com.example.personapi.application.services.person.create.models.in.SavePhoneRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SavePhoneInput {
  private final String type;
  private final String number;

  public SavePhoneRequest toRequestModel() {
    return SavePhoneRequest
            .builder()
            .type(this.type)
            .number(this.number)
            .build();
  }
}
