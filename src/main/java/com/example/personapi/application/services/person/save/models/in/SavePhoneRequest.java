package com.example.personapi.application.services.person.save.models.in;

import com.example.personapi.domain.entities.Phone;
import com.example.personapi.domain.entities.PhoneType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class SavePhoneRequest {
  private final String type;
  private final String number;

  Phone toDomain() {
    PhoneType tp = PhoneType.COMMERCIAL;
    if (this.type.equalsIgnoreCase("home")) {
      tp = PhoneType.HOME;
    } else if (this.type.equalsIgnoreCase("mobile")) {
      tp = PhoneType.MOBILE;
    }
    return Phone.builder()
            .withType(tp)
            .withNumber(this.number)
            .build();
  }
}
