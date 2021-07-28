package com.example.personapi.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Phone {
  private final Long id;
  private final PhoneType type;
  private final String number;
}
