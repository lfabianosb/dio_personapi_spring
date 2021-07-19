package com.dio.personapi.infra.repositories;

import com.dio.personapi.application.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

import com.dio.personapi.application.exceptions.PersonNotFoundException;
import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.infra.datasource.PersonDataSource;
import com.dio.personapi.infra.mappers.PersonDbMapper;
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

  @Override
  public Person update(Person person) throws PersonNotFoundException {
    personDataSource.findById(person.getId()).orElseThrow(() -> new PersonNotFoundException(person.getId()));
    PersonDbModel personDbModel = personDbMapper.toDbModel(person);
    PersonDbModel savedPersonDbModel = personDataSource.save(personDbModel);
    return personDbMapper.toEntity(savedPersonDbModel);
  }

  @Override
  public void delete(Long id) throws PersonNotFoundException {
    personDataSource.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    personDataSource.deleteById(id);
  }

  @Override
  public List<Person> listAll() {
    List<PersonDbModel> result = personDataSource.findAll();
    return result.stream().map(personDbMapper::toEntity).collect(Collectors.toList());
  }
}
