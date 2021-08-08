package com.example.personapi.application.services.person.delete;

import java.util.Optional;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.delete.contracts.DeletePersonPresenter;
import com.example.personapi.application.services.person.delete.contracts.DeletePersonUseCase;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

@Service
public class DeletePersonService implements DeletePersonUseCase {
  private final PersonRepository repository;

  public DeletePersonService(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(Long id, DeletePersonPresenter presenter) {
    try {
      Optional<Person> personToFind = repository.findById(id);
      if (personToFind.isPresent()) {
        repository.delete(id);
        presenter.setResponse();
      } else {
        presenter.setNotFound("Person ID " + id + " not found");
      }
    } catch (Exception e) {
      presenter.setError(e.getMessage());
    }
  }
  
}
