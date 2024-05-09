package com.example.igadvocacia.web.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@ToString
@Getter
public class ErrorMessage {

    private String path;
    private String message;
    private String method;
    private String statusText;
    private int status;
    private Map<String, String> errors;

    public ErrorMessage() {
    }

    public ErrorMessage(HttpServletRequest request, HttpStatus status, String message) {
        this.path = request.getRequestURI();
        this.message = message;
        this.method = request.getMethod();
        this.statusText = status.getReasonPhrase();
        this.status = status.value();
    }

    public ErrorMessage(HttpServletRequest request, HttpStatus status, String message, BindingResult result) {
        this.path = request.getRequestURI();
        this.message = message;
        this.method = request.getMethod();
        this.statusText = status.getReasonPhrase();
        this.status = status.value();
        addError(result);
    }

    private void addError(BindingResult result) {
        this.errors = new HashMap<>();
        for(FieldError error : result.getFieldErrors()){
            this.errors.put(error.getField(), error.getDefaultMessage());
        }
    }
}
