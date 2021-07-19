package com.dio.personapi.application.services.updateperson.input;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class UpdatePhoneInput {
  private String type;
  private String number;
}
