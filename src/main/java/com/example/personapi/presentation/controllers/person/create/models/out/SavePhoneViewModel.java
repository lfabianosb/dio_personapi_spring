package com.example.personapi.presentation.controllers.person.create.models.out;

import com.example.personapi.application.services.person.create.models.out.SavePhoneResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SavePhoneViewModel {
  private final Long id;
  private final String type;
  private final String number;

  public static SavePhoneViewModel fromResponse(SavePhoneResponse phone) {
    return SavePhoneViewModel.builder()
            .id(phone.getId())
            .type(phone.getType())
            .number(phone.getNumber())
            .build();
  }
}
