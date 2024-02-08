package com.sist.reserva.controller.handleEx;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SistReservasExceptionHandler {

  @ExceptionHandler(ObjetoNotFoundException.class)
  public ResponseEntity<Object> handlerObjetoNotFoundException(
      ObjetoNotFoundException notFoundException) {

    SistReservasException sistReservasException = new SistReservasException(
        notFoundException.getMessage(), notFoundException.getCause(), HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(sistReservasException, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ObjetoNoContentException.class)
  public ResponseEntity<Object> handlerObjetoNoContentException(ObjetoNoContentException noContentException) {
    SistReservasException sistReservasException = new SistReservasException(
            noContentException.getMessage(), noContentException.getCause(), HttpStatus.NO_CONTENT);
    return new ResponseEntity<>(sistReservasException, HttpStatus.NO_CONTENT);
  }
}
