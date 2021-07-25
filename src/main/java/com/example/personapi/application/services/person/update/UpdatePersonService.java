package com.example.personapi.application.services.person.update;

import com.example.personapi.application.exceptions.PersonNotFoundException;
import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.update.contracts.UpdatePersonUseCase;
import com.example.personapi.application.services.person.update.models.in.UpdatePersonRequest;
import com.example.personapi.application.services.person.update.models.out.UpdatePersonResponse;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

@Service
public class UpdatePersonService implements UpdatePersonUseCase {

  private final PersonRepository repository;

  public UpdatePersonService(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public UpdatePersonResponse execute(UpdatePersonRequest request) {
    if (!repository.findById(request.getId()).isPresent()) {
      throw new PersonNotFoundException();
    }
    Person person = repository.update(request.toDomain());
    return UpdatePersonResponse.fromDomain(person);
  }
}
