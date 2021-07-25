package com.example.personapi.application.services.person.getbyid;

import com.example.personapi.application.exceptions.PersonNotFoundException;
import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.getbyid.contracts.GetPersonByIdUseCase;
import com.example.personapi.application.services.person.getbyid.models.out.GetByIdPersonResponse;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

@Service
public class GetPersonByIdService implements GetPersonByIdUseCase {
  private final PersonRepository repository;

  public GetPersonByIdService(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public GetByIdPersonResponse execute(Long id) {
    Person person = repository.findById(id).orElseThrow(() -> new PersonNotFoundException());
    return GetByIdPersonResponse.fromDomain(person);
  }
}
