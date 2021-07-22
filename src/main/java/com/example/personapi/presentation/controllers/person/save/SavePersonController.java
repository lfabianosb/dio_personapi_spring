package com.example.personapi.presentation.controllers.person.save;

import com.example.personapi.application.services.person.save.SavePersonService;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.models.PersonViewModel;
import com.example.personapi.presentation.presenters.PersonPresenter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SavePersonController extends PersonControllerBase {
  private final PersonPresenter presenter;
  private final SavePersonService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonViewModel create(@RequestBody SavePersonInput personInput) {
    service.execute(personInput.toRequestModel(), presenter);
    return presenter.getViewModel();
  }
}
