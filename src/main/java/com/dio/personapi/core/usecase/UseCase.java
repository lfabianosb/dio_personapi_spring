package com.dio.personapi.core.usecase;

public interface UseCase<Input, Output> {
  Output execute(Input params);
}
