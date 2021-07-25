package com.example.personapi.application.services.person.update.models.out;

import java.time.LocalDate;
import java.util.List;

import com.example.personapi.domain.entities.Person;
import com.example.personapi.domain.entities.Phone;

import lombok.ToString;

@ToString
public class UpdatePersonResponse extends Person {

  public UpdatePersonResponse(Long id, String firstName, String lastName, String cpf, LocalDate birthDate, List<Phone> phones) {
    super(id, firstName, lastName, cpf, birthDate, phones);
  }

  public static UpdatePersonResponse fromDomain(Person person) {
    return new UpdatePersonResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getCpf(),
                person.getBirthDate(),
                person.getPhones());
  }
}
