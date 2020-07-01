package br.gov.sp.fatec.projetointegrador.taskLink.service;

import br.gov.sp.fatec.projetointegrador.task.model.Task;
import br.gov.sp.fatec.projetointegrador.taskLink.model.TaskLink;
import br.gov.sp.fatec.projetointegrador.taskLink.repository.TaskLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskLinkService {
    @Autowired
    private TaskLinkRepository repository;

    public TaskLink save(TaskLink taskLink){
        if(taskLink.getSource() <= 0){
            throw new RuntimeException("A fonte não foi informada");
        }
        if(taskLink.getTarget() <= 0d){
            throw new RuntimeException("O alvo não foi informado");
        }
        if(taskLink.getType().isEmpty()){
            throw new RuntimeException("O tipo não foi informado");
        }

        if(repository.countByType(taskLink.getType(), 0L) > 0L) {
            throw new RuntimeException("Task Link já cadastrada.");
        }
        return repository.save(taskLink);
    }

    public List<TaskLink> findByType(String type) {
        if(type.isEmpty()) {
            return repository.findAll();
        }
        return repository.findAllByType(type);
    }

    public TaskLink findById(Long id) {
        Optional<TaskLink> optionalTaskLink = repository.findById(id);
        if(optionalTaskLink.isPresent()) {
            return optionalTaskLink.get();
        } else  {
            return null;
        }
    }

    public TaskLink update(Long id, TaskLink taskLink) {
        if(taskLink.getSource() <= 0){
            throw new RuntimeException("A fonte não foi informada");
        }
        if(taskLink.getTarget() <= 0d){
            throw new RuntimeException("O alvo não foi informado");
        }
        if(taskLink.getType().isEmpty()){
            throw new RuntimeException("O tipo não foi informado");
        }
        if(repository.countByType(taskLink.getType(), 0L) > 0L) {
            throw new RuntimeException("Task Link já cadastrada.");
        }
        TaskLink savedTaskLink = this.findById(id);
        if(taskLink == null) {
            throw new RuntimeException("Task Link não encontrada");
        }
        savedTaskLink.setType(taskLink.getType());
        savedTaskLink.setSource(taskLink.getSource());
        savedTaskLink.setTarget(taskLink.getTarget());
        return repository.save(savedTaskLink);
    }
}
