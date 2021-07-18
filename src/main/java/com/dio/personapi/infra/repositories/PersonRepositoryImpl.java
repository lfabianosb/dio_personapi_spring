package com.dio.personapi.infra.repositories;

import com.dio.personapi.application.repositories.PersonRepository;

import com.dio.personapi.application.exceptions.PersonNotFoundException;
import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.infra.datasource.PersonDataSource;
import com.dio.personapi.infra.mapper.PersonDbMapper;
import com.dio.personapi.infra.models.PersonDbModel;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {
  private final PersonDataSource personDataSource;
  private final PersonDbMapper personDbMapper;

  @Override
  public Person findById(Long id) throws PersonNotFoundException {
    PersonDbModel personDbModel = personDataSource.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    return personDbMapper.toEntity(personDbModel);
  }

  @Override
  public Person save(Person person) {
    PersonDbModel personDbModel = personDbMapper.toDbModel(person);
    PersonDbModel savedPersonDbModel = personDataSource.save(personDbModel);
    Person savedPerson = personDbMapper.toEntity(savedPersonDbModel);
    return savedPerson;
  }
}
