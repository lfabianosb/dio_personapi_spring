package com.dio.personapi.application.services.updateperson;

import com.dio.personapi.application.exceptions.PersonNotFoundException;
import com.dio.personapi.application.mappers.PersonServiceMapper;
import com.dio.personapi.application.repositories.PersonRepository;
import com.dio.personapi.application.services.updateperson.input.UpdatePersonInput;
import com.dio.personapi.core.usecase.UseCase;
import com.dio.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePersonService implements UseCase<UpdatePersonInput, Person> {
  private final PersonRepository personRepository;
  private final PersonServiceMapper personServiceMapper;

  @Override
  public Person execute(UpdatePersonInput input) throws PersonNotFoundException {
    personRepository.findById(input.getId());
    Person personToUpdate = personServiceMapper.toEntity(input);
    return personRepository.update(personToUpdate);
  }
  
}
