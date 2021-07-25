package com.example.personapi.application.services.person.getbyid.contracts;

import com.example.personapi.application.services.person.getbyid.models.out.GetByIdPersonResponse;

public interface GetByIdUseCase {
  GetByIdPersonResponse execute(Long id);
}
