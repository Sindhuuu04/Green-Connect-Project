package com.greenconnect.backend.controller;

import com.greenconnect.backend.model.WasteCategory;
import com.greenconnect.backend.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Backs the "Waste Management & Recycling Guide" page
@RestController
@RequestMapping("/api/waste-categories")
public class WasteManagementController {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public WasteCategory getCategoryById(@PathVariable Long id) {
        return wasteCategoryRepository.findById(id).orElse(null);
    }

    @PostMapping
    public WasteCategory createCategory(@RequestBody WasteCategory category) {
        return wasteCategoryRepository.save(category);
    }
}
