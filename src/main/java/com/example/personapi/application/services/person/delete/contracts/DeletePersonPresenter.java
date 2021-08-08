package com.example.personapi.application.services.person.delete.contracts;

public interface DeletePersonPresenter {
  void setResponse();
  void setNotFound(String message);
  void setError(String message);
}
