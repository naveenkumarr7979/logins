package com.app.logins.controller;
import com.app.logins.common.ApiResponse;
import com.app.logins.dto.CreateUserRequest;
import com.app.logins.dto.UserResponse;
import com.app.logins.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class MainController {
    private static  final Logger logger= LoggerFactory.getLogger(MainController.class);
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody CreateUserRequest dto) {
        logger.info("Received request to create user with email: {}", dto.getEmail());
        UserResponse user = userService.createUser(dto);
        logger.info("User created successfully with email: {}", dto.getEmail());
        ApiResponse<UserResponse>resp=new ApiResponse<>();
        resp.setMessage("Uer created successfully");
        resp.setSuccess(true);
        resp.setData(user);
        return resp;
    }
}
