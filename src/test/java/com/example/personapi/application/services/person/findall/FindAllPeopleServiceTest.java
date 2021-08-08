package com.example.personapi.application.services.person.findall;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.findall.contracts.FindAllPeoplePresenter;
import com.example.personapi.application.services.person.findall.contracts.FindAllPeopleUseCase;
import com.example.personapi.domain.entities.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindAllPeopleServiceTest {
  private final PersonRepository repository = mock(PersonRepository.class);
  private final FindAllPeoplePresenter presenter = mock(FindAllPeoplePresenter.class);
  private final List<Person> people = new ArrayList<>(Arrays.asList(
      Person.builder()
        .withId(1L)
        .withFirstName("any_firstname")
        .withLastName("any_lastname")
        .withCpf("11111111111")
        .withBirthDate(LocalDate.now())
        .withPhones(Collections.emptyList())
        .build(),
      Person.builder()
        .withId(2L)
        .withFirstName("any_firstname")
        .withLastName("any_lastname")
        .withCpf("22222222222")
        .withBirthDate(LocalDate.now())
        .withPhones(Collections.emptyList())
        .build()
      ));
  private FindAllPeopleUseCase underTest;

  @BeforeEach
  void setUp() {
    underTest = new FindAllPeopleService(repository);
  }

  @Test
  void shouldPresentAListOfPeopleAsResponse() {
    // given
    when(repository.findAll()).thenReturn(people);
    // when
    underTest.execute(presenter);
    // then
    verify(presenter, times(1)).setResponse(people);
    verify(presenter, times(0)).setError(anyString());
  }

  @Test
  void shouldPresentAnErrorMessage() {
    // given
    when(repository.findAll()).thenThrow(new RuntimeException("any_message"));
    // when
    underTest.execute(presenter);
    // then
    verify(presenter, times(1)).setError("any_message");
    verify(presenter, times(0)).setResponse(anyList());
  }
}
