package com.greenconnect.backend.controller;

import com.greenconnect.backend.auth.EnvironmentalistApplicationService;
import com.greenconnect.backend.auth.dto.EnvironmentalistApplicationResponse;
import com.greenconnect.backend.model.EnvironmentalistApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @PostMapping("/environmentalist-applications/{id}/approve")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public EnvironmentalistApplicationResponse approveApplication(
            @PathVariable Long id) {
        return applicationService.approveApplication(id);
    }

    @PostMapping("/environmentalist-applications/{id}/reject")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public EnvironmentalistApplicationResponse rejectApplication(
            @PathVariable Long id) {
        return applicationService.rejectApplication(id);
    }

}