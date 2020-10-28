package com.FoodOrdering.app.FoodOrderingApp.Handler;

import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ActionErrorException;
import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementExistException;
import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementNotFoundException;
import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.MediaNotSupportedException;
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

    @ExceptionHandler(ActionErrorException.class)
    public final ResponseEntity<ErrorResponse> handleActionErrorException(ActionErrorException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MediaNotSupportedException.class)
    public final ResponseEntity<ErrorResponse> handleMediaNotSupportedException(MediaNotSupportedException ex, WebRequest request){
        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
        return new ResponseEntity<>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
}
