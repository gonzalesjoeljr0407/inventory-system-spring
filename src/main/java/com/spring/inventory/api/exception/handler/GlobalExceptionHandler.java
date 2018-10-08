package com.spring.inventory.api.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.inventory.api.exception.response.BusinessException;
import com.spring.inventory.api.exception.response.DataException;
import com.spring.inventory.api.model.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(generateErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(DataException.class)
    public ResponseEntity<Object> handleDataException(DataException e) {
        return new ResponseEntity<>(generateErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException e) {
        return new ResponseEntity<>(generateErrorResponse(e.getMessage(), HttpStatus.PRECONDITION_FAILED), HttpStatus.PRECONDITION_FAILED);
    }
    
    private ErrorResponse generateErrorResponse(String errorMessage, HttpStatus httpStatus) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorMessage(errorMessage);
        error.setStatus(httpStatus.value());
        
        return error;
    }
}
