package com.example.personapi.presentation.controllers.person.update;

import com.example.personapi.application.services.person.update.contracts.UpdatePersonUseCase;
import com.example.personapi.application.services.person.update.models.out.UpdatePersonResponse;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.controllers.person.update.in.UpdatePersonInput;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class UpdatePersonController extends PersonControllerBase {
  private final UpdatePersonUseCase useCase;

  public UpdatePersonController(UpdatePersonUseCase useCase) {
    this.useCase = useCase;
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PersonViewModel update(@PathVariable Long id, @RequestBody UpdatePersonInput personInput) {
    UpdatePersonResponse useCaseResponse = useCase.execute(personInput.toRequestModel());
    return PersonViewModel.fromDomain(useCaseResponse);
  }
}
