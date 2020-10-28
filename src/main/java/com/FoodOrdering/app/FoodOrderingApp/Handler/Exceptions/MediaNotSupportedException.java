package com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
public class MediaNotSupportedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MediaNotSupportedException(String message){ super(message); }
}
