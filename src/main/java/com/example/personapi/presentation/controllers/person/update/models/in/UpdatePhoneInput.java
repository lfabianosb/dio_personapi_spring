package com.example.personapi.presentation.controllers.person.update.models.in;

import com.example.personapi.application.services.person.update.models.in.UpdatePhoneRequest;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
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
