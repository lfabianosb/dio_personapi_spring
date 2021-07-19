package com.dio.personapi.application.services.getpersonbyid;

import com.dio.personapi.application.exceptions.PersonNotFoundException;
import com.dio.personapi.application.repositories.PersonRepository;
import com.dio.personapi.application.services.getpersonbyid.input.GetPersonByIdInput;
import com.dio.personapi.core.usecase.UseCase;
import com.dio.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPersonByIdService implements UseCase<GetPersonByIdInput, Person> {
  private final PersonRepository personRepository;

  @Override
  public Person execute(GetPersonByIdInput input) throws PersonNotFoundException {
    return personRepository.findById(input.getId());
  }
}
