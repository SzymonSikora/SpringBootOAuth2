package com.webservice.dexter_service.Model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ValidateException extends RuntimeException {
    public ValidateException(String message) {
        super(message);
    }
}
