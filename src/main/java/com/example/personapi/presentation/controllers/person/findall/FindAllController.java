package com.example.personapi.presentation.controllers.person.findall;

import java.util.List;

import com.example.personapi.application.services.person.findall.contracts.FindAllPeopleUseCase;
import com.example.personapi.application.services.person.findall.contracts.FindAllPeoplePresenter;
import com.example.personapi.domain.entities.Person;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindAllController extends PersonControllerBase implements FindAllPeoplePresenter {
  private final FindAllPeopleUseCase useCase;
  private ResponseEntity<?> result;

  public FindAllController(FindAllPeopleUseCase useCase) {
    this.useCase = useCase;
  }

  @GetMapping
  public ResponseEntity<?> findAll() {
    useCase.execute(this);
    return result;
  }

  @Override
  public void setResponse(List<Person> response) {
    this.result = ResponseEntity.ok().body(PersonViewModel.fromDomain(response));
  }

  @Override
  public void setError(String message) {
    this.result = ResponseEntity.badRequest().body(message);
  }
}
