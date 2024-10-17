package com.foxifyart.rest_service.dto.request;

import jakarta.validation.constraints.Size;

public class UserUpdateRequest {

    @Size(min = 3, message = "Username must be at least 3 characters")
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
