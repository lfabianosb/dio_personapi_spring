package com.example.personapi.presentation.controllers.person.save;

import com.example.personapi.application.services.person.save.contracts.SavePersonPresenter;
import com.example.personapi.application.services.person.save.contracts.SavePersonUseCase;
import com.example.personapi.domain.entities.Person;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.controllers.person.save.models.in.SavePersonInput;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class SavePersonController extends PersonControllerBase implements SavePersonPresenter {
  private final SavePersonUseCase useCase;
  private ResponseEntity<?> result;

  public SavePersonController(SavePersonUseCase useCase) {
    this.useCase = useCase;
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody SavePersonInput personInput) {
    useCase.execute(personInput.toRequestModel(), this);
    return result;
  }

  @Override
  public void setResponse(Person response) {
    this.result = ResponseEntity.status(HttpStatus.CREATED).body(PersonViewModel.fromDomain(response));
  }

  @Override
  public void setError(String message) {
    this.result = ResponseEntity.badRequest().body(message);
  }
}
