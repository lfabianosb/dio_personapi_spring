package com.dio.personapi.application.services.saveperson.input;

import java.util.List;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class SavePersonInput {
  private String firstName;
  private String lastName;
  private String cpf;
  private String birthDate;
  private List<SavePhoneInput> phones = new ArrayList<>();
}
