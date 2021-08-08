package com.example.personapi.application.services.person.getbyid.contracts;

public interface GetPersonByIdUseCase {
  void execute(Long id, GetPersonByIdPresenter presenter);
}
