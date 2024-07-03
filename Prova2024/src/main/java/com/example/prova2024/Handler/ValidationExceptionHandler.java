package com.example.prova2024.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)

    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    Map<String, String> errors = new HashMap<>();
    for (FieldError error : result.getFieldErrors()) {
        errors.put(error.getField(), error.getDefaultMessage());
    }
    return ResponseEntity.badRequest().body(errors);
}
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity <String> handleValidationExceptions(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
