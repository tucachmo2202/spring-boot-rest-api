package com.foxifyart.rest_service.controller;

import com.foxifyart.rest_service.dto.request.ApiResponse;
import com.foxifyart.rest_service.dto.request.UserCreationRequest;
import com.foxifyart.rest_service.dto.request.UserUpdateRequest;
import com.foxifyart.rest_service.entity.Users;
import com.foxifyart.rest_service.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<Users> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<Users> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        apiResponse.setCode(200);
        apiResponse.setMessage("");
        return apiResponse;
    }

    @GetMapping
    List<Users> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    Users getUser(@PathVariable("userId") String userId){
        return userService.getUserWithId(userId);
    }

    @PatchMapping("/{userId}")
    Users updateUser(@RequestBody UserUpdateRequest request, @PathVariable("userId") String userId) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
    }
}