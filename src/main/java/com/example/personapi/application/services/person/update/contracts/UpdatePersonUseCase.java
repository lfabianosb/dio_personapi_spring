package com.example.personapi.application.services.person.update.contracts;

import com.example.personapi.application.services.person.update.models.in.UpdatePersonRequest;

public interface UpdatePersonUseCase {
  void execute(Long id, UpdatePersonRequest request, UpdatePersonPresenter presenter);
}
