package com.example.personapi.presentation.controllers.person.save;

import com.example.personapi.application.services.person.save.SavePhoneRequest;

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
