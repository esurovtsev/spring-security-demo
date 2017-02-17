package com.grabduck.demo.springsecurity.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, POWER_USER, USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
