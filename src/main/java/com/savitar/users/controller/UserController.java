package com.savitar.users.controller;

import com.savitar.users.dto.request.UserRequest;
import com.savitar.users.dto.response.UserResponse;
import com.savitar.users.dto.shared.Response;
import com.savitar.users.mappers.UserMapper;
import com.savitar.users.model.User;
import com.savitar.users.model.shared.Transaction;
import com.savitar.users.service.interfaces.UserService;
import com.savitar.users.util.TransactionUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<UserResponse>> postUser(@Validated @RequestBody UserRequest userRequest, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        User userResponse = userService.saveUser(userRequest, transaction);
        log.info("User created with ID: {}", userResponse.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.<UserResponse>builder()
                .data(UserMapper.INSTANCE.toUserResponse(userResponse))
                .message("User Created!")
                .responseKey(HttpStatus.CREATED.value())
                .build());
    }

}
