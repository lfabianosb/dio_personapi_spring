package com.example.personapi.application.services.person.findall;

import java.util.List;

import com.example.personapi.application.contracts.presenter.Presenter;
import com.example.personapi.application.contracts.usecase.UseCaseNoRequest;
import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllPeopleService implements UseCaseNoRequest<Presenter<List<Person>, ?>> {
  private final PersonRepository repository;

  @Override
  public void execute(Presenter<List<Person>, ?> presenter) {
    List<Person> people = repository.findAll();
    presenter.setModel(people);
  }
}
