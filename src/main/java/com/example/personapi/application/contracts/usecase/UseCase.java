package com.example.personapi.application.contracts.usecase;

import com.example.personapi.application.contracts.presenter.Presenter;

public interface UseCase<Request, P extends Presenter<?, ?>> {
  void execute(Request request, P presenter);
}
