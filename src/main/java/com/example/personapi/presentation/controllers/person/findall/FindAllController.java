package com.example.personapi.presentation.controllers.person.findall;

import java.util.List;

import com.example.personapi.application.services.person.findall.FindAllPeopleService;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.models.PersonViewModel;
import com.example.personapi.presentation.presenters.AllPeoplePresenter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FindAllController extends PersonControllerBase {
  private final AllPeoplePresenter presenter;
  private final FindAllPeopleService service;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<PersonViewModel> findAll() {
    service.execute(presenter);
    return presenter.getViewModel();
  }

}
