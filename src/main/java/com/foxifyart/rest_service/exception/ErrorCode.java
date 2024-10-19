package com.foxifyart.rest_service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorize exception error"),
    INVALID_USERNAME(1002, "Username must be more than 3 characters"),
    INVALID_PASSWORD(1003, "Password must be more than 8 characters"),
    USER_NOT_EXISTED(1004, "User not exist"),
    USER_EXISTED(1001, "User existed"),
    UNAUTHENTICATED(1005, "Unauthenticated"),

    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
