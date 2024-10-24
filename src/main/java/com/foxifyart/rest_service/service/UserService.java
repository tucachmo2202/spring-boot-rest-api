package com.foxifyart.rest_service.service;

import com.foxifyart.rest_service.dto.request.UserCreationRequest;
import com.foxifyart.rest_service.dto.request.UserUpdateRequest;
import com.foxifyart.rest_service.dto.response.UserResponse;
import com.foxifyart.rest_service.entity.Users;
import com.foxifyart.rest_service.exception.AppException;
import com.foxifyart.rest_service.exception.ErrorCode;
import com.foxifyart.rest_service.mapper.UserMapper;
import com.foxifyart.rest_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public Users createUser(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        Users user = userMapper.toUser(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

//        HashSet<String> roles = new HashSet<>();
//        roles.add(Role.USER.name());
//        user.setRoles(roles);

        return userRepository.save(user);
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Users getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User " + userId + " not found"));
    }

    public UserResponse getUserWithId(String userId) {
        return userMapper.toUserResponse(getUser(userId));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest userInfo) {
        Users user = getUser(userId);

        userMapper.updateUser(user, userInfo);

        Users userUpdated = userRepository.save(user);

        return userMapper.toUserResponse(userUpdated);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
