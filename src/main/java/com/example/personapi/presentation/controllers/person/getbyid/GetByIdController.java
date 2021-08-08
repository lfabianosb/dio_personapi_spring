package com.example.personapi.presentation.controllers.person.getbyid;

import com.example.personapi.application.services.person.getbyid.contracts.GetPersonByIdPresenter;
import com.example.personapi.application.services.person.getbyid.contracts.GetPersonByIdUseCase;
import com.example.personapi.domain.entities.Person;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class GetByIdController extends PersonControllerBase implements GetPersonByIdPresenter {
  private final GetPersonByIdUseCase useCase;
  private ResponseEntity<?> result;

  public GetByIdController(GetPersonByIdUseCase useCase) {
    this.useCase = useCase;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
    useCase.execute(id, this);
    return result;
  }

  @Override
  public void setResponse(Person response) {
    this.result = ResponseEntity.ok().body(PersonViewModel.fromDomain(response));
  }

  @Override
  public void setError(String message) {
    this.result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
  }

  @Override
  public void setNotFound(String message) {
    this.result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
  }
}
