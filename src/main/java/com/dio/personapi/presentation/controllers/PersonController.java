package com.dio.personapi.presentation.controllers;

import com.dio.personapi.application.services.getpersonbyid.GetPersonByIdService;
import com.dio.personapi.application.services.getpersonbyid.input.GetPersonByIdInput;
import com.dio.personapi.application.services.saveperson.SavePersonService;
import com.dio.personapi.application.services.saveperson.input.SavePersonInput;
import com.dio.personapi.application.services.updateperson.UpdatePersonService;
import com.dio.personapi.application.services.updateperson.input.UpdatePersonInput;
import com.dio.personapi.domain.entities.Person;
import com.dio.personapi.presentation.mappers.PersonViewMapper;
import com.dio.personapi.presentation.viewmodel.PersonViewModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  private final UpdatePersonService updatePersonService;
  private final PersonViewMapper personViewMapper;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PersonViewModel findById(@PathVariable Long id) {
    Person person = getPersonByIdService.execute(new GetPersonByIdInput(id));
    return personViewMapper.toViewModel(person);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonViewModel create(@RequestBody SavePersonInput personInput) {
    Person createdPerson = savePersonService.execute(personInput);
    return personViewMapper.toViewModel(createdPerson);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PersonViewModel update(@PathVariable Long id, @RequestBody UpdatePersonInput personInput) {
    personInput.setId(id);
    Person updatedPerson = updatePersonService.execute(personInput);
    return personViewMapper.toViewModel(updatedPerson);
  }
}
