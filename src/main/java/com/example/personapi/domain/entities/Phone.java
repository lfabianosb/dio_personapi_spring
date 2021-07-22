package com.example.personapi.domain.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Phone {
  private final Long id;
  private final PhoneType type;
  private final String number;
}
