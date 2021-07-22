package com.example.personapi.presentation.presenters;

import com.example.personapi.application.contracts.presenter.Presenter;
import com.example.personapi.domain.entities.Person;
import com.example.personapi.presentation.models.PersonViewModel;

import org.springframework.stereotype.Component;

@Component
public class PersonPresenter implements Presenter<Person, PersonViewModel> {
  private Person person;

  @Override
  public void setModel(Person entity) {
    this.person = entity;
  }

  @Override
  public PersonViewModel getViewModel() {
    return PersonViewModel.fromDomain(this.person);
  }
  
}
