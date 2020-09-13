package com.FoodOrdering.app.FoodOrderingApp.Handler;

import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementNotFoundException;
import com.FoodOrdering.app.FoodOrderingApp.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    @ExceptionHandler(ElementNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException
            (ElementNotFoundException ex, WebRequest request)
    {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(INCORRECT_REQUEST, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
