package com.example.personapi.application.services.person.getbyid;

import com.example.personapi.application.contracts.presenter.Presenter;
import com.example.personapi.application.contracts.usecase.UseCase;
import com.example.personapi.application.exceptions.PersonNotFoundException;
import com.example.personapi.application.exceptions.ValidationException;
import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPersonByIdService implements UseCase<GetPersonByIdService.GetPersonByIdRequest, Presenter<Person, ?>> {
  private final PersonRepository repository;

  @Override
  public void execute(GetPersonByIdRequest request, Presenter<Person, ?> presenter) {
    Person person = repository.findById(request.id).orElseThrow(() -> new PersonNotFoundException());
    presenter.setModel(person);
  }

  public static class GetPersonByIdRequest {
    private final Long id;

    public GetPersonByIdRequest(Long id) {
      if (id == null) {
        throw new ValidationException("id");
      }
      this.id = id;
    }
  }
}
