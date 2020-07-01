package br.gov.sp.fatec.projetointegrador.taskLink.controller;

import br.gov.sp.fatec.projetointegrador.task.model.Task;
import br.gov.sp.fatec.projetointegrador.taskLink.model.TaskLink;
import br.gov.sp.fatec.projetointegrador.taskLink.service.TaskLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskLinks")
public class TaskLinkController {
    @Autowired
    private TaskLinkService taskLinkService;

    @GetMapping
    public List<TaskLink> findAll() {
        return taskLinkService.findByType("");
    }

    @PostMapping
    public TaskLink save(@RequestBody TaskLink taskLink)  {
        return taskLinkService.save(taskLink);
    }

    @PutMapping("/{id}")
    public TaskLink update(@PathVariable("id") Long id, @RequestBody TaskLink taskLink) {
        return taskLinkService.update(id, taskLink);
    }
}
