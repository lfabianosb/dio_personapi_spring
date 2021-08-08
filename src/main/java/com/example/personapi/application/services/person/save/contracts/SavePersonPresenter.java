package com.example.personapi.application.services.person.save.contracts;

import com.example.personapi.domain.entities.Person;

public interface SavePersonPresenter {
  void setResponse(Person response);
  void setError(String message);
}
