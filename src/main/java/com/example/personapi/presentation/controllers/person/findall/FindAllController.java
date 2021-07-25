package com.example.personapi.presentation.controllers.person.findall;

import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.application.services.person.findall.FindAllPeopleService;
import com.example.personapi.application.services.person.findall.models.out.FindAllPeolpleRespnose;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindAllController extends PersonControllerBase {
  private final FindAllPeopleService service;

  public FindAllController(FindAllPeopleService service) {
    this.service = service;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<PersonViewModel> findAll() {
    List<FindAllPeolpleRespnose> useCaseResponse = service.execute();
    return useCaseResponse.stream().map(person -> PersonViewModel.fromDomain(person)).collect(Collectors.toList());
  }

}
