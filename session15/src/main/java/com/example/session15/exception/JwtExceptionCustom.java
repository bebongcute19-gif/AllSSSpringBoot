package com.example.session15.exception;

public class JwtExceptionCustom extends RuntimeException {
    public JwtExceptionCustom(String message) {
        super(message);
    }
}
