package br.gov.sp.fatec.projetointegrador.task.repository;

import br.gov.sp.fatec.projetointegrador.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT COUNT(t) FROM Task t WHERE t.taskName like :taskName and t.id = :id")
    Long countByTaskNameAndProject(@Param("taskName") String taskName, @Param("id") Long id);

    @Query("SELECT t FROM Task t WHERE t.taskName like :taskName")
    List<Task> findAllByTaskName(@Param("taskName") String taskName);

}
