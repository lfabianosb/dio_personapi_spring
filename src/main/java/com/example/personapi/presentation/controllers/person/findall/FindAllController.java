package com.example.personapi.presentation.controllers.person.findall;

import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.application.services.person.findall.contracts.FindAllPeopleUseCase;
import com.example.personapi.application.services.person.findall.models.out.FindAllPeolpleRespnose;
import com.example.personapi.presentation.controllers.person.PersonControllerBase;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindAllController extends PersonControllerBase {
  private final FindAllPeopleUseCase useCase;

  public FindAllController(FindAllPeopleUseCase useCase) {
    this.useCase = useCase;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<PersonViewModel> findAll() {
    List<FindAllPeolpleRespnose> useCaseResponse = useCase.execute();
    return useCaseResponse.stream().map(person -> PersonViewModel.fromDomain(person)).collect(Collectors.toList());
  }

}
