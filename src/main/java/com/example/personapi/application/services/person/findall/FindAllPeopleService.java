package com.example.personapi.application.services.person.findall;

import java.util.List;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.findall.contracts.FindAllPeopleUseCase;
import com.example.personapi.application.services.person.findall.contracts.FindAllPeoplePresenter;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

@Service
public class FindAllPeopleService implements FindAllPeopleUseCase {
  private final PersonRepository repository;

  public FindAllPeopleService(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public void execute(FindAllPeoplePresenter presenter) {
    try {
      List<Person> people = repository.findAll();
      presenter.setResponse(people);
    } catch (Exception e) {
      presenter.setError(e.getMessage());
    }
  }
}
