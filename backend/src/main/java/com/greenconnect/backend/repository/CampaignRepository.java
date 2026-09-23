package com.greenconnect.backend.repository;

import com.greenconnect.backend.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
