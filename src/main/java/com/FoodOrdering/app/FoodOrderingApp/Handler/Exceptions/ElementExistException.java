package com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.IM_USED)
public class ElementExistException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ElementExistException(String message) {
        super(message);
    }
}
