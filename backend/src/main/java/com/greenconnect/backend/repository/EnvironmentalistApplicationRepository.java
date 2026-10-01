package com.greenconnect.backend.repository;

import com.greenconnect.backend.model.EnvironmentalistApplication;
import com.greenconnect.backend.model.ApplicationStatus;
import com.greenconnect.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface EnvironmentalistApplicationRepository
        extends JpaRepository<EnvironmentalistApplication, Long> {

    Optional<EnvironmentalistApplication> findByUser(User user);

    List<EnvironmentalistApplication> findByStatus(
            ApplicationStatus status
    );
}