package com.foxifyart.rest_service.mapper;


import com.foxifyart.rest_service.dto.request.PermissionRequest;
import com.foxifyart.rest_service.dto.response.PermissionResponse;
import com.foxifyart.rest_service.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
