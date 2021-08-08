package com.example.personapi.application.services.person.delete.contracts;

public interface DeletePersonUseCase {
  void execute(Long id, DeletePersonPresenter presenter);
}
