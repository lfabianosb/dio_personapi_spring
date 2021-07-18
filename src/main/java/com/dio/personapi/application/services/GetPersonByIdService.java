package com.dio.personapi.application.services;

import com.dio.personapi.application.exceptions.PersonNotFoundException;
import com.dio.personapi.application.repositories.PersonRepository;
import com.dio.personapi.core.usecase.UseCase;
import com.dio.personapi.domain.entities.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPersonByIdService implements UseCase<GetPersonByIdService.Param, Person> {
  private final PersonRepository personRepository;

  @Override
  public Person execute(Param input) throws PersonNotFoundException {
    return personRepository.findById(input.getId());
  }
  
  public static class Param {
    private Long id;

    public Long getId() {
      return this.id;
    }

    public Param(Long id) {
      this.id = id;
    }
  }
}
