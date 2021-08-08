package com.example.personapi.presentation.controllers.person.delete;

import com.example.personapi.application.services.person.delete.contracts.DeletePersonPresenter;
import com.example.personapi.application.services.person.delete.contracts.DeletePersonUseCase;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class DeleteController extends PersonControllerBase implements DeletePersonPresenter {
  private final DeletePersonUseCase useCase;
  private ResponseEntity<?> result;

  public DeleteController(DeletePersonUseCase useCase) {
    this.useCase = useCase;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    useCase.execute(id, this);
    return result;
  }

  @Override
  public void setResponse() {
    this.result = ResponseEntity.noContent().build();
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
