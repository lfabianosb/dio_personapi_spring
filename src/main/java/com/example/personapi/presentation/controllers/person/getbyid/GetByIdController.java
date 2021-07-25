package com.example.personapi.presentation.controllers.person.getbyid;

import com.example.personapi.application.services.person.getbyid.GetPersonByIdService;
import com.example.personapi.application.services.person.getbyid.models.out.GetByIdPersonResponse;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class GetByIdController extends PersonControllerBase {
  private final GetPersonByIdService service;

  public GetByIdController(GetPersonByIdService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PersonViewModel findById(@PathVariable Long id) {
    GetByIdPersonResponse useCaseResponse =  service.execute(id);
    return PersonViewModel.fromDomain(useCaseResponse);
  }
}
