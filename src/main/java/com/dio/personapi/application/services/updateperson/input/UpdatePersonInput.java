package com.dio.personapi.application.services.updateperson.input;

import java.util.List;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class UpdatePersonInput {
  private Long id;
  private String firstName;
  private String lastName;
  private String cpf;
  private String birthDate;
  private List<UpdatePhoneInput> phones = new ArrayList<>();

  public void setId(Long id) {
    this.id = id;
  }
}
