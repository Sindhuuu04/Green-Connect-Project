package com.greenconnect.backend.controller;

import com.greenconnect.backend.auth.EnvironmentalistApplicationService;
import com.greenconnect.backend.model.EnvironmentalistApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/environmentalist-applications")
public class EnvironmentalistApplicationController {

    private final EnvironmentalistApplicationService applicationService;

    public EnvironmentalistApplicationController(
            EnvironmentalistApplicationService applicationService
    ) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<EnvironmentalistApplication> apply(
            @RequestParam Long userId,
            @RequestParam String reason
    ) {
        EnvironmentalistApplication application =
                applicationService.apply(userId, reason);

        return ResponseEntity.ok(application);
    }
}