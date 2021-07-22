package com.example.personapi.application.services.person.save;

import com.example.personapi.domain.entities.Phone;
import com.example.personapi.domain.entities.PhoneType;

import lombok.Builder;
import lombok.Data;

@Data
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
