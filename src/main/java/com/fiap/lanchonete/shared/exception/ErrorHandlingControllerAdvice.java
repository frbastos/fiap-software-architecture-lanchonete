package com.fiap.lanchonete.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fiap.lanchonete.application.orders.exceptions.PaymentRefusedException;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse notFoundException(NotFoundException e) {
		
		ValidationErrorResponse error = new ValidationErrorResponse();
		error.add(new Violation(e.getMessage()));
		
		return error;
	}

	@ExceptionHandler(PaymentRefusedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse paymentRefusedException(PaymentRefusedException e) {
		
		ValidationErrorResponse error = new ValidationErrorResponse();
		error.add(new Violation(e.getMessage()));
		
		return error;
	}
    
}
