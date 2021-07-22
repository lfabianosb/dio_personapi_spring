package com.example.personapi.presentation.controllers.person.update;

import com.example.personapi.application.services.person.update.UpdatePersonService;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.models.PersonViewModel;
import com.example.personapi.presentation.presenters.PersonPresenter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UpdatePersonController extends PersonControllerBase {
  private final PersonPresenter presenter;
  private final UpdatePersonService service;

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PersonViewModel update(@PathVariable Long id, @RequestBody UpdatePersonInput personInput) {
    service.execute(personInput.toRequestModel(), presenter);
    return presenter.getViewModel();
  }
}
