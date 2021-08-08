package com.example.personapi.application.services.person.update;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.update.contracts.UpdatePersonPresenter;
import com.example.personapi.application.services.person.update.contracts.UpdatePersonUseCase;
import com.example.personapi.application.services.person.update.models.in.UpdatePersonRequest;
import com.example.personapi.domain.entities.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdatePersonServiceTest {
  private final PersonRepository repository = mock(PersonRepository.class);
  private final UpdatePersonPresenter presenter = mock(UpdatePersonPresenter.class);
  private final UpdatePersonRequest request = 
      UpdatePersonRequest.builder()
        .withFirstName("any_firstname")
        .withLastName("any_lastName")
        .withCpf("11111111111")
        .withBirthDate("1977-10-08")
        .withPhones(Collections.emptyList())
        .build();
  private final Person person = 
      Person.builder()
        .withId(1L)
        .withFirstName(request.getFirstName())
        .withLastName(request.getLastName())
        .withCpf(request.getCpf())
        .withBirthDate(LocalDate.now())
        .withPhones(Collections.emptyList())
        .build();
  private UpdatePersonUseCase underTest;

  @BeforeEach
  void setUp() {
    underTest = new UpdatePersonService(repository);
  }

  @Test
  void shouldPresentAPersonAsResponse() {
    // given
    when(repository.findById(person.getId())).thenReturn(Optional.of(person));
    when(repository.update(any())).thenReturn(person);
    // when
    underTest.execute(person.getId(), request, presenter);
    // then
    verify(presenter, times(1)).setResponse(person);
    verify(presenter, times(0)).setError(anyString());
  }

  @Test
  void shouldPresentAnErrorMessage() {
    // given
    when(repository.findById(person.getId())).thenReturn(Optional.empty());
    // when
    underTest.execute(person.getId(), request, presenter);
    // then
    verify(presenter, times(1)).setError("Person #" + person.getId() + " not found");
    verify(presenter, times(0)).setResponse(person);
    verify(repository, times(0)).update(any());
  }
}
