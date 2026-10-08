package com.greenconnect.backend.controller;

import com.greenconnect.backend.auth.EnvironmentalistApplicationService;
import com.greenconnect.backend.auth.dto.EnvironmentalistApplicationResponse;
import com.greenconnect.backend.model.EnvironmentalistApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final EnvironmentalistApplicationService applicationService;

    public AdminController(
            EnvironmentalistApplicationService applicationService
    ) {
        this.applicationService = applicationService;
    }

    @GetMapping("/environmentalist-applications/pending")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public List<EnvironmentalistApplicationResponse> getPendingApplications() {

        List<EnvironmentalistApplication> applications =
                applicationService.getPendingApplications();

        return applications.stream()
                .map(EnvironmentalistApplicationResponse::new)
                .toList();
    }
}