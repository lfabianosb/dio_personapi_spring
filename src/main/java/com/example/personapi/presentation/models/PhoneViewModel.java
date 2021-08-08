package com.example.personapi.presentation.models;

import com.example.personapi.domain.entities.Phone;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "with")
public class PhoneViewModel {
  private final Long id;
  private final String type;
  private final String number;
  
  public static PhoneViewModel fromDomain(Phone phone) {
    return PhoneViewModel.builder()
            .withId(phone.getId())
            .withType(phone.getType().getDescription())
            .withNumber(phone.getNumber())
            .build();
  }
}
