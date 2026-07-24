package com.kolaysoft.projectstatustracker.controller;

import com.kolaysoft.projectstatustracker.entity.Project;
import com.kolaysoft.projectstatustracker.entity.WeeklyReport;
import com.kolaysoft.projectstatustracker.repository.ProjectRepository;
import com.kolaysoft.projectstatustracker.repository.WeeklyReportRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weekly-reports")

public class WeeklyReportController {

    private final WeeklyReportRepository weeklyReportRepository;
    private final ProjectRepository projectRepository;

    public WeeklyReportController(WeeklyReportRepository weeklyReportRepository, ProjectRepository projectRepository){
        this.weeklyReportRepository = weeklyReportRepository;
        this.projectRepository = projectRepository;
    }
    @GetMapping
    public List<WeeklyReport> getAllWeeklyReports() {
        return weeklyReportRepository.findAll();
    }
    @PostMapping
    public WeeklyReport createWeeklyReport(@RequestBody WeeklyReport weeklyReport) {
        Long projectId = weeklyReport.getProject().getId();

        Project project = projectRepository.findById(projectId).orElseThrow();

        weeklyReport.setProject(project);

        return weeklyReportRepository.save(weeklyReport);
    }
    @GetMapping("/project/{projectId}")
    public List<WeeklyReport> getReportsByProjectId(@PathVariable Long projectId) {
        return weeklyReportRepository.findByProjectId(projectId);
    }

}
