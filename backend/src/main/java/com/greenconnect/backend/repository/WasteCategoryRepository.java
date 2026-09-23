package com.greenconnect.backend.repository;

import com.greenconnect.backend.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}
