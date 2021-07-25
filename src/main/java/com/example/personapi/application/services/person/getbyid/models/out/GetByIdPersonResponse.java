package com.example.personapi.application.services.person.getbyid.models.out;

import java.time.LocalDate;
import java.util.List;

import com.example.personapi.domain.entities.Person;
import com.example.personapi.domain.entities.Phone;

import lombok.ToString;

@ToString
public class GetByIdPersonResponse extends Person {

  public GetByIdPersonResponse(Long id, String firstName, String lastName, String cpf, LocalDate birthDate, List<Phone> phones) {
    super(id, firstName, lastName, cpf, birthDate, phones);
  }

  public static GetByIdPersonResponse fromDomain(Person person) {
    return new GetByIdPersonResponse(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getCpf(),
                person.getBirthDate(),
                person.getPhones());
  }
}
