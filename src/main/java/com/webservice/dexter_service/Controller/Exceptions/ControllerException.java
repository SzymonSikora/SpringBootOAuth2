package com.webservice.dexter_service.Controller.Exceptions;

public class ControllerException extends RuntimeException {
    public ControllerException(String message){
        super(message);
    }
}
