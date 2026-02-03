package com.kalam.patientservice.exception;

public class PatinetNotFoundException extends RuntimeException {
    public PatinetNotFoundException(String message) {
        super(message);
    }
}
