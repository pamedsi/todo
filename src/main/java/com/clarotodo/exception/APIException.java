package com.clarotodo.exception;

import org.springframework.http.*;

import java.io.*;

public class APIException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 3493924982910908850L;
    private final HttpStatus httpStatus;
    private final int httpStatusInNumber;

    public APIException(String message, HttpStatus status) {
        super(message);
        httpStatus = status;
        httpStatusInNumber = status.value();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getHttpStatusInNumber() {
        return httpStatusInNumber;
    }
}
