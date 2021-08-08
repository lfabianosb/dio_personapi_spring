package com.example.personapi.application.services.person.update;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.update.contracts.UpdatePersonPresenter;
import com.example.personapi.application.services.person.update.contracts.UpdatePersonUseCase;
import com.example.personapi.application.services.person.update.models.in.UpdatePersonRequest;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

@Service
public class UpdatePersonService implements UpdatePersonUseCase {

  private final PersonRepository repository;

  public UpdatePersonService(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(Long id, UpdatePersonRequest request, UpdatePersonPresenter presenter) {
    if (!repository.findById(id).isPresent()) {
      presenter.setError("Person #" + id + " not found");
    } else {
      Person person = repository.update(request.toDomain(id));
      presenter.setResponse(person);
    }
  }
}
