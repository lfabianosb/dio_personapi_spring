package com.example.personapi.presentation.controllers.person.update.in;

import com.example.personapi.application.services.person.update.models.in.UpdatePhoneRequest;

import lombok.Data;

@Data
public class UpdatePhoneInput {
  private final Long id;
  private final String type;
  private final String number;

  public UpdatePhoneRequest toRequestModel() {
    return UpdatePhoneRequest
            .builder()
            .type(this.type)
            .number(this.number)
            .build();
  }
}
