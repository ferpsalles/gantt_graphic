package br.gov.sp.fatec.projetointegrador.project.service;

import br.gov.sp.fatec.projetointegrador.project.model.Project;
import br.gov.sp.fatec.projetointegrador.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public Project save(Project project){
        if(project.getProjectName().isEmpty()){
            throw new RuntimeException("O nome do projeto não foi informado");
        }
        if(project.getStartDate() == null){
            throw new RuntimeException("A data de início não foi informada.");
        }
        if(project.getEndDate() == null){
            throw new RuntimeException("A data de entrega não foi informada.");
        }
        if(project.getEndDate().isBefore(project.getStartDate())){
            throw new RuntimeException("A data de entrega não pode ser anterior a data de início.");
        }
        if(project.getEndDate().isBefore(LocalDate.now())){
            throw new RuntimeException("A data de entrega não pode ser anterior a data atual.");
        }

        if(repository.countByProjectName(project.getProjectName()) > 0L) {
            throw new RuntimeException("Projeto já cadastrado");
        }
        return repository.save(project);
    }

    public List<Project> findByProjectName(String projectName) {
        if(projectName.isEmpty()) {
            return repository.findAll();
        }
        return repository.findAllByProjectName(projectName);
    }
    public Project findById(Long id) {
        Optional<Project> optionalProject = repository.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else  {
            return null;
        }
    }

    public Project update(Long id, Project project) {
        if(project.getProjectName().isEmpty()){
            throw new RuntimeException("O mês não foi informado");
        }
        if(project.getStartDate() == null){
            throw new RuntimeException("A data de início não foi informada.");
        }
        if(project.getEndDate() == null){
            throw new RuntimeException("A data de entrega não foi informada.");
        }
        if(project.getEndDate().isBefore(project.getStartDate())){
            throw new RuntimeException("A data de entrega não pode ser anterior a data de início.");
        }
        if(project.getEndDate().isBefore(LocalDate.now())){
            throw new RuntimeException("A data de entrega não pode ser anterior a data atual.");
        }
        if(repository.countByProjectName(project.getProjectName()) > 0L) {
            throw new RuntimeException("Projeto já cadastrado");
        }
        Project savedProject = this.findById(id);
        if(project == null) {
            throw new RuntimeException("Projeto não encontrado.");
        }
        savedProject.setProjectName(project.getProjectName());
        savedProject.setStartDate(project.getStartDate());
        savedProject.setEndDate(project.getEndDate());
        return repository.save(savedProject);
    }
}
