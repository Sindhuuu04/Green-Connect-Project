
package com.greenconnect.backend.auth;

import com.greenconnect.backend.auth.dto.UserProfileResponse;
import com.greenconnect.backend.model.User;
import com.greenconnect.backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserProfileService {

    private final UserRepository userRepository;

    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfileResponse getProfile(Long userId) {
        User user = findUser(userId);
        return new UserProfileResponse(user);
    }

    public UserProfileResponse updateProfile(Long userId, String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Name cannot be empty"
            );
        }

        User user = findUser(userId);
        user.setName(name.trim());

        User updatedUser = userRepository.save(user);
        return new UserProfileResponse(updatedUser);
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                ));
    }
}
