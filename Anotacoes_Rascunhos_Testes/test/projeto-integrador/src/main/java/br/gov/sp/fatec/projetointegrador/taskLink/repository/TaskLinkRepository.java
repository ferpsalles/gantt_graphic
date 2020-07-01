package br.gov.sp.fatec.projetointegrador.taskLink.repository;

import br.gov.sp.fatec.projetointegrador.task.model.Task;
import br.gov.sp.fatec.projetointegrador.taskLink.model.TaskLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskLinkRepository extends JpaRepository<TaskLink, Long> {
    @Query("select count(t) from TaskLink t where t.type like :type and t.id <> :id")
    public Long countByType(@Param("type") String type, @Param("id") Long id);

    @Query("SELECT t FROM TaskLink t WHERE t.type like :type")
    public List<TaskLink> findAllByType(@Param("type") String type);




}
