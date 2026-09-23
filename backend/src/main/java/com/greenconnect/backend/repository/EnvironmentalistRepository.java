package com.greenconnect.backend.repository;

import com.greenconnect.backend.model.Environmentalist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentalistRepository extends JpaRepository<Environmentalist, Long> {
}
