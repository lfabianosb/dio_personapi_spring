package com.example.personapi.application.services.person.update;

import com.example.personapi.application.contracts.presenter.Presenter;
import com.example.personapi.application.contracts.usecase.UseCase;
import com.example.personapi.application.exceptions.PersonNotFoundException;
import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePersonService implements UseCase<UpdatePersonRequest, Presenter<Person, ?>> {

  private final PersonRepository repository;

  @Override
  public void execute(UpdatePersonRequest request, Presenter<Person, ?> presenter) {
    if (!repository.findById(request.getId()).isPresent()) {
      throw new PersonNotFoundException();
    }
    Person person = repository.update(request.toDomain());
    presenter.setModel(person);
  }
}
