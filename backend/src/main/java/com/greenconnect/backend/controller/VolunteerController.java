package com.greenconnect.backend.controller;

import com.greenconnect.backend.model.VolunteerOpportunity;
import com.greenconnect.backend.repository.VolunteerOpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Backs the "Volunteering Opportunities Board" page
@RestController
@RequestMapping("/api/volunteer-opportunities")
public class VolunteerController {

    @Autowired
    private VolunteerOpportunityRepository volunteerOpportunityRepository;

    @GetMapping
    public List<VolunteerOpportunity> getAllOpportunities() {
        return volunteerOpportunityRepository.findAll();
    }

    @GetMapping("/{id}")
    public VolunteerOpportunity getOpportunityById(@PathVariable Long id) {
        return volunteerOpportunityRepository.findById(id).orElse(null);
    }

    @PostMapping
    public VolunteerOpportunity createOpportunity(@RequestBody VolunteerOpportunity opportunity) {
        return volunteerOpportunityRepository.save(opportunity);
    }
}
