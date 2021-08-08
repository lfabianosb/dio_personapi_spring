package com.example.personapi.application.services.person.getbyid;

import java.util.Optional;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.getbyid.contracts.GetPersonByIdPresenter;
import com.example.personapi.application.services.person.getbyid.contracts.GetPersonByIdUseCase;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

@Service
public class GetPersonByIdService implements GetPersonByIdUseCase {
  private final PersonRepository repository;

  public GetPersonByIdService(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(Long id, GetPersonByIdPresenter presenter) {
    try {
      Optional<Person> foundPerson = repository.findById(id);
      if (foundPerson.isPresent()) {
        presenter.setResponse(foundPerson.get());
      } else {
        presenter.setNotFound("Person ID " + id + " not found");
      }
    } catch (Exception e) {
      presenter.setError(e.getMessage());
    }
  }
}
