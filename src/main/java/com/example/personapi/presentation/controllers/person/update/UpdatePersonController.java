package com.example.personapi.presentation.controllers.person.update;

import com.example.personapi.application.services.person.update.contracts.UpdatePersonPresenter;
import com.example.personapi.application.services.person.update.contracts.UpdatePersonUseCase;
import com.example.personapi.domain.entities.Person;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.controllers.person.update.models.in.UpdatePersonInput;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class UpdatePersonController extends PersonControllerBase implements UpdatePersonPresenter {
  private final UpdatePersonUseCase useCase;
  private ResponseEntity<?> result;

  public UpdatePersonController(UpdatePersonUseCase useCase) {
    this.useCase = useCase;
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UpdatePersonInput personInput) {
    useCase.execute(id, personInput.toRequestModel(), this);
    return this.result;
  }

  @Override
  public void setResponse(Person response) {
    this.result = ResponseEntity.status(HttpStatus.OK).body(PersonViewModel.fromDomain(response));
  }

  @Override
  public void setError(String message) {
    this.result = ResponseEntity.notFound().build();
  }
}
