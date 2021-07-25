package com.example.personapi.application.services.person.create;

import com.example.personapi.application.exceptions.CpfAlreadyExistsException;
import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.create.contracts.SavePersonUseCase;
import com.example.personapi.application.services.person.create.models.in.SavePersonRequest;
import com.example.personapi.application.services.person.create.models.out.SavePersonResponse;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

@Service
public class SavePersonService implements SavePersonUseCase {

  private final PersonRepository repository;

  public SavePersonService(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public SavePersonResponse execute(SavePersonRequest request) {
    if (repository.findByCpf(request.getCpf()).isPresent()) {
      throw new CpfAlreadyExistsException();
    }
    Person person = repository.create(request.toDomain());
    return SavePersonResponse.fromDomain(person);
  }
}
