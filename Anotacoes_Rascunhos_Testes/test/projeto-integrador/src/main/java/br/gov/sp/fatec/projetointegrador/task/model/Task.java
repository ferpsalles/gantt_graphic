package br.gov.sp.fatec.projetointegrador.task.model;

import br.gov.sp.fatec.projetointegrador.owner.model.Owner;
import br.gov.sp.fatec.projetointegrador.project.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@Table(name="task")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String taskName;

    private Double duration;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    private Owner owner;

    @ManyToOne
    private Project project;


}
