package com.greenconnect.backend.repository;

import com.greenconnect.backend.model.IssueReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueReportRepository extends JpaRepository<IssueReport, Long> {
}
