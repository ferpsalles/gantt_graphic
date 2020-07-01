package br.gov.sp.fatec.projetointegrador.project.repository;

import br.gov.sp.fatec.projetointegrador.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT COUNT(p) FROM Project p WHERE p.projectName like :projectName")
    Long countByProjectName(@Param("projectName") String projectName);

    @Query("SELECT p FROM Project p WHERE p.projectName like :projectName")
    List<Project> findAllByProjectName(@Param("projectName") String projectName);
}
