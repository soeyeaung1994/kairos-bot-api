package com.bank.kairos.controller;

import com.bank.kairos.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 4:42 pm
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/user")
    public User getUser(HttpServletRequest request) {
        return (User) request.getAttribute("authenticatedUser");
    }
}
