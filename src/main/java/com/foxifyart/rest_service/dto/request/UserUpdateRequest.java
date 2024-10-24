package com.foxifyart.rest_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

    @Size(min = 3, message = "Username must be at least 3 characters")
    String username;
    String password;
}
