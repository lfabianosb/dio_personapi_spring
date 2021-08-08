package com.example.personapi.application.services.person.update.contracts;

import com.example.personapi.domain.entities.Person;

public interface UpdatePersonPresenter {
  void setResponse(Person response);
  void setError(String message);
}
