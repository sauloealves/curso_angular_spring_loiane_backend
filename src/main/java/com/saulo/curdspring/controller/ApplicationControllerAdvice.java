package com.saulo.curdspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.saulo.curdspring.exception.RecordNotFoundException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationControllerAdvice {
    @ExceptionHandler(RecordNotFoundException.class)
    public String handleNotFoundException(RecordNotFoundException ex){
        return ex.getMessage();
    }
}
