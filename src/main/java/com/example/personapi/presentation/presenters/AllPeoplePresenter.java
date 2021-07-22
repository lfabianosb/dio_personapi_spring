package com.example.personapi.presentation.presenters;

import java.util.List;
import java.util.stream.Collectors;

import com.example.personapi.application.contracts.presenter.Presenter;
import com.example.personapi.domain.entities.Person;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.stereotype.Component;

@Component
public class AllPeoplePresenter implements Presenter<List<Person>, List<PersonViewModel>> {
  private List<Person> person;

  @Override
  public void setModel(List<Person> model) {
    this.person = model;
  }

  @Override
  public List<PersonViewModel> getViewModel() {
    return this.person.stream().map(person -> PersonViewModel.fromDomain(person)).collect(Collectors.toList());
  }  
}
