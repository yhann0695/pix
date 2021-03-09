package br.com.estudo.pix.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	protected ResponseEntity<Object> NotFoundException(NotFoundException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}

    private ResponseEntity<Object> handleExceptionInternal(br.com.estudo.pix.exceptions.NotFoundException ex,
            String message, HttpHeaders httpHeaders, HttpStatus internalServerError, WebRequest request) {
        return null;
    }
}