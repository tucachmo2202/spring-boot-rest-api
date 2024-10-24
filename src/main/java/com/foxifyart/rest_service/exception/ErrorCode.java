package com.foxifyart.rest_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorize exception error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_USERNAME(1002, "Username must be more than 3 characters", HttpStatus.BAD_GATEWAY),
    INVALID_PASSWORD(1003, "Password must be more than 8 characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1004, "User not exist", HttpStatus.NOT_FOUND),
    USER_EXISTED(1001, "User existed", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1005, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1006, "You do not have permission", HttpStatus.UNAUTHORIZED),
    ;
    private int code;
    private String message;
    private HttpStatusCode statusCode;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
