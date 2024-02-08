package com.sist.reserva.controller.handleEx;

public class ObjetoNotFoundException extends RuntimeException {

  public ObjetoNotFoundException(String message) {
    super(message);
  }

  public ObjetoNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
