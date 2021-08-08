package com.example.personapi.application.services.person.save;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.save.contracts.SavePersonPresenter;
import com.example.personapi.application.services.person.save.contracts.SavePersonUseCase;
import com.example.personapi.application.services.person.save.models.in.SavePersonRequest;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

@Service
public class SavePersonService implements SavePersonUseCase {

  private final PersonRepository repository;

  public SavePersonService(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(SavePersonRequest request, SavePersonPresenter presenter) {
    if (repository.findByCpf(request.getCpf()).isPresent()) {
      presenter.setError("CPF #" + request.getCpf() + " already exists");
    } else {
      Person person = repository.create(request.toDomain());
      presenter.setResponse(person);
    }
  }
}
