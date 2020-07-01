package br.gov.sp.fatec.projetointegrador.project.controller;

import br.gov.sp.fatec.projetointegrador.project.model.Project;
import br.gov.sp.fatec.projetointegrador.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> findAll() {
        return projectService.findByProjectName("");
    }

    @PostMapping
    public Project save(@RequestBody Project project)  {
        return projectService.save(project);
    }

    @PutMapping("/{id}")
    public Project update(@PathVariable("id") Long id, @RequestBody Project project) {
        return projectService.update(id, project);
    }
}
