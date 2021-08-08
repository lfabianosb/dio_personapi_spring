package com.example.personapi.infra.repositories;

import java.util.List;
import java.util.Optional;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.domain.entities.Person;
import com.example.personapi.infra.datasource.PersonDataSource;
import com.example.personapi.infra.models.PersonDbModel;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {
  private final PersonDataSource personDataSource;

  @Override
  public Optional<Person> findById(Long id) {
    Optional<PersonDbModel> personDbModel = personDataSource.findById(id);
    if (personDbModel.isPresent()) {
      return Optional.of(personDbModel.get().toDomain());
    }
    return Optional.empty();
  }

  @Override
  public Person create(Person person) {
    PersonDbModel personDbModel = personDataSource.save(PersonDbModel.fromDomain(person));
    return personDbModel.toDomain();
  }

  @Override
  public Optional<Person> findByCpf(String cpf) {
    PersonDbModel personDbModel = personDataSource.findByCpf(cpf);
    if (personDbModel != null) {
      return Optional.of(personDbModel.toDomain());
    }
    return Optional.empty();
  }

  @Override
  public Person update(Person person) {
    PersonDbModel personToUpdate = PersonDbModel.fromDomain(person);    
    PersonDbModel personUpdated = personDataSource.save(personToUpdate);
    return personUpdated.toDomain();
  }

  @Override
  public void delete(Long id) {
    personDataSource.deleteById(id);
  }

  @Override
  public List<Person> findAll() {
    List<PersonDbModel> result = personDataSource.findAll();
    return PersonDbModel.toDomain(result);
  }
}
