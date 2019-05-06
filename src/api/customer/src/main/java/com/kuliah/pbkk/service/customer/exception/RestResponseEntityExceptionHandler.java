package com.kuliah.pbkk.service.customer.exception;

import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = {NoSuchElementException.class, EmptyResultDataAccessException.class})
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
    	String body = "The resources you requested can't be found";
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    
    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
    	String body = "Just bad request :/";
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
