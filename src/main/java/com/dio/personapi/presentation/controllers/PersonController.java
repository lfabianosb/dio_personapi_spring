package com.dio.personapi.presentation.controllers;

import com.dio.personapi.application.services.GetPersonByIdService;
import com.dio.personapi.application.services.SavePersonService;
import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.presentation.mapper.PersonViewMapper;
import com.dio.personapi.presentation.viewmodel.PersonViewModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/people")
@RequiredArgsConstructor
public class PersonController {
  private final GetPersonByIdService getPersonByIdService;
  private final SavePersonService savePersonService;
  private final PersonViewMapper personViewMapper;

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PersonViewModel findById(@PathVariable Long id) {
    Person person = getPersonByIdService.execute(new GetPersonByIdService.Param(id));
    return personViewMapper.toViewModel(person);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonViewModel create(@RequestBody Person personDTO) {
    Person personCreated = savePersonService.execute(new SavePersonService.Param(personDTO));
    return personViewMapper.toViewModel(personCreated);
  }
}
