package com.example.personapi.presentation.controllers.person.getbyid;

import com.example.personapi.application.services.person.getbyid.GetPersonByIdService;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.models.PersonViewModel;
import com.example.personapi.presentation.presenters.PersonPresenter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class GetByIdController extends PersonControllerBase {
  private final PersonPresenter presenter;
  private final GetPersonByIdService service;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PersonViewModel findById(@PathVariable Long id) {
    service.execute(new GetPersonByIdService.GetPersonByIdRequest(id), presenter);
    return presenter.getViewModel();
  }

}
