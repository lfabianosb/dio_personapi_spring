package com.dio.personapi.infra.mapper;

import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.infra.models.PersonDbModel;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonDbMapper {

    Person toEntity(PersonDbModel model);

    PersonDbModel toDbModel(Person entity);
}
