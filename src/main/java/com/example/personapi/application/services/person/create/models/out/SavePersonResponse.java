package com.example.personapi.application.services.person.create.models.out;

import java.time.LocalDate;
import java.util.List;

import com.example.personapi.domain.entities.Person;
import com.example.personapi.domain.entities.Phone;

import lombok.ToString;

@ToString
public class SavePersonResponse extends Person {

  public SavePersonResponse(Long id, String firstName, String lastName, String cpf, LocalDate birthDate, List<Phone> phones) {
    super(id, firstName, lastName, cpf, birthDate, phones);
  }

  public static SavePersonResponse fromDomain(Person person) {
    return new SavePersonResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getCpf(),
                person.getBirthDate(),
                person.getPhones());
  }
}
