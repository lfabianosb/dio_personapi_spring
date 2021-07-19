package com.dio.personapi.presentation.mappers;

import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.presentation.viewmodel.PersonViewModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonViewMapper {

  @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
  PersonViewModel toViewModel(Person entity);
}
