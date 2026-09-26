package com.greenconnect.backend.auth;

import com.greenconnect.backend.auth.dto.RegisterRequest;
import com.greenconnect.backend.model.Role;
import com.greenconnect.backend.model.User;
import com.greenconnect.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Never store the plain password
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        // Normal registration always creates a USER
        user.setRole(Role.USER);

        return userRepository.save(user);
    }
}