package com.jetrouter.gymservice.security;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    public boolean hasAdminAccess(String id) {
        System.out.println(id);
        return "asdf".equals(id);
    }
}
