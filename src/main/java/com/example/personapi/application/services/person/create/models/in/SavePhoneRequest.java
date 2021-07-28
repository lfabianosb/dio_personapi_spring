package com.example.personapi.application.services.person.create.models.in;

import com.example.personapi.domain.entities.Phone;
import com.example.personapi.domain.entities.PhoneType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SavePhoneRequest {
  private final String type;
  private final String number;

  Phone toDomain() {
    return Phone.builder()
            .type(PhoneType.COMMERCIAL)
            .number(this.number)
            .build();
  }
}
