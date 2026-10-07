package com.greenconnect.backend.auth.dto;

import com.greenconnect.backend.model.EnvironmentalistApplication;

public class EnvironmentalistApplicationResponse {

    private Long id;
    private Long userId;
    private String userName;
    private String userEmail;
    private String reason;
    private String status;

    public EnvironmentalistApplicationResponse(
            EnvironmentalistApplication application
    ) {
        this.id = application.getId();
        this.userId = application.getUser().getId();
        this.userName = application.getUser().getName();
        this.userEmail = application.getUser().getEmail();
        this.reason = application.getReason();
        this.status = application.getStatus().name();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }
}