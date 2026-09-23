package com.greenconnect.backend.controller;

import com.greenconnect.backend.model.IssueReport;
import com.greenconnect.backend.repository.IssueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

// Backs the "Report an Issue" form
@RestController
@RequestMapping("/api/issue-reports")
public class IssueReportController {

    @Autowired
    private IssueReportRepository issueReportRepository;

    @GetMapping
    public List<IssueReport> getAllReports() {
        return issueReportRepository.findAll();
    }

    @GetMapping("/{id}")
    public IssueReport getReportById(@PathVariable Long id) {
        return issueReportRepository.findById(id).orElse(null);
    }

    @PostMapping
    public IssueReport createReport(@RequestBody IssueReport report) {
        report.setReportedAt(LocalDateTime.now());
        report.setStatus("OPEN");
        return issueReportRepository.save(report);
    }
}
