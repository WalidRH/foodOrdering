package com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions;

public class ElementExistException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ElementExistException(String message) {
        super(message);
    }
}
