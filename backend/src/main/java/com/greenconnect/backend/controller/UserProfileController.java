
package com.greenconnect.backend.controller;

import com.greenconnect.backend.auth.UserProfileService;
import com.greenconnect.backend.auth.dto.UpdateProfileRequest;
import com.greenconnect.backend.auth.dto.UserProfileResponse;
import com.greenconnect.backend.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/me")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public ResponseEntity<UserProfileResponse> getProfile(
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        UserProfileResponse response =
                userProfileService.getProfile(user.getId());

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<UserProfileResponse> updateProfile(
            @Valid @RequestBody UpdateProfileRequest request,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        UserProfileResponse response =
                userProfileService.updateProfile(
                        user.getId(),
                        request.getName()
                );

        return ResponseEntity.ok(response);
    }
}
