package com.dio.personapi.application.services.saveperson.input;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class SavePhoneInput {
  private String type;
  private String number;
}
