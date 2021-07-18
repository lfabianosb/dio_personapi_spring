package com.dio.personapi.application.services;

import com.dio.personapi.application.repositories.PersonRepository;
import com.dio.personapi.core.usecase.UseCase;
import com.dio.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SavePersonService implements UseCase<SavePersonService.Param, Person> {
  private final PersonRepository personRepository;

  @Override
  public Person execute(Param input) {
    return personRepository.save(input.getPerson());
  }
  
  public static class Param {
    private Person person;

    public Person getPerson() {
      return this.person;
    }

    public Param(Person person) {
      this.person = person;
    }
  }
}
