package br.gov.sp.fatec.projetointegrador.taskLink.model;

import br.gov.sp.fatec.projetointegrador.project.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name="taskLink")
@NoArgsConstructor
@AllArgsConstructor
public class TaskLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Integer source;

    private Integer target;

    private String type;
}
