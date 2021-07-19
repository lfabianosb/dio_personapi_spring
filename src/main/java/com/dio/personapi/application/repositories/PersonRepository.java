package com.dio.personapi.application.repositories;

import java.util.List;

import com.dio.personapi.application.exceptions.PersonNotFoundException;
import com.dio.personapi.domain.entities.Person;

public interface PersonRepository {
  Person findById(Long id) throws PersonNotFoundException;

  List<Person> listAll();
  
  void delete(Long id) throws PersonNotFoundException;

  Person save(Person person);

  Person update(Person person) throws PersonNotFoundException;
}
