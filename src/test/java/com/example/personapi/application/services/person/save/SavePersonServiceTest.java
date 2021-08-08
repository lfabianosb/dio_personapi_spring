package com.example.personapi.application.services.person.save;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import com.example.personapi.application.repositories.PersonRepository;
import com.example.personapi.application.services.person.save.contracts.SavePersonPresenter;
import com.example.personapi.application.services.person.save.contracts.SavePersonUseCase;
import com.example.personapi.application.services.person.save.models.in.SavePersonRequest;
import com.example.personapi.domain.entities.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavePersonServiceTest {
  private SavePersonUseCase underTest;
  private PersonRepository repository = mock(PersonRepository.class);
  private SavePersonPresenter presenter = mock(SavePersonPresenter.class);
  private SavePersonRequest request = 
      SavePersonRequest.builder()
        .withFirstName("any_firstname")
        .withLastName("any_lastName")
        .withCpf("11111111111")
        .withBirthDate("1977-10-08")
        .withPhones(Collections.emptyList())
        .build();
  private Person person = 
      Person.builder()
        .withId(1L)
        .withFirstName(request.getFirstName())
        .withLastName(request.getLastName())
        .withCpf(request.getCpf())
        .withBirthDate(LocalDate.now())
        .withPhones(Collections.emptyList())
        .build();

  @BeforeEach
  void setUp() {
    underTest = new SavePersonService(repository);
  }

  @Test
  void shouldPresentAPersonAsResponse() {
    // given
    when(repository.findByCpf(anyString())).thenReturn(Optional.empty());
    when(repository.create(any())).thenReturn(person);
    // when
    underTest.execute(request, presenter);
    // then
    verify(presenter, times(1)).setResponse(person);
    verify(presenter, times(0)).setError(anyString());
  }

  @Test
  void shouldPresentAnErrorMessage() {
    // given
    when(repository.findByCpf(anyString())).thenReturn(Optional.of(person));
    // when
    underTest.execute(request, presenter);
    // then
    verify(presenter, times(1)).setError("CPF #" + person.getCpf() + " already exists");
    verify(presenter, times(0)).setResponse(any());
    verify(repository, times(0)).create(any());
  }
}
