package com.dio.personapi.presentation.exceptionhandler;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.dio.personapi.application.exceptions.PersonNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PersonNotFoundException.class)
  public void handleNotFound(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.NOT_FOUND.value());
  }

  // @ExceptionHandler(PersonNotFoundException.class)
  // protected ResponseEntity<Object> handleNotFound(PersonNotFoundException ex) {
  //   ApiError apiError = new ApiError(NOT_FOUND);
  //   apiError.setMessage(ex.getMessage());
  //   return buildResponseEntity();
  // }
}
