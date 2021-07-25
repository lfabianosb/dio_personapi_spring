package com.example.personapi.application.services.person.getbyid.contracts;

import com.example.personapi.application.services.person.getbyid.models.out.GetByIdPersonResponse;

public interface GetPersonByIdUseCase {
  GetByIdPersonResponse execute(Long id);
}
