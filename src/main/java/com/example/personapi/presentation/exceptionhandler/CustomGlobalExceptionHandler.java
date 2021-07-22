package com.example.personapi.presentation.exceptionhandler;

import java.io.IOException;

import com.example.personapi.application.exceptions.CpfAlreadyExistsException;
import com.example.personapi.application.exceptions.PersonNotFoundException;
import com.example.personapi.application.exceptions.ValidationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PersonNotFoundException.class)
  protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) throws IOException {
    return handleExceptionInternal(ex, "Person not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler(CpfAlreadyExistsException.class)
  protected ResponseEntity<Object> handleAlreadSaved(RuntimeException ex, WebRequest request) throws IOException {
    return handleExceptionInternal(ex, "CPF already exists", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(ValidationException.class)
  protected ResponseEntity<Object> handleValidation(RuntimeException ex, WebRequest request) throws IOException {
    return handleExceptionInternal(ex, "Validation error", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
}
