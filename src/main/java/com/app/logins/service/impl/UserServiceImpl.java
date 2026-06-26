package com.app.logins.service.impl;

import com.app.logins.dto.CreateUserRequest;
import com.app.logins.dto.UserResponse;
import com.app.logins.entity.User;
import com.app.logins.repository.UserRepo;
import com.app.logins.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo,PasswordEncoder passwordEncoder,ModelMapper modelMapper)
    {
        this.userRepo=userRepo;
        this.passwordEncoder=passwordEncoder;
        this.modelMapper=modelMapper;
    }
    @Override
    public UserResponse createUser(CreateUserRequest dto) {
        User existingUser = userRepo.findByEmail(dto.getEmail()).orElse(null);

        if (existingUser != null) {
                //throw new ResourceAlreadyExistsException("Email already registered");
        }
        User user = modelMapper.map(dto,User.class);
        user.setCreatedAt(LocalDateTime.now());
        user.setActive(true);
        user.setRole("Guest");
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        User savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }
}
