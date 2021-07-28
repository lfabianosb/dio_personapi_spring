package com.example.personapi.presentation.controllers.person.create.models.out;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.application.services.person.create.models.out.SavePersonResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SavePersonViewModel {
  private final Long id;
  private final String firstName;
  private final String lastName;
  private final String cpf;
  private final String birthDate;
  private final List<SavePhoneViewModel> phones;

  public static SavePersonViewModel fromResponse(SavePersonResponse person) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return SavePersonViewModel.builder()
            .id(person.getId())
            .firstName(person.getFirstName())
            .lastName(person.getLastName())
            .cpf(person.getCpf())
            .birthDate(person.getBirthDate().format(formatter))
            .phones(person.getPhones().stream().map(phone -> SavePhoneViewModel.fromResponse(phone)).collect(Collectors.toList()))
            .build();
  }
}
