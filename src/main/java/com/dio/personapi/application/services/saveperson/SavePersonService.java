package com.dio.personapi.application.services.saveperson;

import com.dio.personapi.application.mappers.PersonServiceMapper;
import com.dio.personapi.application.repositories.PersonRepository;
import com.dio.personapi.application.services.saveperson.input.SavePersonInput;
import com.dio.personapi.core.usecase.UseCase;
import com.dio.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SavePersonService implements UseCase<SavePersonInput, Person> {
  private final PersonRepository personRepository;
  private final PersonServiceMapper personServiceMapper;

  @Override
  public Person execute(SavePersonInput input) {
    Person personTosave = personServiceMapper.toEntity(input);
    return personRepository.save(personTosave);
  }
}
