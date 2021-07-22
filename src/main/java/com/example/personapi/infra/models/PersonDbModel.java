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
@Builder
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

    public Person toDomain() {
      return Person.builder()
              .id(this.id)
              .firstName(this.firstName)
              .lastName(this.lastName)
              .cpf(this.cpf)
              .birthDate(this.birthDate)
              .phones(phones.stream().map(phone -> phone.toDomain()).collect(Collectors.toList()))
              .build();
    }

    public static PersonDbModel fromDomain(Person person) {
      return PersonDbModel.builder()
              .id(person.getId())
              .firstName(person.getFirstName())
              .lastName(person.getLastName())
              .cpf(person.getCpf())
              .birthDate(person.getBirthDate())
              .phones(person.getPhones().stream().map(phone -> PhoneDbModel.fromDomain(phone)).collect(Collectors.toList()))
              .build();
    }
}
