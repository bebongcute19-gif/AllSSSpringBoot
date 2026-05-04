package com.example.session14.validator;

public class BadCredentialsExceptionCustom extends RuntimeException {
    public BadCredentialsExceptionCustom(String message) {
        super(message);
    }
}