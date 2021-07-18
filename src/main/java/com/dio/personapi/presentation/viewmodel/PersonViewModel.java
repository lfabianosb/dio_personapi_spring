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
}
