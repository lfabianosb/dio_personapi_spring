package com.example.personapi.application.services.person.update.contracts;

import com.example.personapi.application.services.person.update.models.in.UpdatePersonRequest;
import com.example.personapi.application.services.person.update.models.out.UpdatePersonResponse;

public interface UpdatePersonUseCase {
  UpdatePersonResponse execute(UpdatePersonRequest request);
}
