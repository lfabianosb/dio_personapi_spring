package com.example.personapi.application.repositories;

import java.util.List;
import java.util.Optional;

import com.example.personapi.domain.entities.Person;

public interface PersonRepository {
  Optional<Person> findById(Long id);
  Optional<Person> findByCpf(String cpf);
  Person create(Person person);
  List<Person> findAll();
  Person update(Person person);
  void delete(Long id);
}
