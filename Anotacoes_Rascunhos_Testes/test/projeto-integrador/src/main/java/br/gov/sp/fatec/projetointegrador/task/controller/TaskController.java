package br.gov.sp.fatec.projetointegrador.task.controller;

import br.gov.sp.fatec.projetointegrador.task.model.Task;
import br.gov.sp.fatec.projetointegrador.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> findAll() {
        return taskService.findByNome("");
    }

    @PostMapping
    public Task save(@RequestBody Task task)  {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

}
