package com.example.personapi.application.services.person.getbyid;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.getbyid.contracts.GetPersonByIdPresenter;
import com.example.personapi.application.services.person.getbyid.contracts.GetPersonByIdUseCase;
import com.example.personapi.domain.entities.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetPersonByIdServiceTest {
  private GetPersonByIdUseCase underTest;
  private final PersonRepository repository = mock(PersonRepository.class);
  private final GetPersonByIdPresenter presenter = mock(GetPersonByIdPresenter.class);
  private final Person person = Person.builder()
                  .withId(1L)
                  .withFirstName("any_firstname")
                  .withLastName("any_lastname")
                  .withCpf("11111111111")
                  .withBirthDate(LocalDate.now())
                  .withPhones(Collections.emptyList())
                  .build();

  @BeforeEach
  void seUp() {
    underTest = new GetPersonByIdService(repository);
  }

  @Test
  void shouldPresentAPersonAsResponse() {
    // given
    final Long id = 1L;
    when(repository.findById(id)).thenReturn(Optional.of(person));
    // when
    underTest.execute(id, presenter);
    // then
    verify(presenter, times(1)).setResponse(person);
    verify(presenter, times(0)).setError(anyString());
    verify(presenter, times(0)).setNotFound(anyString());
  }

  @Test
  void shouldPresentANotFoundMessage() {
    // given
    final Long id = 1L;
    when(repository.findById(id)).thenReturn(Optional.empty());
    // when
    underTest.execute(id, presenter);
    // then
    verify(presenter, times(1)).setNotFound("Person ID " + id + " not found");
    verify(presenter, times(0)).setResponse(any());
    verify(presenter, times(0)).setError(anyString());
  }

  @Test
  void shouldPresentAnErrorMessage() {
    // given
    when(repository.findById(anyLong())).thenThrow(new RuntimeException("any_message"));
    // when
    underTest.execute(1L, presenter);
    // then
    verify(presenter, times(1)).setError("any_message");
    verify(presenter, times(0)).setNotFound(anyString());
    verify(presenter, times(0)).setResponse(any());
  }
}
