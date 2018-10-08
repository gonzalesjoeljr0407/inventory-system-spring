package com.spring.inventory.api.exception.response;

import com.spring.inventory.api.exception.BaseException;

public class BusinessException extends BaseException {
    
    private static final long serialVersionUID = 12345123213L;
    
    public BusinessException(String errorCode, String message, String developerMessage) {
        super(errorCode, message, developerMessage);
    }
}
