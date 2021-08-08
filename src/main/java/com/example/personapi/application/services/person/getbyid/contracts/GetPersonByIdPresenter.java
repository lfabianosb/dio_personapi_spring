package com.example.personapi.application.services.person.getbyid.contracts;

import com.example.personapi.domain.entities.Person;

public interface GetPersonByIdPresenter {
  void setResponse(Person response);
  void setNotFound(String message);
  void setError(String message);
}
