package com.FoodOrdering.app.FoodOrderingApp.Handler;

import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementExistException;
import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementNotFoundException;
import com.FoodOrdering.app.FoodOrderingApp.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String ALREADY_EXIST = "ALREADY_EXIST";

    @ExceptionHandler(ElementNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(ElementNotFoundException ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ElementExistException.class)
    public final ResponseEntity<ErrorResponse> handleUserExistException(ElementExistException ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
