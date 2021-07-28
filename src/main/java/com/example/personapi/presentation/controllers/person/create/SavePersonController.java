package com.example.personapi.presentation.controllers.person.create;

import com.example.personapi.application.services.person.create.contracts.SavePersonUseCase;
import com.example.personapi.application.services.person.create.models.out.SavePersonResponse;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.controllers.person.create.models.in.SavePersonInput;
import com.example.personapi.presentation.controllers.person.create.models.out.SavePersonViewModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class SavePersonController extends PersonControllerBase {
  private final SavePersonUseCase useCase;

  public SavePersonController(SavePersonUseCase useCase) {
    this.useCase = useCase;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SavePersonViewModel create(@RequestBody SavePersonInput personInput) {
    final SavePersonResponse useCaseResponse = useCase.execute(personInput.toRequestModel());
    return SavePersonViewModel.fromResponse(useCaseResponse);
  }
}
