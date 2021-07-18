package com.dio.personapi.presentation.viewmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class PersonViewModel {
  private Long id;
  private String firstName;
  private String lastName;
  private String cpf;
  private String birthDate;
  private List<PhoneViewModel> phones = new ArrayList<>();

  public String getCpf() {
    if (this.cpf != null && this.cpf.length() == 11) {
      return this.cpf.substring(0, 3) + "." + this.cpf.substring(3, 6) + "." + this.cpf.substring(6, 9) + "-" + this.cpf.substring(9);
    }
    return this.cpf;
  }
}
