
package com.greenconnect.backend.controller;

import com.greenconnect.backend.auth.EnvironmentalistApplicationService;
import com.greenconnect.backend.auth.dto.EnvironmentalistApplicationResponse;
import com.greenconnect.backend.model.EnvironmentalistApplication;
import com.greenconnect.backend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity<EnvironmentalistApplicationResponse> apply(
            @RequestBody ApplyRequest request,
            Authentication authentication
    ) {
        User user = (User) authentication.getPrincipal();

        EnvironmentalistApplication application =
                applicationService.apply(
                        user.getId(),
                        request.getReason()
                );

        return ResponseEntity.ok(
                new EnvironmentalistApplicationResponse(application)
        );
    }

    public static class ApplyRequest {
        private String reason;

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}
