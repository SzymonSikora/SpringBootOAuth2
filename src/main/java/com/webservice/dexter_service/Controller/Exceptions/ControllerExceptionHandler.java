package com.webservice.dexter_service.Controller.Exceptions;

import java.util.Date;

import com.webservice.dexter_service.Common.BaseException.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ControllerException.class)
	public ResponseEntity<ExceptionResponse> handlerLoginException(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				ex.getStackTrace()[0].toString(), request.getDescription(true));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.UNAUTHORIZED);
	}
}
