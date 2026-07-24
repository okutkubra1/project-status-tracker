package com.kolaysoft.projectstatustracker.controller;

import com.kolaysoft.projectstatustracker.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;
import com.kolaysoft.projectstatustracker.entity.Project;

import java.util.List;

@RestController
@RequestMapping("/api/projects")

public class ProjectController {
    @GetMapping
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id){
        return projectRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Project updateProjectById(@PathVariable Long id, @RequestBody Project updateProject){
        Project existingProject = projectRepository.findById(id).orElseThrow();
        existingProject.setName(updateProject.getName());
        existingProject.setDescription(updateProject.getDescription());
        existingProject.setStartDate(updateProject.getStartDate());
        existingProject.setDeadline(updateProject.getDeadline());

        return projectRepository.save(existingProject);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable Long id){
        projectRepository.deleteById(id);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project){
        return projectRepository.save(project);
    }

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
