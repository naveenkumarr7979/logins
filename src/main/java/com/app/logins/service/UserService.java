package com.app.logins.service;

import com.app.logins.dto.CreateUserRequest;
import com.app.logins.dto.UserResponse;

public interface UserService {
    UserResponse createUser(CreateUserRequest dto);
}