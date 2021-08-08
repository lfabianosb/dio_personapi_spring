package com.example.personapi.application.services.person.delete;

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
import com.example.personapi.application.services.person.delete.contracts.DeletePersonPresenter;
import com.example.personapi.application.services.person.delete.contracts.DeletePersonUseCase;
import com.example.personapi.domain.entities.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeletePersonServiceTest {
  private DeletePersonUseCase underTest;
  private final PersonRepository repository = mock(PersonRepository.class);
  private final DeletePersonPresenter presenter = mock(DeletePersonPresenter.class);
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
    underTest = new DeletePersonService(repository);
  }

  @Test
  void shouldPresentAResponse() {
    // given
    final Long id = 1L;
    when(repository.findById(id)).thenReturn(Optional.of(person));
    // when
    underTest.execute(id, presenter);
    // then
    verify(presenter, times(1)).setResponse();
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
    verify(presenter, times(0)).setResponse();
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
    verify(presenter, times(0)).setResponse();
  }
}
