package com.fiap.lanchonete.infrastructure.customers.configuration;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fiap.lanchonete.shared.exception.NotFoundException;
import com.fiap.lanchonete.shared.exception.ValidationErrorResponse;
import com.fiap.lanchonete.shared.exception.Violation;

@ControllerAdvice
public class ErrorHandlingCustomerControllerService {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse notFoundException(NotFoundException e) {

        ValidationErrorResponse error = new ValidationErrorResponse();
        error.add(new Violation());

        return error;
    }
}
