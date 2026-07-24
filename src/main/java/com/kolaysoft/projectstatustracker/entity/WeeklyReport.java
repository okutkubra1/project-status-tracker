package com.kolaysoft.projectstatustracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter

public class WeeklyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate weekStartDate;
    private Integer completionPercentage;
    private String completedWork;
    private String risksOrBlockers;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
