package com.example.personapi.application.services.person.create.models.out;

import com.example.personapi.domain.entities.Phone;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SavePhoneResponse {
  private final Long id;
  private final String type;
  private final String number;

  public static SavePhoneResponse fromDomain(Phone phone) {
    return SavePhoneResponse.builder()
            .id(phone.getId())
            .type(phone.getType().getDescription().toLowerCase())
            .number("(" + phone.getNumber().substring(0, 2) + ")" + phone.getNumber().substring(2, 6) + "-" + phone.getNumber().substring(6))
            .build();
  }
}
