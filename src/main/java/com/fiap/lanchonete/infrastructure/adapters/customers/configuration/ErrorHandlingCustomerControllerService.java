package com.fiap.lanchonete.infrastructure.adapters.customers.configuration;


import com.fiap.lanchonete.shared.exception.NotFoundException;
import com.fiap.lanchonete.shared.exception.ValidationErrorResponse;
import com.fiap.lanchonete.shared.exception.Violation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
