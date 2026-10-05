package com.greenconnect.backend.auth;

import com.greenconnect.backend.model.ApplicationStatus;
import com.greenconnect.backend.model.EnvironmentalistApplication;
import com.greenconnect.backend.model.User;
import com.greenconnect.backend.repository.EnvironmentalistApplicationRepository;
import com.greenconnect.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentalistApplicationService {

    private final EnvironmentalistApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public EnvironmentalistApplicationService(
            EnvironmentalistApplicationRepository applicationRepository,
            UserRepository userRepository
    ) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }

    public EnvironmentalistApplication apply(
            Long userId,
            String reason
    ) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );

        if (applicationRepository.findByUser(user).isPresent()) {
            throw new RuntimeException(
                    "You have already submitted an application"
            );
        }

        EnvironmentalistApplication application =
                new EnvironmentalistApplication();

        application.setUser(user);
        application.setReason(reason);
        application.setStatus(ApplicationStatus.PENDING);

        return applicationRepository.save(application);
    }
    public java.util.List<EnvironmentalistApplication> getPendingApplications() {

        return applicationRepository.findByStatus(
                ApplicationStatus.PENDING
        );
    }
}