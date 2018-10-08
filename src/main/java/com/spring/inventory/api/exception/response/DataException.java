package com.spring.inventory.api.exception.response;

import com.spring.inventory.api.exception.BaseException;

public class DataException extends BaseException {
    
    private static final long serialVersionUID = 12345123213L;
    
    public DataException(String errorCode, String message, String developerMessage) {
        super(errorCode, message, developerMessage);
    }
}
