package com.example.personapi.presentation.controllers.person.save.models.in;

import com.example.personapi.application.services.person.save.models.in.SavePhoneRequest;

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
            .withType(this.type)
            .withNumber(this.number)
            .build();
  }
}
