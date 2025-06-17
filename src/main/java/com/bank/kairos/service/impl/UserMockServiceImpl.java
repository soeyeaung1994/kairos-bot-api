package com.bank.kairos.service.impl;

import com.bank.kairos.entity.User;
import com.bank.kairos.service.UserMockService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:09 pm
 */
@Service
public class UserMockServiceImpl implements UserMockService {
    private final Map<String, User> mockUsers = Map.of(
            "john", new User("user01", "john", "SG", List.of("CREATOR")),
            "kate", new User("user02", "kate", "HK", List.of("VIEWER"))
    );

    @Override
    public Optional<User> getUser(String userId) {
        return Optional.ofNullable(mockUsers.get(userId));
    }
}
