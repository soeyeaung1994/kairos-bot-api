package com.bank.kairos.service;

import com.bank.kairos.entity.User;

import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:11 pm
 */
public interface UserMockService {
    Optional<User> getUser(String userId);
}
