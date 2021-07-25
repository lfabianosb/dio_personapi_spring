package com.example.personapi.application.services.person.create.contracts;

import com.example.personapi.application.services.person.create.models.in.SavePersonRequest;
import com.example.personapi.application.services.person.create.models.out.SavePersonResponse;

public interface SavePersonUseCase {
  SavePersonResponse execute(SavePersonRequest request);
}
