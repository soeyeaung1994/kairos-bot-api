package com.bank.kairos.service.impl;

import com.bank.kairos.dto.User;
import com.bank.kairos.enums.AccessRole;
import com.bank.kairos.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: Soe Ye Aung
 * @Date: 17/6/25
 * @Time: 4:28 pm
 */

@Service
public class AuthServiceImpl implements AuthService {

    private final Map<String, User> whiteListedUsers = new HashMap<>();
    private final List<String> whiteListedCreators = new ArrayList<>();

    public AuthServiceImpl() {
        whiteListedUsers.put("soeye@gmail.com", User.builder().id(1L).displayedName("Soe Ye").username("soeye").email("soeye@gmail.com").tenants(Arrays.asList("SG", "HK")).accessRole(AccessRole.CREATOR ).build());
        whiteListedUsers.put("sooqing@gmail.com", User.builder().id(2L).displayedName("Soo Qing").username("sooqing").email("sooqing@gmail.com").tenants(Arrays.asList("AU")).accessRole(AccessRole.CREATOR ).build());
        whiteListedUsers.put("surya@gmail.com", User.builder().id(3L).displayedName("Surya").username("surya").email("surya@gmail.com").tenants(Arrays.asList("AU")).accessRole(AccessRole.VIEWER).build());
        whiteListedUsers.put("thomas@gmail.com", User.builder().id(4L).accessRole(AccessRole.UNAUTHORIZED_USER).build());
    }

    @Override
    public Optional<User> getUser(String email) {

        if(whiteListedUsers.containsKey(email)){
            User user = whiteListedUsers.get(email);
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
