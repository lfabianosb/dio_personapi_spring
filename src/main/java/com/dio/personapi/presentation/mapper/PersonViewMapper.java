package com.dio.personapi.presentation.mapper;

import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.presentation.viewmodel.PersonViewModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonViewMapper {

  @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
  Person toEntity(PersonViewModel model);

  PersonViewModel toViewModel(Person entity);
}
