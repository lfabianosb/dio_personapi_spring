package com.example.personapi.application.services.person.findall.contracts;

import java.util.List;

import com.example.personapi.application.services.person.findall.models.out.FindAllPeolpleRespnose;

public interface FindAllPeopleUseCase {
  List<FindAllPeolpleRespnose> execute();
}
