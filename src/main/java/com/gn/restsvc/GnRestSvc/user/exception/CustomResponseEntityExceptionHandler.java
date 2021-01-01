package com.gn.restsvc.GnRestSvc.user.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResponse = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
		return new ResponseEntity<Object>(expResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResponse = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(), request.getDescription(false));
		return new ResponseEntity<Object>(expResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse expResponse = new ExceptionResponse("Validation failed", LocalDateTime.now(),
				ex.getBindingResult().toString());
		return new ResponseEntity<Object>(expResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	

}
