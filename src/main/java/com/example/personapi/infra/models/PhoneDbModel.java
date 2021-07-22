package com.example.personapi.infra.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.personapi.domain.entities.Phone;
import com.example.personapi.domain.entities.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDbModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;

    public Phone toDomain() {
      return Phone.builder()
              .id(this.id)
              .type(this.type)
              .number(this.number)
              .build();
    }

    public static PhoneDbModel fromDomain(Phone phone) {
      return PhoneDbModel.builder()
              .id(phone.getId())
              .type(phone.getType())
              .number(phone.getNumber())
              .build();
    }
}
