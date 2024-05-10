package com.example.igadvocacia.exeption;

public class UserUniqueViolation extends RuntimeException {

    public UserUniqueViolation(String message) {
        super(message);
    }
}
