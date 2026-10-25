package com.greenconnect.backend.auth.dto;

import com.greenconnect.backend.model.User;

public class UserProfileResponse {

    private Long id;
    private String name;
    private String email;
    private String role;

    public UserProfileResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole().name();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
