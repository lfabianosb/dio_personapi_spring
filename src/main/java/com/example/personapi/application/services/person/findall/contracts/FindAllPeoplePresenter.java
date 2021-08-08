package com.example.personapi.application.services.person.findall.contracts;

import java.util.List;

import com.example.personapi.domain.entities.Person;

public interface FindAllPeoplePresenter {
  void setResponse(List<Person> response);
  void setError(String message);
}
