package com.greenconnect.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Maps to the "Waste Management & Recycling Guide" module
@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;          // e.g. Organic, Recyclable, Plastic, E-Waste, Hazardous
    private String description;
    private String disposalGuidance;

    public WasteCategory() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDisposalGuidance() { return disposalGuidance; }
    public void setDisposalGuidance(String disposalGuidance) { this.disposalGuidance = disposalGuidance; }
}
