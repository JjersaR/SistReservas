package com.sist.reserva.controller.handleEx;

public class ObjetoNoContentException extends RuntimeException{
    public ObjetoNoContentException(String message) {
        super(message);
    }

    public ObjetoNoContentException(String message, Throwable cause) {
        super(message, cause);
    }
}
