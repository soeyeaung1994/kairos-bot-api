package com.bank.kairos.service;

import com.bank.kairos.dto.User;

import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 17/6/25
 * @Time: 4:27 pm
 */
public interface AuthService {
    Optional<User> getUser(String email);
}
