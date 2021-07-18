package com.dio.personapi.infra.datasource;

import com.dio.personapi.infra.models.PersonDbModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDataSource extends JpaRepository<PersonDbModel, Long> {  
}
