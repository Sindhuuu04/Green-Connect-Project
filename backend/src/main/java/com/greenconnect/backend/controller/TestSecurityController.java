package com.greenconnect.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

    @GetMapping("/api/test/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "USER access granted";
    }

    @GetMapping("/api/test/environmentalist")
    @PreAuthorize("hasRole('ENVIRONMENTALIST')")
    public String environmentalistAccess() {
        return "ENVIRONMENTALIST access granted";
    }

    @GetMapping("/api/test/admin")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public String adminAccess() {
        return "SUPER_ADMIN access granted";
    }
}