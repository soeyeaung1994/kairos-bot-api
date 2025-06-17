package com.bank.kairos.security;

import com.bank.kairos.service.UserMockService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:14 pm
 */
@Component
public class AuthenticatedUserFilter extends OncePerRequestFilter {
    private final UserMockService userMockService;

    public AuthenticatedUserFilter(UserMockService userMockService) {
        this.userMockService = userMockService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String userId = request.getHeader("X-User-Id");
        userMockService.getUser(userId).ifPresent(user -> request.setAttribute("authenticatedUser", user));
        filterChain.doFilter(request, response);
    }
}
