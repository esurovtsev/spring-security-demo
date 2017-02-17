package com.grabduck.demo.springsecurity.web;

import com.grabduck.demo.springsecurity.domain.User;
import com.grabduck.demo.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class AdminAuthFilter extends GenericFilterBean {
    @Autowired
    private UserService userService;

    private User admin;

    @PostConstruct
    public void init() {
        admin = (User) userService.loadUserByUsername("admin");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(admin));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
