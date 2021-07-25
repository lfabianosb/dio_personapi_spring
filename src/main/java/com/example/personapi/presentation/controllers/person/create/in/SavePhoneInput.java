package com.example.personapi.presentation.controllers.person.create.in;

import com.example.personapi.application.services.person.create.models.in.SavePhoneRequest;

import lombok.Data;

@Data
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
