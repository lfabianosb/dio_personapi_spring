package com.dio.personapi.application.services.deletepersonbyid;

import com.dio.personapi.application.exceptions.PersonNotFoundException;
import com.dio.personapi.application.repositories.PersonRepository;
import com.dio.personapi.application.services.deletepersonbyid.input.DeletePersonByIdInput;
import com.dio.personapi.core.usecase.UseCase;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeletePersonByIdService implements UseCase<DeletePersonByIdInput, Void> {
  private final PersonRepository personRepository;

  @Override
  public Void execute(DeletePersonByIdInput input) throws PersonNotFoundException {
    personRepository.delete(input.getId());
    return null;
  }
}
