package com.example.personapi.application.services.person.findall.models.out;

import java.time.LocalDate;
import java.util.List;

import com.example.personapi.domain.entities.Person;
import com.example.personapi.domain.entities.Phone;

public class FindAllPeolpleRespnose extends Person {

  public FindAllPeolpleRespnose(Long id, String firstName, String lastName, String cpf, LocalDate birthDate,
      List<Phone> phones) {
    super(id, firstName, lastName, cpf, birthDate, phones);
  }
  
  public static FindAllPeolpleRespnose fromDomain(Person person) {
    return new FindAllPeolpleRespnose(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getCpf(),
                person.getBirthDate(),
                person.getPhones());
  }
}
