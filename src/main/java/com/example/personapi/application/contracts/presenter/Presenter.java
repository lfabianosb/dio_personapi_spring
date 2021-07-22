package com.example.personapi.application.contracts.presenter;

public interface Presenter<M, VM> {
  void setModel(M model);
  VM getViewModel();
}
