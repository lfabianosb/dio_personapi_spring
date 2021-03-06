package com.example.personapi.application.services.person.update.models.in;

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

  public Phone toDomain() {
    PhoneType tp = PhoneType.COMMERCIAL;
    if (this.type.equalsIgnoreCase("home")) {
      tp = PhoneType.HOME;
    } else if (this.type.equalsIgnoreCase("mobile")) {
      tp = PhoneType.MOBILE;
    }
    return Phone.builder()
            .withId(this.id)
            .withType(tp)
            .withNumber(this.number)
            .build();
  }
}
