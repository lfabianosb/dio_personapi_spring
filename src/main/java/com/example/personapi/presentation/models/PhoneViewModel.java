package com.example.personapi.presentation.models;

import com.example.personapi.domain.entities.Phone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneViewModel {
  private final Long id;
  private final String type;
  private final String number;
  
  public static PhoneViewModel fromDomain(Phone phone) {
    return PhoneViewModel.builder()
            .id(phone.getId())
            .type(phone.getType().getDescription())
            .number(phone.getNumber())
            .build();
  }
}
