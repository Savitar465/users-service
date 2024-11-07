package com.savitar.users.service.interfaces;

import com.savitar.users.dto.request.UserRequest;
import com.savitar.users.model.User;
import com.savitar.users.model.shared.Transaction;

public interface UserService {

    /**
     * Save a user
     * @param userRequest User request with user data to save
     * @param transaction Transaction data for audit
     * @return User saved
     */
    User saveUser(UserRequest userRequest, Transaction transaction);
}
