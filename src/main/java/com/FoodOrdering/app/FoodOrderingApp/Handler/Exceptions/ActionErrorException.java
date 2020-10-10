package com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ActionErrorException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ActionErrorException(String message) {
        super(message);
    }
}
