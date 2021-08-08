package com.example.personapi.infra.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.personapi.domain.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class PersonDbModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate birthDate;

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<PhoneDbModel> phones = new ArrayList<>();

    private static Person toDomain(PersonDbModel personDbModel) {
      return Person.builder()
              .withId(personDbModel.id)
              .withFirstName(personDbModel.firstName)
              .withLastName(personDbModel.lastName)
              .withCpf(personDbModel.cpf)
              .withBirthDate(personDbModel.birthDate)
              .withPhones(personDbModel.phones.stream().map(phone -> phone.toDomain()).collect(Collectors.toList()))
              .build();
    }

    public Person toDomain() {
      return Person.builder()
              .withId(this.id)
              .withFirstName(this.firstName)
              .withLastName(this.lastName)
              .withCpf(this.cpf)
              .withBirthDate(this.birthDate)
              .withPhones(this.phones.stream().map(phone -> phone.toDomain()).collect(Collectors.toList()))
              .build();
    }

    public static List<Person> toDomain(List<PersonDbModel> personDbModel) {
      return personDbModel.stream().map(person -> PersonDbModel.toDomain(person)).collect(Collectors.toList());
    }

    public static PersonDbModel fromDomain(Person person) {
      return PersonDbModel.builder()
              .withId(person.getId())
              .withFirstName(person.getFirstName())
              .withLastName(person.getLastName())
              .withCpf(person.getCpf())
              .withBirthDate(person.getBirthDate())
              .withPhones(person.getPhones().stream().map(phone -> PhoneDbModel.fromDomain(phone)).collect(Collectors.toList()))
              .build();
    }
}
