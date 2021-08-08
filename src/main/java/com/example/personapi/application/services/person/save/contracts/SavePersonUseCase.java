package com.example.personapi.application.services.person.save.contracts;

import com.example.personapi.application.services.person.save.models.in.SavePersonRequest;

public interface SavePersonUseCase {
  void execute(SavePersonRequest request, SavePersonPresenter presenter);
}
