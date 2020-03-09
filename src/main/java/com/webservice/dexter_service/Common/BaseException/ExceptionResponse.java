package com.webservice.dexter_service.Common.BaseException;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String stackTrace;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String stackTrace, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.stackTrace = stackTrace;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

