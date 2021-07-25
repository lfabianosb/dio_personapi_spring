package com.example.personapi.application.services.person.findall;

import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.findall.contracts.FindAllPeopleUseCase;
import com.example.personapi.application.services.person.findall.models.out.FindAllPeolpleRespnose;
import com.example.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

@Service
public class FindAllPeopleService implements FindAllPeopleUseCase {
  private final PersonRepository repository;

  public FindAllPeopleService(PersonRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<FindAllPeolpleRespnose> execute() {
    List<Person> people = repository.findAll();
    return people.stream().map(person -> FindAllPeolpleRespnose.fromDomain(person)).collect(Collectors.toList());
  }
}
