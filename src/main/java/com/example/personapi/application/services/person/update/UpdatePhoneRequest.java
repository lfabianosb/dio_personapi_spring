package com.example.personapi.application.services.person.update;

import com.example.personapi.domain.entities.Phone;
import com.example.personapi.domain.entities.PhoneType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePhoneRequest {
  private final Long id;
  private final String type;
  private final String number;

  Phone toDomain() {
    return Phone.builder()
            .id(this.id)
            .type(PhoneType.COMMERCIAL)
            .number(this.number)
            .build();
  }
}
