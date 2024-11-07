package com.savitar.users.service.implementation;

import com.savitar.users.constants.StatusEntity;
import com.savitar.users.dao.UserRepository;
import com.savitar.users.dto.request.UserRequest;
import com.savitar.users.model.User;
import com.savitar.users.model.shared.Transaction;
import com.savitar.users.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(UserRequest userRequest, Transaction transaction) {
        User user = User.builder()
                .names(userRequest.getNames())
                .lastNames(userRequest.getLastNames())
                .email(userRequest.getEmail())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .birthday(userRequest.getBirthday())
                .status(StatusEntity.ACTIVE.getStatus())
                .creator(transaction.getTrUsuarioId())
                .createdAt(transaction.getTrFecha())
                .updater(transaction.getTrUsuarioId())
                .updatedAt(transaction.getTrFecha())
                .build();
        return userRepository.save(user);
    }
    
}
