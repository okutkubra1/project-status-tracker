package com.kolaysoft.projectstatustracker.repository;

import com.kolaysoft.projectstatustracker.entity.WeeklyReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeeklyReportRepository extends JpaRepository<WeeklyReport, Long> {

    List<WeeklyReport> findByProjectId(Long projectId);

}