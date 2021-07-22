package com.example.personapi.application.services.person.save;

import com.example.personapi.application.contracts.presenter.Presenter;
import com.example.personapi.application.contracts.usecase.UseCase;
import com.example.personapi.application.exceptions.CpfAlreadyExistsException;
import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SavePersonService implements UseCase<SavePersonRequest, Presenter<Person, ?>> {

  private final PersonRepository repository;

  @Override
  public void execute(SavePersonRequest request, Presenter<Person, ?> presenter) {
    if (repository.findByCpf(request.getCpf()).isPresent()) {
      throw new CpfAlreadyExistsException();
    }
    Person person = repository.create(request.toDomain());
    presenter.setModel(person);
  }
}
