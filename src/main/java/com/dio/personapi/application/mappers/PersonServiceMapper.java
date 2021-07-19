package com.dio.personapi.application.mappers;

import com.dio.personapi.application.services.saveperson.input.SavePersonInput;
import com.dio.personapi.application.services.updateperson.input.UpdatePersonInput;
import com.dio.personapi.domain.entities.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonServiceMapper {
  @Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")
  Person toEntity(SavePersonInput input);

  @Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")
  Person toEntity(UpdatePersonInput input);
}
