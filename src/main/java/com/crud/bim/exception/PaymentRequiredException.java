package com.crud.bim.exception;

public class PaymentRequiredException extends RuntimeException {
    public PaymentRequiredException(String message) {
        super(message);
    }
}
