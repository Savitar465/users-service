package com.savitar.users.service;

import com.savitar.users.constants.StatusEntity;
import com.savitar.users.dao.UserRepository;
import com.savitar.users.dto.request.UserRequest;
import com.savitar.users.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequest userRequest) {
        User user = User.builder()
                .names(userRequest.getNames())
                .lastNames(userRequest.getLastNames())
                .email(userRequest.getEmail())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .birthday(userRequest.getBirthday())
                .status(StatusEntity.ACTIVE.getStatus())
                .build();
        return userRepository.save(user);
    }
    
}
