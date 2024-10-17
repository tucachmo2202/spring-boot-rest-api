package com.foxifyart.rest_service.service;

import com.foxifyart.rest_service.dto.request.UserCreationRequest;
import com.foxifyart.rest_service.dto.request.UserUpdateRequest;
import com.foxifyart.rest_service.entity.Users;
import com.foxifyart.rest_service.exception.AppException;
import com.foxifyart.rest_service.exception.ErrorCode;
import com.foxifyart.rest_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users createUser(UserCreationRequest request) {
        Users user = new Users();

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Users getUserWithId(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User " + userId + " not found"));
    }

    public Users updateUser(String userId, UserUpdateRequest userInfo) {
        Users user = this.getUserWithId(userId);
        user.setPassword(userInfo.getPassword());
        user.setUsername(userInfo.getUsername());

        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
