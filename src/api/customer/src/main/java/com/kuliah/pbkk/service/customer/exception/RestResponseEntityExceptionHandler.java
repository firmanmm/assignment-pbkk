package com.kuliah.pbkk.service.customer.exception;

import java.util.HashMap;
import java.util.Map;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = {NoSuchElementException.class, EmptyResultDataAccessException.class})
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
    	Map<String, Object> data = new HashMap<String, Object>();
    	data.put("message", "Data Not found!");
        return handleExceptionInternal(ex, convertToJSON(data), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    
    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> handleConstraintViolation(RuntimeException ex, WebRequest request) {
    	Map<String, Object> data = new HashMap<String, Object>();
    	data.put("message", "Validation via database failed, missing required parameters");
        return handleExceptionInternal(ex, convertToJSON(data), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
    @ExceptionHandler(value = {BadRequestException.class})
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
    	Map<String, Object> data = new HashMap<String, Object>();
    	data.put("message", "Validation failed : " + ex.getMessage());
        return handleExceptionInternal(ex, convertToJSON(data), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
    
    
    private String convertToJSON(Object data) {
    	String body = "";
    	try {
			body = new ObjectMapper().writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return body;
    }
}
