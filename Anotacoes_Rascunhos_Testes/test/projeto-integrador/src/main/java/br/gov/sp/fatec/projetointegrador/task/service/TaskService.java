package br.gov.sp.fatec.projetointegrador.task.service;

import br.gov.sp.fatec.projetointegrador.task.model.Task;
import br.gov.sp.fatec.projetointegrador.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task save(Task task){
        if(task.getTaskName().isEmpty()){
            throw new RuntimeException("O titulo da tarefa não foi informado");
        }
        if(task.getProject() == null){
            throw new RuntimeException("O projeto pertencente a esta tarefa não foi informado");
        }
        if(task.getOwner() == null){
            throw new RuntimeException(("O desenvolvedor não foi informado"));
        }
        if(task.getDuration() <= 0){
            throw new RuntimeException(("A duração da tarefa não foi informada"));
        }
        if(repository.countByTaskNameAndProject(task.getTaskName(), task.getProject().getId()) > 0L) {
            throw new RuntimeException("Título já usado");
        }
        return repository.save(task);
    }
    public List<Task> findByNome(String taskName) {
        if(taskName.isEmpty()) {
            return repository.findAll();
        }
        return repository.findAllByTaskName(taskName);
    }
    public Task findById(Long id) {
        Optional<Task> optionalTask = repository.findById(id);
        if(optionalTask.isPresent()) {
            return optionalTask.get();
        } else  {
            return null;
        }
    }

    public Task update(Long id, Task task) {
        if(task.getTaskName().isEmpty()){
            throw new RuntimeException("O titulo da tarefa não foi informado");
        }
        if(task.getProject() == null){
            throw new RuntimeException("O projeto pertencente a esta tarefa não foi informado");
        }
        if(task.getOwner() == null){
            throw new RuntimeException(("O desenvolvedor não foi informado"));
        }
        if(task.getDuration() <= 0){
            throw new RuntimeException(("A duração da tarefa não foi informada"));
        }
        if(repository.countByTaskNameAndProject(task.getTaskName(), task.getProject().getId()) > 0L) {
            throw new RuntimeException("Título já usado");
        }
        Task savedTask = this.findById(id);
        if(task == null) {
            throw new RuntimeException("Tarefa não encontrada.");
        }
        savedTask.setTaskName(task.getTaskName());
        savedTask.setDuration(task.getDuration());
        savedTask.setOwner(task.getOwner());
        return repository.save(savedTask);
    }
}
