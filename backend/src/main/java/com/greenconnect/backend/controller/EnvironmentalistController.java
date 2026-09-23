package com.greenconnect.backend.controller;

import com.greenconnect.backend.model.Environmentalist;
import com.greenconnect.backend.repository.EnvironmentalistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Backs the "Environmentalist & Volunteer Network" directory
@RestController
@RequestMapping("/api/environmentalists")
public class EnvironmentalistController {

    @Autowired
    private EnvironmentalistRepository environmentalistRepository;

    @GetMapping
    public List<Environmentalist> getAllEnvironmentalists() {
        return environmentalistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Environmentalist getEnvironmentalistById(@PathVariable Long id) {
        return environmentalistRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Environmentalist createEnvironmentalist(@RequestBody Environmentalist environmentalist) {
        return environmentalistRepository.save(environmentalist);
    }
}
