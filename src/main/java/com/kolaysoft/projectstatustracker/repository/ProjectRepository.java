package com.kolaysoft.projectstatustracker.repository;

import com.kolaysoft.projectstatustracker.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}