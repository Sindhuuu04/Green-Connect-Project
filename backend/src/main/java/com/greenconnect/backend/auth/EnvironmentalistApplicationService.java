package com.greenconnect.backend.auth;

import com.greenconnect.backend.model.ApplicationStatus;
import com.greenconnect.backend.model.EnvironmentalistApplication;
import com.greenconnect.backend.model.User;
import com.greenconnect.backend.repository.EnvironmentalistApplicationRepository;
import com.greenconnect.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.greenconnect.backend.auth.dto.EnvironmentalistApplicationResponse;
import com.greenconnect.backend.model.Role;

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

    @Transactional
    public EnvironmentalistApplicationResponse approveApplication(Long applicationId) {
        EnvironmentalistApplication application =
                applicationRepository.findById(applicationId)
                        .orElseThrow(() ->
                                new RuntimeException("Application not found"));

        if (application.getStatus() != ApplicationStatus.PENDING) {
            throw new RuntimeException("Application has already been reviewed");
        }

        User user = application.getUser();
        user.setRole(Role.ENVIRONMENTALIST);

        application.setStatus(ApplicationStatus.APPROVED);

        userRepository.save(user);
        applicationRepository.save(application);

        return new EnvironmentalistApplicationResponse(application);
    }

    @Transactional
    public EnvironmentalistApplicationResponse rejectApplication(Long applicationId) {
        EnvironmentalistApplication application =
                applicationRepository.findById(applicationId)
                        .orElseThrow(() ->
                                new RuntimeException("Application not found"));

        if (application.getStatus() != ApplicationStatus.PENDING) {
            throw new RuntimeException("Application has already been reviewed");
        }

        application.setStatus(ApplicationStatus.REJECTED);
        applicationRepository.save(application);

        return new EnvironmentalistApplicationResponse(application);
    }

}