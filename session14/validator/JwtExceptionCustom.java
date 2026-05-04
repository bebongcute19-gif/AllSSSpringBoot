package com.example.session14.validator;

public class JwtExceptionCustom extends RuntimeException {
    public JwtExceptionCustom(String message) {
        super(message);
    }
}
