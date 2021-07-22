package com.example.personapi.application.contracts.usecase;

import com.example.personapi.application.contracts.presenter.Presenter;

public interface UseCaseNoRequest<P extends Presenter<?, ?>> {
  void execute(P presenter);
}

