package com.foxifyart.rest_service.mapper;


import com.foxifyart.rest_service.dto.request.UserCreationRequest;
import com.foxifyart.rest_service.dto.request.UserUpdateRequest;
import com.foxifyart.rest_service.dto.response.UserResponse;
import com.foxifyart.rest_service.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toUser(UserCreationRequest request);
    UserResponse toUserResponse(Users user);
    void updateUser(@MappingTarget Users user, UserUpdateRequest request);
}
