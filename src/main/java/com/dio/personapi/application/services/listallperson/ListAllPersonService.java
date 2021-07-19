package com.dio.personapi.application.services.listallperson;

import java.util.List;

import com.dio.personapi.application.repositories.PersonRepository;
import com.dio.personapi.core.usecase.UseCaseNoInput;
import com.dio.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListAllPersonService implements UseCaseNoInput<List<Person>> {
  private final PersonRepository personRepository;

  @Override
  public List<Person> execute() {
    return personRepository.listAll();
  }
}
