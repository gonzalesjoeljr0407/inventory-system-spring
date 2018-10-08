package com.spring.inventory.api.exception;

public class BaseException extends RuntimeException {
    
    private static final long serialVersionUID = 12345123213L;
    private String errorCode;
    private String message;
    private String developerMessage;
    
    public BaseException(String errorCode, String message, String developerMessage) {
        this.errorCode = errorCode;
        this.message = message;
        this.developerMessage = developerMessage;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getDeveloperMessage() {
        return developerMessage;
    }
    
    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}
