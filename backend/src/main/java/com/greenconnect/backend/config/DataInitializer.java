package com.greenconnect.backend.config;

import com.greenconnect.backend.model.Role;
import com.greenconnect.backend.model.User;
import com.greenconnect.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        String adminEmail = "admin@greenconnect.com";

        if (!userRepository.existsByEmail(adminEmail)) {

            User admin = new User();

            admin.setName("Green Connect Admin");
            admin.setEmail(adminEmail);

            admin.setPassword(
                    passwordEncoder.encode("Admin@123")
            );

            admin.setRole(Role.SUPER_ADMIN);

            userRepository.save(admin);

            System.out.println(
                    "Green Connect Super Admin created."
            );
        }
    }
}